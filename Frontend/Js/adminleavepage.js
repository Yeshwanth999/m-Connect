const sampleData = [
    {
        "userId": "001",
        "leaveType": "Vacation",
        "leaveReason": "Family trip",
        "numDaysApplied": 5,
        "numDaysApproved": 5,
        "status": "Pending"
    },
    {
        "userId": "002",
        "leaveType": "Sick",
        "leaveReason": "Flu",
        "numDaysApplied": 3,
        "numDaysApproved": 3,
        "status": "Pending"
    },
    {
        "userId": "003",
        "leaveType": "Personal",
        "leaveReason": "Attending wedding",
        "numDaysApplied": 2,
        "numDaysApproved": 2,
        "status": "Pending"
    }
  ];
  
  // Function to populate dropdown with status options
  function populateStatusDropdown(statusCell) {
    const dropdownContent = document.createElement('div');
    dropdownContent.classList.add('dropdown-content');
    
    // Sample status options (replace with your actual JSON data)
    const statusOptions = ["Approved", "Pending", "Rejected"];
    
    // Create buttons for each status option
    statusOptions.forEach(option => {
        const button = document.createElement('button');
        button.textContent = option;
        button.onclick = function() {
            statusCell.textContent = option;
            dropdownContent.style.display = 'none';
        };
        dropdownContent.appendChild(button);
    });
    
    return dropdownContent;
  }
  
  // Add click event listener to the "Send" button
  document.getElementById('sendButton').addEventListener('click', function() {
    const tableData = [];
    const rows = document.querySelectorAll('#tableBody tr');
    rows.forEach(row => {
        const rowData = [];
        row.querySelectorAll('td').forEach(cell => {
            rowData.push(cell.textContent);
        });
        tableData.push(rowData);
    });
    console.log(tableData);
  });

  // Function to handle click on user ID cell
function handleUserIdClick(userId) {
    // Redirect to another page using the user ID
    window.location.href = 'adminleavebalance.html?userId=' + userId;
}

// Function to handle click on status dropdown button
function handleStatusDropdownClick(dropdown, statusCell) {
    dropdown.style.display = 'block'; // Display the dropdown
}

// Modify table population loop to handle click events
sampleData.forEach(item => {
    const row = document.createElement('tr');
    Object.values(item).forEach((value, index) => {
        const cell = document.createElement('td');
        cell.textContent = value;
        if (index === 0) { // If it's the user ID cell
            cell.style.cursor = 'pointer'; // Change cursor to pointer
            cell.addEventListener('click', function() {
                handleUserIdClick(item.userId);
            });
        }
        if (index === 5) { // If it's the status cell
            const dropdown = document.createElement('div');
            dropdown.classList.add('dropdown');
            dropdown.textContent = '▼'; // Dropdown symbol
            dropdown.style.cursor = 'pointer'; // Change cursor to pointer
            dropdown.addEventListener('click', function(event) {
                event.stopPropagation(); // Prevent row click event from firing
                handleStatusDropdownClick(dropdown, cell);
            });
            dropdown.appendChild(populateStatusDropdown(cell));
            cell.appendChild(dropdown);
        }
        row.appendChild(cell);
    });
    tableBody.appendChild(row);
});
