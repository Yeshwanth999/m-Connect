document.getElementById('profileImageInput').addEventListener('change', function() {
    var file = this.files[0];
    var reader = new FileReader();
  
    reader.onload = function(e) {
      document.getElementById('profileImage').setAttribute('src', e.target.result);
    }
  
    reader.readAsDataURL(file);
});


function updateDocument() {
    const selectedYear = document.getElementById('year').value;
    const selectedMonth = document.getElementById('month').value;
    const dummyContainer = document.getElementById('dummyContainer');

    // Display details about the selected document in the dummy container
    dummyContainer.innerHTML = `
        <h3>Document Details</h3>
        <p>Selected Year: ${selectedYear}</p>
        <p>Selected Month: ${getMonthName(selectedMonth)}</p>
        <p>Document Content: This is a sample document.</p>
    `;
}

function getMonthName(monthNumber) {
    const months = ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"];
    return months[monthNumber - 1];
}

function downloadDocument() {
    // Placeholder for download functionality
    alert('Downloading document...');
    // Implement your actual download logic here
}
