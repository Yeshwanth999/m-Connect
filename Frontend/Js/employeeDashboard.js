// sessionStorage.setItem("usermail","rajeshbalu.addala@gmail.com")
var usermail = sessionStorage.getItem("usermail");
console.log(usermail);

if (usermail != " " && usermail !== null) {

  let geturlLink1forName = 'http://localhost:8081/user/getemployee/' + usermail

  console.log(usermail + "   : " + "Link :" + geturlLink1forName);

} else {
  console.log("gmail is not found.");
}


jQuery(document).ready(function () {
  var geturlLink = 'http://localhost:8081/user/getprofileimage/' + usermail;
  // Fetch data from the server when the page loads
  $.ajax({
    type: 'GET',
    url: geturlLink,
    success: function (response) {
      console.log("Response:", response);
      var image = $("<img>").attr("src", geturlLink).attr("alt", "Dog Image");
      $('#imageContainer').html(image);

    },
    error: function (error) {
      console.error('Error fetching profile image:', error);
    }
  });
});



// jQuery(document).ready(function () {
//   // Fetch data from the server when the page loads
//   $.ajax({
//     type: 'GET',
//     url: geturlLink,
//     xhrFields: {
//       responseType: 'arraybuffer'
//     },
//     success: function (response) {
//       console.log("Response:", response);

//       // Convert ArrayBuffer to Blob
//       const blob = new Blob([response], { type: 'image/jpeg' });

//       // Create an object URL from the Blob
//       const imageUrl = URL.createObjectURL(blob);

//       // Display the image in an <img> element with id 'profileImage'
//       $('#profileImage').attr('src', imageUrl);

//     },
//     error: function (error) {
//       console.error('Error fetching profile image:', error);
//     }
//   });
// });


$(document).ready(function () {
  // Fetch data from the server when the page loads
  $.ajax({
    type: 'GET',
    url: 'http://localhost:8081/user/getemployee/' + usermail, // Replace 'user/data' with your actual endpoint
    success: function (responseData) {
      // Populate the form fields with the retrieved data
      //$('#firstname').val(responseData.firstname);
      //console.log(firstname);

      $('#firstnameDisplay').text(responseData.firstname);
    },
    error: function (error) {
      console.error('Error fetching data:', error);
    }
  });
});


// $('#logoutButton').on('click', function () {

//   const type = 'GET';
//   const url = 'http://localhost:8081/user/logout';

//   fetchLogout(url, type);
// });


// Logout Functionality Start
$('#logoutButton').on('click', function () {

  const type = 'GET';
  const url = 'http://localhost:8081/user/logout';

  fetchLogout(url, type);

  console.log("Hi This is Employee log out...")

  sessionStorage.removeItem("usermail");
  sessionStorage.removeItem("password");
  window.location.href = "SignIn.html";
});
// Logout Functionality End


// org.springframework.web.multipart.support.StandardMultipartHttpServletRequest$StandardMultipartFile@3903b521


// org.springframework.web.multipart.support.StandardMultipartHttpServletRequest$StandardMultipartFile@3903b521