function validateForm() {
    
    document.getElementById('email-error').textContent = '';

    
    var email = document.getElementById('email').value;

    
    var emailPattern = /^[a-zA-Z0-9._-]+@gmail\.com$/;

    
    if (email.trim() === '') {
        document.getElementById('email-error').textContent = 'Email is required';
    } else if (!emailPattern.test(email)) {
        document.getElementById('email-error').textContent = 'Invalid email format.';
    } else {
        
        document.querySelector('.otp-form').style.display = 'block';
    }
}

function validateOTP() {
    // Reset previous error messages
    document.getElementById('otp-error').textContent = '';

    // Get values from the OTP form
    var otp = document.getElementById('otp').value;

    // Perform validation (you can add your own validation logic for OTP here)

    // For now, let's just check if OTP is not empty
    if (otp.trim() === '') {
        document.getElementById('otp-error').textContent = 'OTP is required';
    } else {
        // Here you can handle further steps like verifying OTP, etc.
        alert('OTP Verified Successfully!');
    }
}
