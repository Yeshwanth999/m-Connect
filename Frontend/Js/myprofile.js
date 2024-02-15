// personal info start //
document.getElementById("firstname").disabled = true;
document.getElementById("lastname").disabled = true;
document.getElementById("dob").disabled = true;
document.getElementById("gender").disabled = true;
document.getElementById("blood_group").disabled = true;
document.getElementById("marital_status").disabled = true;  


function toggleEditMode() {
    var inputs = document.querySelectorAll('.input-underlined');
    var selects = document.querySelectorAll('select');
    var buttons = document.querySelector('.button-container');

    inputs.forEach(function(input) {
        input.disabled = !input.disabled;
    });

    selects.forEach(function(select) {
        select.disabled = !select.disabled;
    });

 
    buttons.style.display = 'block';
}

function cancelEdit() {
    var inputs = document.querySelectorAll('.input-underlined');
    var selects = document.querySelectorAll('select');
    var buttons = document.querySelector('.button-container');

    inputs.forEach(function(input) {
        input.disabled = true;
    });

    selects.forEach(function(select) {
        select.disabled = true;
    });

    buttons.style.display = 'none';
}

function saveEdit() {

    cancelEdit();
}
// personal info end //



// contact info start //
document.getElementById("email").disabled=true;
document.getElementById("email1").disabled=true;
document.getElementById("phonenumber").disabled=true;
document.getElementById("phonenumber1").disabled=true;

function contactOnclick() {
    var inputs = document.querySelectorAll('.input-underlined1');
    var buttons = document.querySelector('.button-container1');

    inputs.forEach(function(input) {
        input.disabled = !input.disabled;
    });

    buttons.style.display = 'block';
}

function cancelContact() {
    var inputs = document.querySelectorAll('.input-underlined1');
    var buttons = document.querySelector('.button-container1');

    inputs.forEach(function(input) {
        input.disabled = true;
    });


    buttons.style.display = 'none';
}

function saveContact() {
    
    cancelContact();
}
// contact info end //




// Address info start //
document.getElementById("currentAddress").disabled=true;
document.getElementById("currentCountry").disabled=true;
document.getElementById("currentState").disabled=true;
document.getElementById("currentCity").disabled=true;
document.getElementById("currentPincode").disabled=true;

document.getElementById("permanentAddress").disabled=true;
document.getElementById("permanentCountry").disabled=true;
document.getElementById("permanentState").disabled=true;
document.getElementById("permanentCity").disabled=true;
document.getElementById("permanentPincode").disabled=true;
// document.getElementById("housetype").disabled=true
// document.getElementById("stayingsince").disabled=true
// document.getElementById("livingin").disabled=true


function addressOnclick() {
    var inputs = document.querySelectorAll('.input-underlined2');
    var buttons = document.querySelector('.button-container2');

    inputs.forEach(function(input) {
        input.disabled = !input.disabled;
    });

    buttons.style.display = 'block';
}

function cancelAddress() {
    var inputs = document.querySelectorAll('.input-underlined2');
    var buttons = document.querySelector('.button-container2');

    inputs.forEach(function(input) {
        input.disabled = true;
    });



    buttons.style.display = 'none';
}

function saveAddress() {

    cancelAddress();
}
// social info start //
document.getElementById("linkedin").disabled=true;
document.getElementById("twitter").disabled=true;
document.getElementById("facebook").disabled=true;

// error for pincode // 
document.getElementById('currentPincode').addEventListener('blur', function() {
    var pincode = this.value.trim();
    var pincodeRegex = /^\d{6}$/; 
    
    if (pincode-2 === '' || !pincodeRegex.test(pincode-2)) {
        document.getElementById('currentPincode').style.borderBottomColor = '';
        document.getElementById('pincode-error').innerText = 'Please Enter Valid Pincode';
        document.getElementById('pincode-error').style.color = 'red';
    } else {
        document.getElementById('currentPincode').style.borderBottomColor = '#ccc';
        document.getElementById('pincode-error').innerText = '';
    }
});


document.getElementById('permanentPincode').addEventListener('blur', function() {
    var pincode = this.value.trim();
    var pincodeRegex = /^\d{6}$/; 
    

    if (pincode-2 === '' || !pincodeRegex.test(pincode-2)) {
        document.getElementById('permanentPincode').style.borderBottomColor = ''; 
        document.getElementById('pincode-error').innerText = 'Please Enter Valid Pincode'; 
        document.getElementById('pincode-error').style.color = 'red';
    } else {
        document.getElementById('permanentPincode').style.borderBottomColor = '#ccc';
        document.getElementById('pincode-error').innerText = '';
    }
});

// show addressentire div after clickig pencil toggle // 

// document.getElementById('addressOnclick').addEventListener('click', function() {
//     var addressentire = document.getElementById('addressentire');
//     addressentire.style.display = 'block'
// })

