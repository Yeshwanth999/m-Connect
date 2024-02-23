const { json } = require("stream/consumers");

function sendFormData(url, type, data, elementId) {
    // for login page
    console.log('Sending request to :', url)
    console.log('Rquest body  :', JSON.stringify(data))

    $.ajax({
        type: type,
        url: url,  // Make sure the URL is correct
        contentType: 'application/json',
        data: JSON.stringify(data),

        success: function (responseData, textStatus, xhr) {

            console.log('Response received:', responseData);

            document.getElementById(elementId).innerHTML = responseData;


            if (responseData == 'Admin') {
                // if (xhr.status == 200) {
                console.log('Redirecting to AdminPage');
                window.location.href = 'adminHome.html';

            } else if (responseData == 'Employee') {
                console.log('Redirecting to EmployeePage');
                window.location.href = 'employeeDashboard.html';
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

function ResetPwd(url, type, data, elementId) {
    // for login page
    console.log('Sending request to :', url)
    console.log('Rquest body  :', JSON.stringify(data))

    $.ajax({
        type: type,
        url: url,  // Make sure the URL is correct
        contentType: 'application/json',
        data: JSON.stringify(data),

        success: function (responseData, textStatus, xhr) {

            console.log('Response received:', responseData);

            // document.getElementById(elementId).innerHTML = responseData.password;

            // Assuming the responseData is a URL for redirection

            // if (responseData === 'success')
            if (xhr.status == 200) {
                console.log('Redirecting to success page');
                window.location.href = 'home.html';
            } else {
                // Handle other cases if needed
                console.log('Response data:', responseData);
                console.log('----Not Redirecting to success page----');

            }
            // window.location.href = 'http://127.0.0.1:5502/Frontend/employeeDashboard.html';
        },
        error: function (error) {
            console.error('Error sending data:', error);
        }

    });
}



function sendEmpData(url, type, data, elementID) {

    $.ajax({
        type: type,
        url: url,  // Make sure the URL is correct
        contentType: 'application/json',
        data: JSON.stringify(data),

        success: function (responseData, textStatus, xhr) {
            if (textStatus == 'success') {
                window.location.href = "adminDashboard.html"
            } else {
                console.log('response data:', responseData);
            }
        },
        error: function (error) {
            console.error('Error Sending data:', error);
        }

    });

}

function sendApplyLeaveData(url, type, data) {
    $.ajax({
        type: type,
        url: url,
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (responseData, textStatus, xhr) {
            if (xhr.status === 200) {
                alert('Request sucessfully sent')
            } else {
                console.log('response: ', responseData);
            }
        },
        error: function (error) {
            console.error("error sending data: ", error);
        }
    });
}

function sendCancelLeaveData(url, type, data) {
    $.ajax({
        type: type,
        url: url,
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (responseData, textStatus, xhr) {
            if (xhr.status === 200) {
                alert('Request sucessfully sent')
            } else {
                console.log('response: ', responseData);
            }
        },
        error: function (error) {
            console.error("error sending data: ", error);
        }
    });
}

function sendLeaveHistoryData(url, type, data) {
    $.ajax({
        type: type,
        url: url,
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (responseData, textStatus, xhr) {
            if (xhr.status === 200) {
                historyData(responseData);
            } else {
                console.log("response data: ", responseData);
            }
        },
        error: function (error) {
            console.error("error: ", error);
        }
    })
}

function sendLeaveBalanceData(url, type, data) {
    $.ajax({
        type: type,
        url: url,
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (responseData, textStatus, xhr) {
            if (xhr.status === 200) {
                leavebalanceData(responseData);
            } else {
                console.log("response data: ", responseData);
            }
        },
        error: function (error) {
            console.error("error: ", error);
        }
    })
}

function sendLeaveRequestsData(url, type, data) {
    $.ajax({
        type: type,
        url: url,
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (responseData, textStatus, xhr) {
            if (xhr.status === 200) {
                requestsData(responseData);
            } else {
                console.log("response data: ", responseData);
            }
        },
        error: function (error) {
            console.error("error: ", error);
        }
    })
}

//CODE STARTED-->
//double-servers  ajax calling code  example-1

// function sendEmpData(url, type, data, elementID) {

//     $.ajax({
//         url: 'http://localhost:8082/admin/register',
//         method: 'POST',
//         data: data,
//         success: function (adminResponse, textStatus, xhr) {
//             // Registration successful
//             if (textStatus == 'success') {
//                 console.log("Successfully registered: ", adminResponse);
//             }
//             else {
//                 console.log("something error is occures in adminside.")
//             }

//             // Now make AJAX request to employee service for update
//             $.ajax({
//                 url: 'http://localhost:8081/user/update',
//                 method: 'POST',
//                 data: JSON.stringify(data),
//                 success: function (employeeResponse, textStatus, xhr) {
//                     // Update successful

//                     if (textStatus == 'success') {
//                         console.log("User updated successfully:", employeeResponse);
//                     }
//                     else {
//                         console.log("something error is occures in userside.")
//                     }
//                 },
//                 error: function (employeeError) {
//                     // Handle error from employee service.
//                     console.error("Error updating user:", employeeError);
//                 }
//             });
//         },
//         error: function (adminError) {
//             // Handle error from admin service
//             console.error("Error registering user:", adminError);
//         }
//     });

// }


//--->CODE ENDED;

function sendEmpData(url, type, data, elementID) {
    $.ajax({
        type: type,
        url: url,  // Make sure the URL is correct
        contentType: 'application/json',
        data: JSON.stringify(data),

        success: function (responseData, textStatus, xhr) {

            if (xhr.status == 201) {
                window.location.href = 'adminDashboard.html';
            } else {
                console.log('response data:', responseData);
            }
        },
        error: function (error) {
            console.error('Error Sending data:', error);
        }

    });

}

function fetchLogout(url, type) {

    $.ajax({
        type: type,
        url: url,  // Make sure the URL is correct
        contentType: 'application/json',
        // data: JSON.stringify(),

        success: function (response, textStatus, xhr) {
            if (xhr.status == 200) {
                console.log('Logout successful');
                window.location.href = 'SignIn.html'; // Redirect to login page // Parse response JSON (if any)
            } else {
                throw new Error('Logout request failed');
            }
        },
        error: function (error) {
            console.log(xhr.status);
            console.log(textStatus);
            console.error('Logout request failed:', error);
        }
    });
}


