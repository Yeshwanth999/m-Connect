
var usermail = sessionStorage.getItem("usermail");

console.log(usermail);

if (usermail !== null && usermail !== "") {
    geturlLink = 'http://localhost:8081/user/getemployee/' + usermail + '';
    console.log(usermail + "usermail." + geturlLink);

}
else {
    console.log("Mail unavailable");
}

$(document).ready(function () {


    // Fetch data from the server when the page loads
    $.ajax({
        type: 'GET',
        url: geturlLink, // Replace 'user/data' with your actual endpoint
        success: function (responseData) {
            // Populate the form fields with the retrieved data
            $('#firstname').val(responseData.firstname);
            $('#lastname').val(responseData.lastname);
            $('#dob').val(responseData.dob);
            $('#gender').val(responseData.gender);
            $('#blood_group').val(responseData.blood_group);
            $('#marital_status').val(responseData.marital_status);
            $('#phonenumber').val(responseData.phonenumber);
            $('#phonenumber1').val(responseData.phonenumber1);
            $('#currentAddress').val(responseData.currentAddress);
            $('#currentCountry').val(responseData.currentCountry);
            $('#currentState').val(responseData.currentState);
            $('#currentCity').val(responseData.currentCity);
            $('#currentPincode').val(responseData.currentPincode);
            $('#permanentAddress').val(responseData.permanentAddress);
            $('#permanentCountry').val(responseData.permanentCountry);
            $('#permanentState').val(responseData.permanentState);
            $('#permanentCity').val(responseData.permanentCity);
            $('#permanentPincode').val(responseData.permanentPincode);
            $('#linkedin').val(responseData.linkedin);
            $('#twitter').val(responseData.twitter);
            $('#facebook').val(responseData.facebook);
        },
        error: function (error) {
            console.error('Error fetching data:', error);
        }

    });
    console.log(firstname);
    console.log(lastname);
    console.log(dob);
    console.log(gender);
    console.log(blood_group);
    console.log(marital_status);
    //personal info start
    //console.log(gmail);
    console.log(password);
    console.log(phonenumber);
    console.log(phonenumber1);
    // Address info start
    console.log(currentAddress);
    console.log(currentCountry);
    console.log(currentState);
    console.log(currentCity);
    console.log(currentPincode);
    console.log(permanentAddress);
    console.log(permanentCountry);
    console.log(permanentState);
    console.log(permanentCity);
    console.log(permanentPincode);
    // social info start
    console.log(linkedin);
    console.log(twitter);
    console.log(facebook);


});




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

    inputs.forEach(function (input) {
        input.disabled = !input.disabled;

    });

    selects.forEach(function (select) {
        select.disabled = !select.disabled;

    });

    buttons.style.display = 'block';

}

function cancelEdit() {
    var inputs = document.querySelectorAll('.input-underlined');
    var selects = document.querySelectorAll('select');
    var buttons = document.querySelector('.button-container');

    inputs.forEach(function (input) {
        input.disabled = true;

    });

    selects.forEach(function (select) {
        select.disabled = true;
    });

    buttons.style.display = 'none';

    //document.getElementById("firstname").value = "";
    /*inputs.forEach(function(input) {
        input.value = "";
      });*/

}

function saveEdit() {

    cancelEdit();
}
// personal info end //



// contact info start //
// document.getElementById("gmail").disabled = true;
document.getElementById("password").disabled = true;
document.getElementById("phonenumber").disabled = true;
document.getElementById("phonenumber1").disabled = true;

function contactOnclick() {
    var inputs = document.querySelectorAll('.input-underlined1');
    var buttons = document.querySelector('.button-container1');

    inputs.forEach(function (input) {
        input.disabled = !input.disabled;
    });

    buttons.style.display = 'block';
}

function cancelContact() {
    var inputs = document.querySelectorAll('.input-underlined1');
    var buttons = document.querySelector('.button-container1');

    inputs.forEach(function (input) {
        input.disabled = true;
    });


    buttons.style.display = 'none';
}

function saveContact() {

    cancelContact();
}
// contact info end //




// Address info start //
document.getElementById("currentAddress").disabled = true;
document.getElementById("currentCountry").disabled = true;
document.getElementById("currentState").disabled = true;
document.getElementById("currentCity").disabled = true;
document.getElementById("currentPincode").disabled = true;

document.getElementById("permanentAddress").disabled = true;
document.getElementById("permanentCountry").disabled = true;
document.getElementById("permanentState").disabled = true;
document.getElementById("permanentCity").disabled = true;
document.getElementById("permanentPincode").disabled = true;
document.getElementById("housetype").disabled = true
document.getElementById("stayingsince").disabled = true
document.getElementById("livingin").disabled = true


function addressOnclick() {
    var inputs = document.querySelectorAll('.input-underlined2');
    var buttons = document.querySelector('.button-container2');

    inputs.forEach(function (input) {
        input.disabled = !input.disabled;
    });

    buttons.style.display = 'block';
}

function cancelAddress() {
    var inputs = document.querySelectorAll('.input-underlined2');
    var buttons = document.querySelector('.button-container2');

    inputs.forEach(function (input) {
        input.disabled = true;
    });

    buttons.style.display = 'none';
}

function saveAddress() {

    cancelAddress();
}
// social info start //
document.getElementById("linkedin").disabled = true;
document.getElementById("twitter").disabled = true;
document.getElementById("facebook").disabled = true;

