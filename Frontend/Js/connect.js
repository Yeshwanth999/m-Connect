// Access-Control-Allow-Origin: "http://localhost:3000";

// $('#signinBtn').on('click', function () {
//     const gmail = $('#gmail').val();
//     const password = $('#password').val();
//     const isAdmin = $('#adminCheckbox').is(':checked');

//     const formData = {
//         gmail: gmail,
//         password: password,
//         isAdmin: isAdmin
//     };
//     console.log(gmail);
//     console.log(password);

//     // Call the updated function for AJAX communication
//     sendFormData('http://localhost:8081/login', formData, 'formBox');
// });


function sendFormData(url, type, data, elementId) {
    // for login page
    console.log('Sending request to :', url)
    console.log('Rquest body  :', JSON.stringify(data))

    $.ajax({
        type: type,
        url: url,  // Make sure the URL is correct
        contentType: 'application/json',
        data: JSON.stringify(data),

        success: function (responseData) {

            console.log('Response received:', responseData);

            document.getElementById(elementId).innerHTML = responseData;

            // Assuming the responseData is a URL for redirection

            if (responseData === 'success') {
                console.log('Redirecting to success page');
                window.location.href = nextPageLink;
            } else {
                // Handle other cases if needed
                console.log('Response data:', responseData);

            }
            // window.location.href = 'http://127.0.0.1:5502/Frontend/employeeDashboard.html';
        },
        error: function (error) {
            console.error('Error sending data:', error);
        }

    });
}



function sendFormData1(url, type, data, elementId) {
    console.log("Flow ok");
    // console.log('Sending request to :', url)
    // console.log('Request body  :', JSON.stringify(data))

    $.ajax({
        type: type,
        url: url,  // Make sure the URL is correct
        contentType: 'application/json',
        data: JSON.stringify(data),

        success: function (responseData, textStatus, xhr) {

            console.log('Response received:', responseData);

            document.getElementById(elementId).innerHTML = responseData.message;

            // Assuming the responseData is a URL for redirection

            if (xhr.status == 200) {
                console.log('Redirecting to success page');
                localStorage.setItem("gmail", data.gmail);

                // let otpNumber = document.getElementById(elementId).innerHTML = responseData;
            } else {
                // Handle other cases if needed
                console.log('Response data --else method:', responseData);
            }
        },
        error: function (error) {
            console.error('Error sending data:', error);
        }

    });
}

function verifyOtp(url, type, data, elementId) {

    console.log('Sending request to :', url)
    console.log('Request body  :', JSON.stringify(data));

    $.ajax({
        type: type,
        url: url,  // Make sure the URL is correct
        contentType: 'application/json',
        data: JSON.stringify(data),

        success: function (responseData, textStatus, xhr) {

            // console.log('Response received:', responseData);

            document.getElementById(elementId).innerHTML = responseData.message;

            // Assuming the responseData is a URL for redirection

            if (xhr.status === 200) {
                console.log('Redirecting to success page');
                window.location.href = 'ResetPwd.html';
            } else {
                // Handle other cases if needed
                console.log('Response data:', responseData);
            }
        },
        error: function (error) {
            console.error('Error sending data:', error);
        }

    });
}


