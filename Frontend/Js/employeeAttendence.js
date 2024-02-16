
$(document).ready(function() {
    // Sample JSON data (you can replace this with your actual data)
    var studentData = [
        {
            "Date": "2024-02-15",
            "ID": 1,
            "Name": "John",
            "InTime": "08:00:00",
            "OutTime": "16:00:00",
            "WorkingHours": "8 hours",
            "Status": "Present",
            "LateAnomolies": "20 min",
            "Approve": "Pending",
            "Reject":"No"

        },
        {
            "Date": "2024-02-15",
            "ID": 2,
            "Name": "Alice",
            "InTime": "08:30:00",
            "OutTime": "17:00:00",
            "WorkingHours": "8.5 hours",
            "Status": "Present",
            "LateAnomolies":"20 min",
            "Approve":"Pending",
            "Reject":"No"

        },
        {
            "Date": "2024-02-15",
            "ID": 3,
            "Name": "Bob",
            "InTime": "09:00:00",
            "OutTime": "17:30:00",
            "WorkingHours": "8.5 hours",
            "Status": "Present",
            "LateAnomolies":"20 min",
            "Approve":"Pending",
            "Reject":"No"

        },
         {
            "Date": "2024-02-13",
            "ID": 3,
            "Name": "ragav",
            "InTime": "09:00:00",
            "OutTime": "17:30:00",
            "WorkingHours": "8.5 hours",
            "Status": "Present",
            "LateAnomolies":"20 min",
            "Approve":"Pending",
            "Reject":"No"
         },
         {
           "Date": "",
           "ID": "",
           "Name": "",
           "InTime": "",
           "OutTime": "",
           "WorkingHours": "",
           "Status": "",
           "LateAnomolies":"",
           "Approve":"",
           "Reject":""
            },
            {       
              "Date": "",
              "ID": "",
              "Name": "",
              "InTime": "",
              "OutTime": "",
              "WorkingHours": "",
              "Status": "",
              "LateAnomolies":"",
              "Approve":"",
              "Reject":""
            },
            {
              "Date": "",
              "ID": "",
              "Name": "",
              "InTime": "",
              "OutTime": "",
              "WorkingHours": "",
              "Status": "",
              "LateAnomolies": "",
              "Approve": "",
              "Reject":""
            },
            {
              "Date": "",
              "ID": "",
              "Name": "",
              "InTime": "",
              "OutTime": "",
              "WorkingHours": "",
              "Status": "",
              "LateAnomolies":"",
              "Approve":"",
              "Reject":""
            }
                ];
$('#submitBtn').click(function() {
    var selectedDate = $('#date').val();
    var currentDate = new Date().toISOString().split('T')[0];

    if (selectedDate > currentDate) {
        alert("Please select a valid date.");
        return;
    }

    var filteredData = studentData.filter(function(student) {
        return student.Date === selectedDate;
    });

    populateTable(filteredData);
});


function populateTable(data) {
    var tableBody = $('#table-body');
    tableBody.empty();

    $.each(data, function(index, student) {
        var row = $('<tr></tr>');
        row.append('<td>' + student.Date + '</td>');
        row.append('<td>' + student.ID + '</td>');
        row.append('<td>' + student.Name + '</td>');
        row.append('<td>' + student.InTime + '</td>');
        row.append('<td>' + student.OutTime + '</td>');
        row.append('<td>' + student.WorkingHours + '</td>');
        row.append('<td>' + student.Status + '</td>');
        row.append('<td>' + student.LateAnomolies + '</td>');
        row.append('<td>' + student.Approve + '</td>');
        row.append('<td>' + student.Reject + '</td>');

        tableBody.append(row);
    });
}
});