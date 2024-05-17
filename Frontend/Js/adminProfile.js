// personal info start //
document.getElementById("firstname").disabled = true;
document.getElementById("lastname").disabled = true;
document.getElementById("email").disabled = true;
document.getElementById("password").disabled = true;
document.getElementById("adminCheckbox").disabled = true;
document.getElementById("secTokenBtn").disabled = true;


function toggleEditMode() {
    var inputs = document.querySelectorAll('.input-underlined');
    var selects = document.querySelectorAll('select');
    var buttons = document.querySelector('.button-container');
    var adminCheckbox = document.getElementById('adminCheckbox');
    var secTokenBtn = document.getElementById('secTokenBtn');

    inputs.forEach(function (input) {
        input.disabled = !input.disabled;
    });

    selects.forEach(function (select) {
        select.disabled = !select.disabled;
    });

    adminCheckbox.disabled = !adminCheckbox.disabled;
    secTokenBtn.disabled = !secTokenBtn.disabled;

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

    document.getElementById("adminCheckbox").disabled = true;
    document.getElementById("secTokenBtn").disabled = true;

    buttons.style.display = 'none';
}

function saveEdit() {

    cancelEdit();
}
// personal info end //




// tranfering data using json// 
$('#saveEdit').on('click', function () {
    // personal info start
    var firstname = $('#firstname').val();
    var lastname = $('#lastname').val();
    var email = $('#email').val();
    var password = $('#password').val();
    var is_Admin = $('#adminCheckbox').is(':checked');
    var secTokenBtn = $('#secTokenBtn').val();


    const adminObject = {
        // personal info start
        firstname: firstname,
        lastname: lastname,
        email: email,
        password: password,
        is_Admin: is_Admin,
        secTokenBtn: secTokenBtn,
    };
    // personal info start
    console.log(firstname);
    console.log(lastname);
    console.log(email);
    console.log(password);
    console.log(is_Admin);
    console.log(secTokenBtn);

    const type = 'POST';

    // Call the updated function for AJAX communication
    sendEmpData('http://localhost:8081/', type, adminObject, 'form');


});


function generateRandomString(length) {
    var result = '';
    var characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789';
    var charactersLength = characters.length;
    for (var i = 0; i < length; i++) {
        result += characters.charAt(Math.floor(Math.random() * charactersLength));
    }
    return result;
}

function genSecToken() {
    console.log("Generate Security Token Function Called...")

    var secTokenCont = document.querySelector(".secTokenCont");
    var randomCode = generateRandomString(15); // Generate a 16-character random string
    secTokenCont.innerHTML = randomCode;

    document.getElementById("secTokenBtn").disabled = true;
}