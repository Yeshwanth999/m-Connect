function validateForm() {
    // Reset previous error messages
    document.getElementById('username-error').textContent = '';
    document.getElementById('password-error').textContent = '';

    // Get values from the form
    var username = document.getElementById('gmail').value;
    var password = document.getElementById('password').value;
    var isAdmin = document.getElementById('adminCheckbox').checked;

    //pattern for the username
    var usernamePattern = /^SP\d{7}-M\d{4}$/;

    //pattern for the password
    var passwordPattern = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[@$!%*#?&])[A-Za-z\d@$!%*#?&]{8,}$/;

    // Perform validation
    var isValid = true;

    if (username.trim() === '') {
        document.getElementById('username-error').textContent = 'Username is required';
        isValid = false;
    } else if (!usernamePattern.test(username)) {
        document.getElementById('username-error').textContent = 'Invalid username format';
        isValid = false;
    }

    if (password.trim() === '') {
        document.getElementById('password-error').textContent = 'Password is required';
        isValid = false;
    } else if (!passwordPattern.test(password)) {
        document.getElementById('password-error').textContent = 'Invalid password format';
        isValid = false;
    }

    // Redirect only if the form is valid and isAdmin is checked
    if (isValid && isAdmin) {
        window.location.href = 'AdminPage.html';
    } else if (isValid) {
        window.location.href = 'employeeDashboard.html';
    }
}
