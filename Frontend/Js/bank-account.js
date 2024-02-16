document.getElementById('profileImageInput').addEventListener('change', function() {
    var file = this.files[0];
    var reader = new FileReader();
  
    reader.onload = function(e) {
      document.getElementById('profileImage').setAttribute('src', e.target.result);
    }
  
    reader.readAsDataURL(file);
});


function displayAccountDetails() {
    const accountHolder = document.getElementById('accountHolder').value;
    const bankName = document.getElementById('bankName').value;
    const accountNumber = document.getElementById('accountNumber').value;
    const branchName = document.getElementById('branchName').value;
    const city = document.getElementById('city').value;
    const ifscCode = document.getElementById('ifscCode').value;

    const accountDetailsContainer = document.getElementById('accountDetailsContainer');
    const detailsHTML = `
        <h2>Account Details</h2>
        <p><strong>Account Holder:</strong> ${accountHolder}</p>
        <p><strong>Bank Name:</strong> ${bankName}</p>
        <p><strong>Account Number:</strong> ${accountNumber}</p>
        <p><strong>Branch Name:</strong> ${branchName}</p>
        <p><strong>City:</strong> ${city}</p>
        <p><strong>IFSC Code:</strong> ${ifscCode}</p>
    `;

    accountDetailsContainer.innerHTML = detailsHTML;
}
