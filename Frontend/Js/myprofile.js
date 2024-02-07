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
document.getElementById("housetype").disabled=true
document.getElementById("stayingsince").disabled=true
document.getElementById("livingin").disabled=true


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


// on change current address to permanent address after clicking in check box //
function copyAddress() {
    var checkbox = document.getElementById("sameAddressCheckbox");
    var currentAddressFields = document.querySelectorAll(".currentaddress");
    var permanentAddressFields = document.querySelectorAll(".permanentaddress");

    if (checkbox.checked) {
        permanentAddressFields.forEach(function(permanentField, index) {
            permanentField.value = currentAddressFields[index].value;
        });
    } else {
        permanentAddressFields.forEach(function(permanentField) {
            permanentField.value = "";
        });
    }
}

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

// error message //
function copyAddress() {
    var sameAddressCheckbox = document.getElementById("sameAddressCheckbox");
    var currentAddress = document.getElementById("currentAddress");
    var permanentAddress = document.querySelectorAll(".permanentaddress");
    var errorMessage = document.getElementById("emptyFieldError");

    if (sameAddressCheckbox.checked) {
  
        currentAddress.forEach(function(input) {
            
            if (input.value.trim() === "") {
                
                errorMessage.style.display = "block";
            }
        });
    }
    

    if (sameAddressCheckbox.checked) {
        
        permanentAddress.forEach(function(input) {
           
            if (input.value.trim() === "") {
                
                errorMessage.style.display = "block";
            }
        });
    } 
}


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

