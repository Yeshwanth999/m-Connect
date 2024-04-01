var usermail = sessionStorage.getItem("usermail");
console.log(usermail);

if (usermail != " " && usermail !== null) {
  geturlLink = 'http://localhost:8081/user/getprofileimage/' + usermail + '';

  geturlLink1forName = 'http://localhost:8081/user/getemployee/' + usermail + '';

  console.log(usermail + "   : " + "Link :" + geturlLink);

} else {
  console.log("gmail is not found.");
}

jQuery(document).ready(function () {
  // Fetch data from the server when the page loads
  $.ajax({
    type: 'GET',
    url: geturlLink,
    responseType: 'arraybuffer',
    success: function (response) {
      if (response) {
        // Convert the binary data to base64 string
        var binaryData = new Uint8Array(response);
        var imageData = btoa(String.fromCharCode.apply(null, binaryData));

        // Set the src attribute of the image element
        var imageUrl = 'data:image/jpeg;base64,' + imageData;
        $('#profileImage').attr('src', imageUrl);

        console.log("Image added successfully.");
      } else {
        console.error('No image data found in the response');
      }
    },
    error: function (error) {
      console.error('Error fetching profile image:', error);
    }
  });
});


$(document).ready(function () {
  // Fetch data from the server when the page loads
  $.ajax({
    type: 'GET',
    url: geturlLink1forName, // Replace 'user/data' with your actual endpoint
    success: function (responseData) {
      // Populate the form fields with the retrieved data
      $('#firstname').val(responseData.firstname);
      console.log(firstname);
    },
    error: function (error) {
      console.error('Error fetching data:', error);
    }
  });
});


$('#logoutButton').on('click', function () {

  const type = 'GET';
  const url = 'http://localhost:8081/user/logout';

  fetchLogout(url, type);
});


