

function validateForm() {
    // Reset previous error messages
    document.getElementById('username-error').textContent = '';
    document.getElementById('password-error').textContent = '';

    // Get values from the form
    var username = document.getElementById('username').value;
    var password = document.getElementById('password').value;
    var isAdmin = document.getElementById('adminCheckbox').checked;

    //pattern for the username
    var usernamePattern = /^SP\d{7}-M\d{4}$/;

    //pattern for the password
    var passwordPattern = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/;

    // Perform validation
    if (username.trim() === '') {
        document.getElementById('username-error').textContent = 'Username is required';
    } else if (!usernamePattern.test(username)) {
        document.getElementById('username-error').textContent = 'Invalid username format';
    }

    
    if (password.trim() === '') {
        document.getElementById('password-error').textContent = 'Password is required';
    } else if (!passwordPattern.test(password)) {
        document.getElementById('password-error').textContent = 'Invalid password format';     
    }


    //Redirectin to admin page
    if (isAdmin) {
        window.location.href = 'adminPage.html'; // Replace 'adminPage.html' with the actual URL of your admin page
    } else {
        
    }

    
}