// error for pincode // 
document.getElementById('currentPincode').addEventListener('blur', function () {
    var pincode = this.value.trim();
    var pincodeRegex = /^\d{6}$/;

    if (pincode - 2 === '' || !pincodeRegex.test(pincode - 2)) {
        document.getElementById('currentPincode').style.borderBottomColor = '';
        document.getElementById('pincode-error').innerText = 'Please Enter Valid Pincode';
        document.getElementById('pincode-error').style.color = 'red';
    } else {
        document.getElementById('currentPincode').style.borderBottomColor = '#ccc';
        document.getElementById('pincode-error').innerText = '';
    }
});


document.getElementById('permanentPincode').addEventListener('blur', function () {
    var pincode = this.value.trim();
    var pincodeRegex = /^\d{6}$/;


    if (pincode - 2 === '' || !pincodeRegex.test(pincode - 2)) {
        document.getElementById('permanentPincode').style.borderBottomColor = '';
        document.getElementById('pincode-error').innerText = 'Please Enter Valid Pincode';
        document.getElementById('pincode-error').style.color = 'red';
    } else {
        document.getElementById('permanentPincode').style.borderBottomColor = '#ccc';
        document.getElementById('pincode-error').innerText = '';
    }
});


function socialOnclick() {
    var inputs = document.querySelectorAll('.input-underlined3');
    var buttons = document.querySelector('.button-container3');

    inputs.forEach(function (input) {
        input.disabled = !input.disabled;
    });

    buttons.style.display = 'block';
}

function cancelsocial() {
    var inputs = document.querySelectorAll('.input-underlined3');
    var buttons = document.querySelector('.button-container3');

    inputs.forEach(function (input) {
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
document.querySelectorAll('.currentaddress').forEach(function (input) {
    input.addEventListener('input', function () {
        var allInputsFilled = true;
        document.querySelectorAll('.currentaddress').forEach(function (input) {
            if (input.value.trim() === '') {
                allInputsFilled = false;
            }
        });
        document.getElementById("sameAddressCheckbox").disabled = !allInputsFilled;
    });
});


// tranfering data using json
$('#saveEdit, #saveContact, #saveAddress, #savesocial').on('click', function () {

    // personal info start
    var firstname = $('#firstname').val();
    var lastname = $('#lastname').val();
    var dob = $('#dob').val();
    var gender = $('#gender').val();
    var blood_group = $('#blood_group').val();
    var marital_status = $('#marital_status').val();

    // contact info start
    // var email = $('#gmail').val();
    var password = $('#password').val();
    var phonenumber = $('#phonenumber').val();
    var phonenumber1 = $('#phonenumber1').val();

    // Address info start
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

    // social info start
    var linkedin = $('#linkedin').val();
    var twitter = $('#twitter').val();
    var facebook = $('#facebook').val();

    const empObject = {
        // personal info start
        profileImage: profileImage,
        firstname: firstname,
        lastname: lastname,
        dob: dob,
        gender: gender,
        blood_group: blood_group,
        marital_status: marital_status,

        //adminStatus: adminStatus,
        // personal info start
        // email: gmail,
        password: password,
        phonenumber: phonenumber,
        phonenumber1: phonenumber1,
        // Address info start
        currentAddress: currentAddress,
        currentCountry: currentCountry,
        currentState: currentState,
        currentCity: currentCity,
        currentPincode: currentPincode,
        permanentAddress: permanentAddress,
        permanentCountry: permanentCountry,
        permanentState: permanentState,
        permanentCity: permanentCity,
        permanentPincode: permanentPincode,
        // social info start
        linkedin: linkedin,
        twitter: twitter,
        facebook: facebook,
    };
    // personal info start
    console.log(firstname);
    console.log(profileImage);
    console.log(lastname);
    console.log(dob);
    console.log(gender);
    console.log(blood_group);

    console.log(marital_status);
    //personal info start
    //console.log(gmail);
    console.log(password);
    console.log(phonenumber);
    console.log(phonenumber1);
    // Address info start
    console.log(currentAddress);
    console.log(currentCountry);
    console.log(currentState);
    console.log(currentCity);
    console.log(currentPincode);
    console.log(permanentAddress);
    console.log(permanentCountry);
    console.log(permanentState);
    console.log(permanentCity);
    console.log(permanentPincode);
    // social info start
    console.log(linkedin);
    console.log(twitter);
    console.log(facebook);


    const type = 'PUT';
    // Call the updated function for AJAX communication
    var usermail = sessionStorage.getItem("usermail");

    console.log(usermail);

    if (usermail !== null && usermail !== "") {
        sendEmpData('http://localhost:8081/user/updateemp/' + usermail + '', type, empObject, 'form');
    }
    else {
        console.log("Mail unavailable");
    }

});


// profile section image code 
document.querySelector('.pp').addEventListener('click', function(event) {
    event.stopPropagation();
    document.getElementById('fileInput').click();
});
document.getElementById("uploadLabel").addEventListener("click", function(e) {
    e.preventDefault();
})
function displayPhoto(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            var profileImage = document.getElementById('profileImage');
            profileImage.style.backgroundImage = 'url(' + e.target.result + ')';
            profileImage.style.border = "none";
            document.getElementById("uploadLabel").style.display = "none";
        };

        reader.readAsDataURL(input.files[0]);
    }
}
