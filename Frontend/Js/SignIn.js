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

document.getElementById('gmail').addEventListener('input', validateEmail);