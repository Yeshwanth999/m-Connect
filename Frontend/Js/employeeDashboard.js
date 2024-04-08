var usermail = sessionStorage.getItem("usermail");
console.log(usermail);

if (usermail != " " && usermail !== null) {
  geturlLink = 'http://localhost:8081/user/getprofileimage/' + usermail + '';

  geturlLink1forName = 'http://localhost:8081/user/getemployee/' + usermail + '';

  console.log(usermail + "   : " + "Link :" + geturlLink);

} else {
  console.log("gmail is not found.");
}

// $(document).ready(function () {
//   // Fetch image data from the server when the page loads
//   $.ajax({
//     type: "GET",
//     url: geturlLink,
//     responseType: "arraybuffer",
//     success: function (response) {
//       if (response) {
//         // Convert the binary data to base64 string
//         var binaryData = new Uint8Array(response);
//         var imageData = btoa(String.fromCharCode.apply(null, binaryData));

//         // Set the src attribute of a new image element
//         var imageUrl = "data:image/jpeg;base64," + imageData;
//         var imageElement = $("<img>").attr("src", imageUrl);

//         // Append the image element to the imageContainer
//         var $imageContainer = $("#imageContainer");
//         if ($imageContainer.length) {
//           $imageContainer.append(imageElement);
//           console.log("Image added successfully.");
//           console.log(imageUrl);
//           console.log(imageElement);
//         } else {
//           console.error("Image container element not found");
//         }
//       } else {
//         console.error("No image data found in the response");
//       }
//     },
//     error: function (error) {
//       console.error("Error fetching profile image:", error);
//     },
//   });
// });


$(document).ready(function () {
  // Fetch image data from the server when the page loads
  $.ajax({
    type: "GET",
    url: geturlLink, // Make sure this is the correct URL
    // responseType: "arraybuffer", // Comment this line if not needed
    success: function (response) {
      if (response) {
        // Convert the binary data to base64 string
        var imageData = response; // Assuming the server returns base64 directly

        // Set the src attribute of a new image element
        var imageUrl = "data:image/jpeg;base64," + imageData;
        var imageElement = $("<img>").attr("src", imageUrl);

        // Append the image element to the imageContainer
        var $imageContainer = $("#imageContainer");
        if ($imageContainer.length) {
          $imageContainer.append(imageElement);
          console.log("Image added successfully.");
          console.log(imageUrl);
          console.log(imageElement);
        } else {
          console.error("Image container element not found");
        }
      } else {
        console.error("No image data found in the response");
      }
    },
    error: function (error) {
      console.error("Error fetching profile image:", error);
    },
  });
});




$(document).ready(function () {
  // Fetch data from the server when the page loads
  $.ajax({
    type: 'GET',
    url: geturlLink1forName, // Replace 'user/data' with your actual endpoint
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


$('#logoutButton').on('click', function () {

  const type = 'GET';
  const url = 'http://localhost:8081/user/logout';

  fetchLogout(url, type);
});


