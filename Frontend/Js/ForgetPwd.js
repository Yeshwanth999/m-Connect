function validateForm() {
    
    document.getElementById('email-error').textContent = '';

    
    var email = document.getElementById('email').value;


    var emailPattern = /^[a-zA-Z0-9._-]+@gmail\.com$/;

    
    if (email.trim() === '') {
        document.getElementById('email-error').textContent = 'Email is required';
        return false; // Return false to indicate validation failure
    } else if (!emailPattern.test(email)) {
        document.getElementById('email-error').textContent = 'Invalid email format.';
        return false; // Return false to indicate validation failure
    }
    
    return true; // Return true to indicate validation success
}

const otpContainer = document.getElementById("otp-div");
const signupBtn = document.getElementById("signupBtn"); // Corrected to match the id in HTML

signupBtn.addEventListener('click', function() {
    // Call validateForm() and check its return value
    if(validateForm()) {
        // If validation succeeds, display the OTP container
        document.getElementById("otp-div").style.display = 'inline'; // Corrected typo
    }
});
