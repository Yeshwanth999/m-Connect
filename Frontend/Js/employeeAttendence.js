
$(document).ready(function() {
    // Sample JSON data (you can replace this with your actual data)
    var studentData = [
        {
            "Date": "2024-02-15",
            "ID": 1,
            "Name": "John",
            "InTime": "08:00",
            "OutTime": "16:00",
            "WorkingHours": "8 hours",
            "Status": "Present",
            "LateAnomolies":"20 min",
            "Aprove":"Pending",
            "Reject":"No"

        },
        {
            "Date": "2024-02-15",
            "ID": 2,
            "Name": "Alice",
            "InTime": "08:30",
            "OutTime": "17:00",
            "WorkingHours": "8.5 hours",
            "Status": "Present",
            "LateAnomolies":"20 min",
            "Aprove":"Pending",
            "Reject":"No"

        },
        {
            "Date": "2024-02-15",
            "ID": 3,
            "Name": "Bob",
            "InTime": "09:00",
            "OutTime": "17:30",
            "WorkingHours": "8.5 hours",
            "Status": "Present",
            "LateAnomolies":"20 min",
            "Aprove":"Pending",
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
             "Aprove":"",
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
           "Aprove":"",
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
              "Aprove":"",
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
              "Aprove": "",
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
              "Aprove":"",
              "Reject":""
            }
                ];
            
    var tableBody = $('#table-body');
    
    // Populate table rows with JSON data
    $.each(studentData, function(index, student) {
        var row = $('<tr></tr>');
        row.append('<td>' + student.Date + '</td>');
        row.append('<td>' + student.ID + '</td>');
        row.append('<td>' + student.Name + '</td>');
        row.append('<td>' + student.InTime + '</td>');
        row.append('<td>' + student.OutTime + '</td>');
        row.append('<td>' + student.WorkingHours + '</td>');
        row.append('<td>' + student.Status + '</td>');
        row.append('<td>' + student.LateAnomolies + '</td>');
        row.append('<td>' + student.Aprove + '</td>');
        row.append('<td>' + student.Reject + '</td>');

        
        // Add a class to empty cells
        row.find('td').each(function() {
            if ($(this).html().trim() === '') {
                $(this).addClass('empty-cell');
            }
        });
        
        tableBody.append(row);
    });
});
