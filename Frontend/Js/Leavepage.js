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
function applyLeaveData(){
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
  let data = leaveData;
  sendApplyLeaveData(URL, type, data)
  
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
function cancelLeaveData(){
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
  let data = cancelLeaveData;
  sendCancelLeaveData(URL, type, data);
}

function history(){
    // onclick to display leave history section

    applyLeave.style.display="none";
    leaveCancel.style.display="none";
    leaveHistory.style.display="block";
    myRequests.style.display="none";
    leaveBalance.style.display="none";

    let url;
    let type;
    let data;
    sendLeaveHistoryData(url, type, data);

    // rendering leave history data from conect.js response

    function historyData(data){

      const gridView = document.getElementById('grid-view');
  
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
            d.textContent = item[key];
            row.appendChild(td);
          }
          gridView.appendChild(row);
        });
      }
      renderGridView(data);
    }
}

function request(){
  applyLeave.style.display="none";
  leaveCancel.style.display="none";
  leaveHistory.style.display="none";
  myRequests.style.display="block";
  leaveBalance.style.display="none";
  let url;
  let type;
  let data;
  sendLeaveRequestsData(url, type, data);
  // rendering leave request data from conect.js response
  function requestsData(data){
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
}

function balance(){
  // onclick to display leave balance section
  applyLeave.style.display="none";
  leaveCancel.style.display="none";
  leaveHistory.style.display="none";
  myRequests.style.display="none";
  leaveBalance.style.display="block";

  let url;
  let type;
  let data;
  sendLeaveBalanceData(url, type, data);

  // rendering leave history data from conect.js response
  function leavebalanceData(data){
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
}
