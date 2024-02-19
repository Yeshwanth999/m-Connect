$(document).ready(function() {
    // Sample JSON data (you can replace this with your actual data)
    var studentData = [
        {
           
            "employeeID": 1,
            "designation": "hemanth",
            "photo": "Present",
            "clockIn": "08:00:00",
            "clockOut": "16:00:00",
            "hoursWorked": "8 hours",
            "request":"Pending"
           
 
        },
        {
            "employeeID": 2,
            "designation": "pooja",
            "photo": "Present",
            "clockIn": "08:00:00",
            "clockOut": "16:00:00",
            "hoursWorked": "8 hours",
            "request":"Pending"
 
        },
        {
            "employeeID": 3,
            "designation": "showry",
            "photo": "Present",
            "clockIn": "08:00:00",
            "clockOut": "16:00:00",
            "hoursWorked": "8 hours",
            "request":"Pending"
 
        },
         {
            "employeeID": 4,
            "designation": "John",
            "photo": "Present",
            "clockIn": "08:00:00",
            "clockOut": "16:00:00",
            "hoursWorked": "8 hours",
            "request":"Pending"
         },
         {
            "employeeID": 1,
            "designation": "John",
            "photo": "Present",
            "clockIn": "08:00:00",
            "clockOut": "16:00:00",
            "hoursWorked": "8 hours",
            "request":"Pending"
            },
            {      
            "employeeID": 1,
            "designation": "John",
            "photo": "Present",
            "clockIn": "08:00:00",
            "clockOut": "16:00:00",
            "hoursWorked": "8 hours",
            "request":"Pending"
            },
            {
                "employeeID": 1,
                "designation": "John",
                "photo": "Present",
                "clockIn": "08:00:00",
                "clockOut": "16:00:00",
                "hoursWorked": "8 hours",
                "request":"Pending"
            },
            {
                "employeeID": 2,
                "designation": "John",
                "photo": "Present",
                "clockIn": "08:00:00",
                "clockOut": "16:00:00",
                "hoursWorked": "8 hours",
                "request":"Pending"
            },
            {
                "employeeID": 3,
                "designation": "John",
                "photo": "Present",
                "clockIn": "08:00:00",
                "clockOut": "16:00:00",
                "hoursWorked": "8 hours",
                "request":"Pending"
            },
            {
                "employeeID": 4,
                "designation": "John",
                "photo": "Present",
                "clockIn": "08:00:00",
                "clockOut": "16:00:00",
                "hoursWorked": "8 hours",
                "request":"Pending"
            },
            {
                "employeeID": 5,
                "designation": "John",
                "photo": "Present",
                "clockIn": "08:00:00",
                "clockOut": "16:00:00",
                "hoursWorked": "8 hours",
                "request":"Pending"
            },
            {
                "employeeID": 1,
                "designation": "John",
                "photo": "Present",
                "clockIn": "08:00:00",
                "clockOut": "16:00:00",
                "hoursWorked": "8 hours",
                "request":"Pending"
            },
            {
                "employeeID": 1,
                "designation": "John",
                "photo": "Present",
                "clockIn": "08:00:00",
                "clockOut": "16:00:00",
                "hoursWorked": "8 hours",
                "request":"Pending"
            },
            {
                "employeeID": 1,
                "designation": "John",
                "photo": "Present",
                "clockIn": "08:00:00",
                "clockOut": "16:00:00",
                "hoursWorked": "8 hours",
                "request":"Pending"
            },
           
                ];
                var tableBody = $('#table-body');
   
                // Populate table rows with JSON data
                $.each(studentData, function(index, student) {
                    var row = $('<tr></tr>');
                    row.append('<td>' + student.employeeID + '</td>');
                    row.append('<td>' + student.designation + '</td>');
                    row.append('<td>' + student.photo + '</td>');
                    row.append('<td>' + student.clockIn + '</td>');
                    row.append('<td>' + student.clockOut + '</td>');
                    row.append('<td>' + student.hoursWorked + '</td>');
                    row.append('<td>' + student.request + '</td>');
                   
           
                   
                    // Add a class to empty cells
                    row.find('td').each(function() {
                        if ($(this).html().trim() === '') {
                            $(this).addClass('empty-cell');
                        }
                    });
                   
                    tableBody.append(row);
                });
            });    