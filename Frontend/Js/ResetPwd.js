function validatePasswords() {
    // Reset previous error messages
    document.getElementById('password-error').textContent = '';
    document.getElementById('confirm-password-error').textContent = '';

    // Get password values from the form
    var password = document.getElementById('password').value;
    var confirmPassword = document.getElementById('confirmPassword').value;

    // Regular expression to validate password (at least 8 characters including one uppercase letter, one lowercase letter, one number, and one special character)
    var passwordPattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*()_+])[a-zA-Z0-9!@#$%^&*()_+]{8,}$/;

    // Perform validation
    if (password.trim() === '') {
        document.getElementById('password-error').textContent = 'Password is required';
    } else if (!passwordPattern.test(password)) {
        document.getElementById('password-error').textContent = 'Password must be at least 8 characters long and include at least one uppercase letter, one lowercase letter, one number, and one special character.';
    }

    if (confirmPassword.trim() === '') {
        document.getElementById('confirm-password-error').textContent = 'Confirm Password is required';
    } else if (confirmPassword !== password) {
        document.getElementById('confirm-password-error').textContent = 'Passwords do not match.';
    }

    // If both passwords match, you can redirect to another page
    if (password === confirmPassword && passwordPattern.test(password)) {
        // Redirect to another page
        window.location.href = 'success.html';
    }
}