// logic to hide the divs //
// function saveAddress(){
//     var addressentire = document.getElementById('addressentire');
//     addressentire.style.display = 'none'
// }
// function cancelAddress(){
//     var addressentire = document.getElementById('addressentire');
//     addressentire.style.display = 'none'
// }


// // on change current address to permanent address after clicking in check box //
// function copyAddress() {
//     var checkbox = document.getElementById("sameAddressCheckbox");
//     var currentAddressFields = document.querySelectorAll(".currentaddress");
//     var permanentAddressFields = document.querySelectorAll(".permanentaddress");

//     if (checkbox.checked) {
//         permanentAddressFields.forEach(function(permanentField, index) {
//             permanentField.value = currentAddressFields[index].value;
//         });
//     } else {
//         permanentAddressFields.forEach(function(permanentField) {
//             permanentField.value = "";
//         });
//     }
// }

function socialOnclick() {
    var inputs = document.querySelectorAll('.input-underlined3');
    var buttons = document.querySelector('.button-container3');

    inputs.forEach(function(input) {
        input.disabled = !input.disabled;
    });

    buttons.style.display = 'block';
}

function cancelsocial() {
    var inputs = document.querySelectorAll('.input-underlined3');
    var buttons = document.querySelector('.button-container3');

    inputs.forEach(function(input) {
        input.disabled = true;
    });

    buttons.style.display = 'none';
}

function savesocial() {

    cancelsocial();
}

// Enable checkbox after entering current address inputs //
function copyAddress() {
    var checkbox = document.getElementById("sameAddressCheckbox");
    var currentAddress = document.getElementById("currentAddress").value;
    var currentCountry = document.getElementById("currentCountry").value;
    var currentState = document.getElementById("currentState").value;
    var currentCity = document.getElementById("currentCity").value;
    var currentPincode = document.getElementById("currentPincode").value;

    if (checkbox.checked) {
        document.getElementById("permanentAddress").value = currentAddress;
        document.getElementById("permanentCountry").value = currentCountry;
        document.getElementById("permanentState").value = currentState;
        document.getElementById("permanentCity").value = currentCity;
        document.getElementById("permanentPincode").value = currentPincode;
    } else {
        document.getElementById("permanentAddress").value = "";
        document.getElementById("permanentCountry").value = "";
        document.getElementById("permanentState").value = "";
        document.getElementById("permanentCity").value = "";
        document.getElementById("permanentPincode").value = "";
    }
}

// Enable checkbox if all current address inputs are filled
document.querySelectorAll('.currentaddress').forEach(function(input) {
    input.addEventListener('input', function() {
        var allInputsFilled = true;
        document.querySelectorAll('.currentaddress').forEach(function(input) {
            if (input.value.trim() === '') {
                allInputsFilled = false;
            }
        });
        document.getElementById("sameAddressCheckbox").disabled = !allInputsFilled;
    });
});


// tranfering data using json// 
$('#saveEdit').on('click', function (){
    var firstname = $('#firstname').val();
    var secondname = $('#secondname').val();    
    var dob = $('#dob').val();
    var gender = $('#gender').val();
    var blood_group = $('#blood_group').val();

    jsonObject = {
        "firstname":"",
        "secondname":"",
        "dob":"",
        "gender":"",
        "blood_group":"",
    }
    jsonObject.firstname=firstname
    jsonObject.secondname=secondname
    jsonObject.dob=dob
    jsonObject.gender=gender
    jsonObject.blood_group=blood_group

    var str = JSON.stringify(jsonObject);
    document.write(str);

});

$('#saveContact').on('click', function (){
    var email = $('#email').val();
    var email1 = $('#email1').val();
    var phonenumber = $('#phonenumber').val();
    var phonenumber1 = $('#phonenumber1').val();

    jsonObject = {
        "email":"",
        "email1":"",
        "phonenumber":"",
        "phonenumber1":"",
    }
    jsonObject.email=email
    jsonObject.email1=email1
    jsonObject.phonenumber=phonenumber
    jsonObject.phonenumber1=phonenumber1

    var str = JSON.stringify(jsonObject);
    document.write(str);

});

$('#saveAddress').on('click', function (){
    var currentAddress = $('#currentAddress').val();
    var currentCountry = $('#currentCountry').val();
    var currentState = $('#currentState').val();
    var currentCity = $('#currentCity').val();
    var currentPincode = $('#currentPincode').val();

    var permanentAddress = $('#permanentAddress').val();
    var permanentCountry = $('#permanentCountry').val();
    var permanentState = $('#permanentState').val();
    var permanentCity = $('#permanentCity').val();
    var permanentPincode = $('#permanentPincode').val();


    jsonObject = {
        "currentAddress":"",
        "currentCountry":"",
        "currentState":"",
        "currentCity":"",
        "currentPincode":"",
        "permanentAddress":"",
        "permanentCountry":"",
        "permanentState":"",
        "permanentCity":"",
        "permanentPincode":"",
    }
    jsonObject.currentAddress=currentAddress
    jsonObject.currentCountry=currentCountry
    jsonObject.currentState=currentState
    jsonObject.currentCity=currentCity
    jsonObject.currentPincode=currentPincode
    jsonObject.permanentAddress=permanentAddress
    jsonObject.permanentCountry=permanentCountry
    jsonObject.permanentState=permanentState
    jsonObject.permanentCity=permanentCity
    jsonObject.permanentPincode=permanentPincode

    var str = JSON.stringify(jsonObject);
    document.write(str);

});

