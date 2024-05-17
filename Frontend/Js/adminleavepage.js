var usermail = sessionStorage.getItem("usermail");
var geturlLink;

if (usermail !== null && usermail !== "") {
    geturlLink =
        "http://localhost:8082/admin/getempdata/" +
        usermail +
        "/LeaveRequest";
    console.log("usermail is : " + usermail + "  =>" + geturlLink);
} else {
    console.log("Mail unavailable");
}

$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: geturlLink,
        success: function (responseData) {
            console.log("Receiving Data.......................................!")
            console.log(responseData);

            // Populate the form fields with the retrieved data
            $("#gmail").val(responseData.gmail);
            $("#no_of_days_applied").val(responseData.no_of_days_applied);
            $("#no_of_days_approved").val(responseData.no_of_days_approved);
            $("#leaveStatus").val(responseData.leaveStatus);
            $("#fromDate").val(responseData.fromDate);
            $("#toDate").val(responseData.toDate);
            $("#reasonFor").val(responseData.reasonFor);
            $("#leaveType").val(responseData.leaveType);

            // Log the data here if needed
            console.log(responseData.no_of_days_applied);
            console.log(responseData.leaveStatus);
            console.log(responseData.fromDate);
            console.log(responseData.toDate);
            console.log(responseData.leaveType);
            console.log(responseData.reasonFor);
            console.log(responseData.gmail);
            console.log(responseData.no_of_days_approved);

            // Assuming you want to populate a UI table, handle it here
            populateTable(responseData);
        },
        error: function (error) {
            console.error("Error fetching data:", error);
        },
    });
});

// Function to populate UI table with data
function populateTable(data) {
    const tableBody = $("#tableBody");

    // Clear existing rows
    tableBody.empty();

    // Assuming data is an array of objects, each representing a user's leave request
    data.forEach((item) => {
        const row = $("<tr></tr>");

        // Assuming each object has properties like 'Email', 'leaveType', etc.
        Object.values(item).forEach((value) => {
            const cell = $("<td></td>").text(value);
            row.append(cell);
        });

        tableBody.append(row);
    });
}

// Function to handle user ID click
function handleUserIdClick(userId) {
    window.location.href = 'adminleavebalance.html?userId=' + userId;
}

// Function to log data
function logData() {
    console.log(sampleData);
}

// < !--dynamic data  starting->
// Assume leaveData is fetched from the backend
const leaveData = [
    {
        email: gmail,
        leaveType: leaveType,
        reasonFor: reasonFor,
        fromDate: fromDate,
        toDate: toDate,
        no_of_days_applied: no_of_days_applied,
        no_of_days_approved: no_of_days_approved,
        leaveStatus: leaveStatus
    },
    // Populate the form fields with the retrieved data
];

// Filter leaveData based on a specific condition
const filteredLeaveData = leaveData.filter(leave => {
    // Example condition: Print rows where leave type is 'Sick Leave'
    return leave.leaveType === 'Sick Leave';
});

// Populate table with filtered leave data
const tableBody = document.getElementById('tableBody');
filteredLeaveData.forEach(leave => {
    const row = document.createElement('tr');
    row.innerHTML = `
<td>${leave.email}</td>
<td>${leave.leaveType}</td>
<td>${leave.reasonFor}</td>
<td>${leave.fromDate}</td>
<td>${leave.toDate}</td>
<td>${leave.no_of_days_applied}</td>
<td>${leave.no_of_days_approved}</td>
<td>${leave.leaveStatus}</td>
<td>Action Button</td>
`;
    tableBody.appendChild(row);
});

// < !--dynamic data  Ending-- >