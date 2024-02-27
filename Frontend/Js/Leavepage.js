document.addEventListener('DOMContentLoaded', function () {
   
});

const applyLeave = document.getElementById("applyLeave");
const leaveCancel = document.getElementById('leaveCancel');
const leaveHistory = document.getElementById('leaveHistory');
const myRequests = document.getElementById('myRequests');
const leaveBalance = document.getElementById('leaveBalance');

// onclick display apply leave section and others none
function apply(){
    applyLeave.style.display="block";
    leaveCancel.style.display="none";
    leaveHistory.style.display="none";
    myRequests.style.display="none";
    leaveBalance.style.display="none";
}
// saving apply leave data into json object and sending it to db
function sendLeaveData(){
  const leaveData ={
  }

  const leaveType = document.getElementById('leave-type').value;
  const fromShift = document.getElementById('from-shift').value;
  const from = document.getElementById('from').value;
  const toShift = document.getElementById('to-shift').value;
  const to = document.getElementById('to').value;
  const reasonFor = document.getElementById('reason-for').value;

  leaveData.type = leaveType;
  leaveData.fromShift = fromShift;
  leaveData.fromDate = from;
  leaveData.toShift = toShift;
  leaveData.toDate = to;
  leaveData.reasonFor = reasonFor;
  console.log(leaveData);
  let URL ;
  let type ;
}

// onclick display cancel leave section and others none
function cancel(){
    applyLeave.style.display="none";
    leaveCancel.style.display="block";
    leaveHistory.style.display="none";
    myRequests.style.display="none";
    leaveBalance.style.display="none";
}

// saving cancel leave data into json object and sending it to db
function sendCancelLeaveData(){
  const cancelLeaveData ={
  }

  const appliedLeaveType = document.getElementById('applied-leave-type').value;
  const appliedOnDate =document.getElementById('applied-on')
  const appliedFromShift = document.getElementById('applied-from-shift').value;
  const appliedFrom = document.getElementById('applied-from').value;
  const appliedToShift = document.getElementById('applied-to-shift').value;
  const appliedTo = document.getElementById('applied-to').value;
  const appliedReasonFor = document.getElementById('applied-reason-for').value;
  const comments = document.getElementById('comments')

  cancelLeaveData.appliedLeaveType = appliedLeaveType;
  cancelLeaveData.appliedOnDate = appliedOnDate;
  cancelLeaveData.appliedFromShift = appliedFromShift;
  cancelLeaveData.appliedFromDate = appliedFrom;
  cancelLeaveData.appliedToShift = appliedToShift;
  cancelLeaveData.appliedToDate = appliedTo;
  cancelLeaveData.appliedReasonFor = appliedReasonFor;
  cancelLeaveData.comments = comments;
  console.log(cancelLeaveData);
  let URL ;
  let type ;
}

function history(){
    // onclick to display leave history section

    applyLeave.style.display="none";
    leaveCancel.style.display="none";
    leaveHistory.style.display="block";
    myRequests.style.display="none";
    leaveBalance.style.display="none";

    // history table data from json
    const data = [
        

        {
          "id" : 1 ,
          "leave_date": "2024-02-01",
          "status": "Approved",
          "leave_type": "Annual",
          "no_of_days": 1
        },
        {
          "id" : 2,
          "leave_date": "2024-02-05",
          "status": "Pending",
          "leave_type": "Sick",
          "no_of_days": 3
        },
        {
          "id" : 3,
          "leave_date": "2024-02-10",
          "status": "Rejected",
          "leave_type": "Personal",
          "no_of_days": 2
        },
        {
          "id" : 4,
          "leave_date": "2024-02-15",
          "status": "Approved",
          "leave_type": "Annual",
          "no_of_days": 1
        },
        {
          "id" : 5 ,
          "leave_date": "2024-02-20",
          "status": "Approved",
          "leave_type": "Maternity",
          "no_of_days": 90
        }
];  

const gridView = document.getElementById('grid-view');
const searchInput = document.getElementById('search-input');

function renderGridView(data) {
// Clear existing rows
gridView.innerHTML = '';

// Create header row
const headerRow = document.createElement('tr');
for (const key in data[0]) {
  const th = document.createElement('th');
  th.textContent = key.toUpperCase();
  headerRow.appendChild(th);
}
gridView.appendChild(headerRow);

// Create data rows
data.forEach(item => {
  const row = document.createElement('tr');
  for (const key in item) {
    const td = document.createElement('td');
    td.textContent = item[key];
    row.appendChild(td);
  }
  gridView.appendChild(row);
});
}

renderGridView(data);


}