$('#savesocial').on('click', function (){
    var linkedin = $('#linkedin').val();
    var twitter = $('#twitter').val();
    var facebook = $('#facebook').val();


    jsonObject = {
        "linkedin":"",
        "twitter":"",
        "facebook":"",

    }
    jsonObject.linkedin=linkedin
    jsonObject.twitter=twitter
    jsonObject.facebook=facebook


    var str = JSON.stringify(jsonObject);
    document.write(str);

});

// input errors //
// Function to validate first name input
function validateFirstName() {
    var firstNameInput = document.getElementById('firstname');
    var firstNameError = document.getElementById('firstNameError');
    var namePattern = /^[a-zA-Z\s.]{1,20}$/;

    if (!namePattern.test(firstNameInput.value)) {
        firstNameError.textContent = 'Please enter valid name';
        firstNameError.style.color = 'red';
    } else {
        firstNameError.textContent = '';
        return true;
    }
}


// Function to validate last name input
function validateLastName() {
    var lastNameInput = document.getElementById('lastname');
    var lastNameError = document.getElementById('lastNameError');
    var namePattern = /^[a-zA-Z\s.]{1,20}$/;

    if (!namePattern.test(lastNameInput.value)) {
        lastNameError.textContent = 'Please enter valid name';
        lastNameError.style.color = 'red';
        return false;
    } else {
        lastNameError.textContent = '';
        return true;
    }
}
document.getElementById('firstname').addEventListener('input', validateFirstName);
document.getElementById('lastname').addEventListener('input', validateLastName);


// error message for official_mail
function validateEmail() {
    var emailInput = document.getElementById('email');
    var emailError = document.getElementById('official_mail');
    var emailPattern = /^[a-zA-Z0-9._%+-]+@gmail\.com$/;

    if (!emailPattern.test(emailInput.value)) {
        emailError.textContent = 'Please enter a valid Email address';
        emailError.style.color = 'red';
    } else {
        emailError.textContent = '';
        return true;
    }
}
document.getElementById('email').addEventListener('input', function() {
    validateEmail();
});

// error message for personal_mail
function validateEmail() {
    var emailInput = document.getElementById('email1');
    var emailError = document.getElementById('personal_mail');
    var emailPattern = /^[a-zA-Z0-9._%+-]+@gmail\.com$/;

    if (!emailPattern.test(emailInput.value)) {
        emailError.textContent = 'Please enter a valid Email address';
        emailError.style.color = 'red';
    } else {
        emailError.textContent = '';
        return true;
    }
}
document.getElementById('email1').addEventListener('input', function() {
    validateEmail();
});


// // error for phonenumber 
// function validatePhoneNumber() {
//     var phoneNumberInput = document.getElementById('phonenumber');
//     var phoneError = document.getElementById('phonenumber_err');
//     var phoneNumberPattern = /^\d{10}$/; // Regular expression to match 10-digit phone number
    
//     // If input does not match pattern, display error message
//     if (!phoneNumberPattern.test(phoneNumberInput.value)) {
//         phoneError.textContent = 'Please enter a 10-digit phone number';
//         phoneError.style.display = 'block'; // Show error message
//     } else {
//         // If input matches pattern, clear error message
//         phoneError.textContent = ''; // Clear error message
//         phoneError.style.display = 'none'; // Hide error message
//     }
// }

// // Add event listener for input event
// document.getElementById('phonenumber').addEventListener('input', validatePhoneNumber);


// error for alternate phone number
// function validatePhoneNumber() {
//     var phoneNumberInput = document.getElementById('phonenumber1');
//     var phoneError = document.getElementById('alternate_phone_err');
//     var phoneNumberPattern = /^\d{10}$/;
    
//     if (!phoneNumberInput.value) {
//         phoneError.textContent = '';
//         phoneError.style.display = 'none';
//     } else if (!phoneNumberPattern.test(phoneNumberInput.value)) {
//         phoneError.textContent = 'Please enter valid number';
//         phoneError.style.color = 'red';
//         phoneError.style.display = 'block';
//     } else {
//         phoneError.textContent = '';
//         phoneError.style.display = 'none';
//     }
// }
// document.getElementById('phonenumber1').addEventListener('input', function() {
//     validatePhoneNumber();
// });



