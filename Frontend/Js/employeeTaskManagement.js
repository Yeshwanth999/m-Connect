
document.addEventListener("DOMContentLoaded", function() {
  const employeesData = [
    {
      "name": "M-connect",
      "assigned_to": "Team m-connect",
      "due_date": "2024-01-30",
      "priority": "High",
      "status": "On Process",
      "submitted_date": "2024-03-10"
    },
    {
      "name": "Complete Project",
      "assigned_to": "John Doe",
      "due_date": "2024-02-20",
      "priority": "High",
      "status": "In Progress",
      "submitted_date": "2024-02-10"
    },
    {
      "name": "Prepare Project Theme",
      "assigned_to": "Jane Smith",
      "due_date": "2024-02-18",
      "priority": "Medium",
      "status": "Not Started",
      "submitted_date": "2024-02-10"
    },
    {
      "name": "Review Code Changes",
      "assigned_to": "Alice Johnson",
      "due_date": "2024-02-25",
      "priority": "Low",
      "status": "Pending Review",
      "submitted_date": "2024-02-12"
    },
    {
    "name":"",
    "assigned_to":"",
    "due_date":"",
    "priority":"",
    "status":"",
    "submitted_date":""
    },
    {
      "name":"",
      "assigned_to":"",
      "due_date":"",
      "priority":"",
      "status":"",
      "submitted_date":""
    },
    {
      "name":"",
      "assigned_to":"",
      "due_date":"",
      "priority":"",
      "status":"",
      "submitted_date":""
    },
    {
      "name":"",
      "assigned_to":"",
      "due_date":"",
      "priority":"",
      "status":"",
      "submitted_date":""
    },
    {
      "name":"",
      "assigned_to":"",
      "due_date":"",
      "priority":"",
      "status":"",
      "submitted_date":""
    }
  ];

  const tableBody = document.querySelector('#task-table tbody');
  
  var serialNumber=0;

  employeesData.forEach((task, index) => {
        const row = `
        <tr>
        <td>${task.name ? ++serialNumber : ''}</td>
        <td>${task.name ? task.name : ''}</td>
        <td>${task.assigned_to ? task.assigned_to : ''}</td>
        <td>${task.due_date ? task.due_date : ''}</td>
        <td>${task.priority ? task.priority : ''}</td>
        <td>${task.status ? task.status : ''}</td>
        <td>${task.submitted_date ? task.submitted_date : ''}</td>
      </tr>

    `;
    tableBody.innerHTML += row;
  });
});