function request(){
  applyLeave.style.display="none";
  leaveCancel.style.display="none";
  leaveHistory.style.display="none";
  myRequests.style.display="block";
  leaveBalance.style.display="none";
  //rendering leave balance data from json
  const data = [
    {
      "s.no" : 1,
      "leave type": "sick leave",
      "start date": "1/2/2024",
      "end date": "2/2/2024",
      "reason": "health issue",
      "status": "Approved",
    },
    {
      "s.no" : 2,
      "leave type": "emergency",
      "start date": "1/2/2024",
      "end date": "2/2/2024",
      "reason": "health issue",
      "status": "Approved",
    },
    {
      "s.no" : 3,
      "leave type": "paid",
      "start date": "1/2/2024",
      "end date": "2/2/2024",
      "reason": "health issue",
      "status": "Approved",
    },
    {
      "s.no" : 4,
      "leave type": "casual",
      "start date": "1/2/2024",
      "end date": "2/2/2024",
      "reason": "health issue",
      "status": "Approved",
    },
    {
      "s.no" : 5,
      "leave type": "meternity",
      "start date": "1/2/2024",
      "end date": "2/2/2024",
      "reason": "health issue",
      "status": "Approved",
    }
];  
  const gridView = document.getElementById('request-grid-view');
  function renderGridView(data) {
      // Clear existing rows
      gridView.innerHTML = '';

      // Create header row
      const headerRow = document.createElement('tr');
      for (const key in data[0]) {
        const th = document.createElement('th');
        th.textContent = key.toUpperCase();
        headerRow.appendChild(th);
      }
      gridView.appendChild(headerRow);

      // Create data rows
      data.forEach(item => {
      const row = document.createElement('tr');
      for (const key in item) {
        const td = document.createElement('td');
        td.textContent = item[key];
        row.appendChild(td);
      }
      gridView.appendChild(row);
    });
  }
  renderGridView(data);
}

function balance(){
  // onclick to display leave balance section
  applyLeave.style.display="none";
  leaveCancel.style.display="none";
  leaveHistory.style.display="none";
  myRequests.style.display="none";
  leaveBalance.style.display="block";
  
  //rendering leave balance data from json
  const data = [
      {
        "Leave Type" : "Sick",
        "Credited": 20,
        "Used": 1,
        "Balance": 19,
      },
      {
          "Leave Type" : "paid",
          "Credited": 24,
          "Used": 5,
          "Balance": 19,
      },
      {
          "Leave Type" : "Sick",
          "Credited": 10,
          "Used": 1,
          "Balance": 9,
      },
      {
          "Leave Type" : "casual",
          "Credited": 12,
          "Used": 1,
          "Balance": 11,
      },
      {
          "Leave Type" : "emergency",
          "Credited": 20,
          "Used": 1,
          "Balance": 19,
      }
  ];  
  const gridView = document.getElementById('balance-grid-view');
  function renderGridView(data) {
    // Clear existing rows
    gridView.innerHTML = '';

    // Create header row
    const headerRow = document.createElement('tr');
    for (const key in data[0]) {
    const th = document.createElement('th');
    th.textContent = key.toUpperCase();
    headerRow.appendChild(th);
    }
    gridView.appendChild(headerRow);

    // Create data rows
    data.forEach(item => {
    const row = document.createElement('tr');
    for (const key in item) {
    const td = document.createElement('td');
    td.textContent = item[key];
    row.appendChild(td);
    }
    gridView.appendChild(row);
    });
  }

  renderGridView(data);
}
