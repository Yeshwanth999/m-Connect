// personal info start //
document.getElementById("firstname").disabled = true;
document.getElementById("lastname").disabled = true;
document.getElementById("email").disabled = true;
document.getElementById("password").disabled = true;
document.getElementById("adminCheckbox").disabled = true;  


function toggleEditMode() {
    var inputs = document.querySelectorAll('.input-underlined');
    var selects = document.querySelectorAll('select');
    var buttons = document.querySelector('.button-container');
    var adminCheckbox =document.getElementById('adminCheckbox');

    inputs.forEach(function(input) {
        input.disabled = !input.disabled;
    });

    selects.forEach(function(select) {
        select.disabled = !select.disabled;
    });

    adminCheckbox.disabled = !adminCheckbox.disabled;

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

    document.getElementById("adminCheckbox").disabled = true;

    buttons.style.display = 'none';
}

function saveEdit() {

    cancelEdit();
}
// personal info end //




// tranfering data using json// 
$('#saveEdit').on('click', function (){
    // personal info start
    var firstname = $('#firstname').val();
    var lastname = $('#lastname').val();    
    var email = $('#email').val();
    var password = $('#password').val();
    var is_Admin = $('#adminCheckbox').is(':checked');

    
    const adminObject = {
        // personal info start
        firstname:firstname,
        lastname:lastname,
        email:email,
        password:password,
        is_Admin:is_Admin,
    };
    // personal info start
    console.log(firstname);
    console.log(lastname);
    console.log(email);
    console.log(password);
    console.log(is_Admin);

    const type= 'POST';

    // Call the updated function for AJAX communication
    sendEmpData('http://localhost:8081/',type, adminObject, 'form');


});
