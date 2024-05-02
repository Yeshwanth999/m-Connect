const sampleData = [
    {
        "userId": "001",
        "leaveType": "Vacation",
        "leaveReason": "Family trip",
        "numDaysApplied": 5,
        "numDaysApproved": "",
        "status": ""
    },
    {
        "userId": "002",
        "leaveType": "Sick",
        "leaveReason": "Flu",
        "numDaysApplied": 3,
        "numDaysApproved": "",
        "status": ""
    },
    {
        "userId": "003",
        "leaveType": "Personal",
        "leaveReason": "Attending wedding",
        "numDaysApplied": 2,
        "numDaysApproved": "",
        "status": ""
    }
];

function handleUserIdClick(userId) {
    window.location.href = 'adminleavebalance.html?userId=' + userId;
}
function logData() {
    console.log(sampleData);
}

// document.getElementById('sendButton').addEventListener('click', function() {
//     logData(); 
// });


// sampleData.forEach(item => {
//     const row = document.createElement('tr');
//     Object.values(item).forEach((value, index) => {
//         const cell = document.createElement('td');
//         cell.textContent = value;
//         if (index === 0) { 
//             cell.style.cursor = 'pointer'; 
//             cell.addEventListener('click', function() {
//                 handleUserIdClick(item.userId);
//             });
//         }
//         if (index === 4) { 
//             const input = document.createElement('input');
//             input.type = 'number';
//             input.value = value;
//             input.placeholder = 'Enter days approved';
//             input.addEventListener('change', function() {
//                 item.numDaysApproved = parseInt(input.value);
//             });
//             cell.appendChild(input);
//         }
//         if (index === 5) { 
//             const select = document.createElement('select');
//             ["Pending", "Approved", "Rejected"].forEach(option => {
//                 const optionElement = document.createElement('option');
//                 optionElement.textContent = option;
//                 if(option === "pending"){
//                     optionElement.setAttribute("selected", "true");
//                 }
//                 select.appendChild(optionElement);
//             });
//             select.value = value;
//             select.addEventListener('change', function() {
//                 item.status = select.value;
//             });
//             cell.appendChild(select);
//         }
//         row.appendChild(cell);
//     });
//     tableBody.appendChild(row);
// });