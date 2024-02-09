function validateForm() {

    let gmail = document.getElementById('gmail').value;

    var gmailPattern = /^[a-zA-Z0-9._-]+@gmail\.com$/;


    if (gmail.trim() === " ") {
        document.getElementById('gmail-error').textContent = 'Email is required';
    } else if (!gmailPattern.test(gmail)) {
        document.getElementById('mail-error').textContent = 'Invalid gmail format.';
    } else {
        const formData = {
            gmail: gmail
        };
        console.log(gmail);

        const type = 'POST';

        sendFormData1('http://localhost:8081/forgotPassword', type, formData, 'formBox2');


        document.querySelector('.otp-form').style.display = 'block';
    }

    return true;
}



function validateOTP() {


    var otp = document.getElementById('otp').value;
    var gmail = localStorage.getItem("gmail");
    if (otp.trim() === '') {
        document.getElementById('otp-error').textContent = 'OTP is required';
    } else {
    }
    const formData = {
        gmail: gmail,
        otp: otp
    };
    console.log(otp);

    const type = "POST"

    verifyOtp('http://localhost:8081/verifyOtp?gmail=' + gmail + '&otp=' + otp + '', type, formData, 'formBox2');



}
