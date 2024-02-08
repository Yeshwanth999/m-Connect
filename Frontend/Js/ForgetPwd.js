function validateForm() {

    let gmail = document.getElementById('gmail').value;

    var gmailPattern = /^[a-zA-Z0-9._-]+@gmail\.com$/;


    if (gmail.trim() === " ") {
        document.getElementById('gmail-error').textContent = 'Email is required';
    } else if (!gmailPattern.test(gmail)) {
        document.getElementById('mail-error').textContent = 'Invalid gmail format.';
    } else {

        const gmail = $('#gmail').val();

        const formData = {
            gmail: gmail,
        };
        console.log(gmail);

        const type = 'POST';

        // Call the updated function for AJAX communication
        sendFormData1('http://localhost:8081/forgotPassword', type, formData, 'formBox2');


        document.querySelector('.otp-form').style.display = 'block';
    }
}

function validateOTP() {
    // Reset previous error messages

    // Get values from the OTP form
    // var element = document.getElementById('otp');

    var otp = document.getElementById('otp').value;
    // Perform validation (you can add your own validation logic for OTP here)
    // For now, let's just check if OTP is not empty
    if (otp.trim() === '') {
        document.getElementById('otp-error').textContent = 'OTP is required';
    } else {
        // Here you can handle further steps like verifying OTP, etc.
    }
    const formData = {
        otp: otp,
    };
    console.log(otp);

    const type = 'POST'

    verifyOtp('http://localhost:8081/verifyOtp', type, formData, 'formBox2');

    // alert('OTP Verified Successfully!');


}
