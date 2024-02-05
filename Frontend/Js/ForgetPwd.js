function validateForm() {
    // Reset previous error messages
    document.getElementById('email-error').textContent = '';

    // Get values from the form
    var email = document.getElementById('email').value;

    //pattern for a general Gmail format
    var emailPattern = /^[a-zA-Z0-9._-]+@gmail\.com$/;

    // Perform validation
    if (email.trim() === '') {
        document.getElementById('email-error').textContent = 'Email is required';
    } else if (!emailPattern.test(email)) {
        document.getElementById('email-error').textContent = 'Invalid email format.';
    }

    
}