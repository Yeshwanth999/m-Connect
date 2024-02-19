// Function to show success message
function showSuccessMessage(elementId) {
    var element = document.getElementById(elementId);
    element.style.display = 'block';
}

// Function to remove success message
function removeErrorMessage(elementId) {
    var element = document.getElementById(elementId);
    element.textContent = '';
}

// Function to validate email
function validateEmail() {

    //for displaying timark non
    document.getElementById('gmail-done').style.display = 'none';

    var username = document.getElementById('gmail').value.trim();
    var gmailPattern = /^[a-zA-Z0-9._-]+@gmail\.com$/;
    var isValid = true;

    if (username === '') {
        document.getElementById('gmail-error').textContent = 'Username is required';
        isValid = false;
    } else if (!gmailPattern.test(username)) {
        document.getElementById('gmail-error').textContent = 'Invalid Gmail format';
        isValid = false;
    } else {
        removeErrorMessage('gmail-error');
        showSuccessMessage('gmail-done');
    }

    return isValid;
}

// Attach event listeners to trigger validation on input/change
document.getElementById('gmail').addEventListener('input', validateEmail);
document.getElementById('password').addEventListener('input', validatePassword);

// Function to validate form
function validateForm() {
    var isValid = true;

    // Validate email
    isValid = validateEmail() && isValid;

    // Validate password
    isValid = validatePassword() && isValid;

    var isAdmin = document.getElementById('adminCheckbox').checked;

    // Redirect only if the form is valid and isAdmin is checked
    if (isValid && isAdmin) {
        window.location.href = 'AdminPage.html';
    } else if (isValid) {
        window.location.href = 'employeeDashboard.html';
    }
}
