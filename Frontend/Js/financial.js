$(document).ready(function() {
    // Sample JSON data (you can replace this with your actual data)
    var studentData = [
        {
            "EmpID": "20",
            "JoiningDate": "10/10/2023",
            "BankName": "nagaraju",
            "AnnualCTC": "500000",
            "ExtraPerksOverTimeHours": "16:00:00",
            "Deductions": "8 hours",
            "Withwithoutpf": "....",
            "SalaryDate":"asp",
        },
        {
            "EmpID": "21",
            "JoiningDate":"10/10/2023" ,
            "BankName": "krishna",
            "AnnualCTC": "500000",
            "ExtraPerksOverTimeHours": "16:00:00",
            "Deductions": "8 hours",
            "Withwithoutpf": "...",
            "SalaryDate":"asp",

        },
        {
            "EmpID": "22",
            "JoiningDate": "10/10/2023",
            "BankName": "hemanth",
            "AnnualCTC": "500000",
            "ExtraPerksOverTimeHours": "16:00:00",
            "Deductions": "8 hours",
            "Withwithoutpf": "....",
            "SalaryDate":"asp",
        },
         {
            "EmpID": "23",
            "JoiningDate": "10/10/2023",
            "BankName": "srinivas",
            "AnnualCTC": "500000",
            "ExtraPerksOverTimeHours": "16:00:00",
            "Deductions": "8 hours",
            "Withwithoutpf": "....",
            "SalaryDate":"asp",
         },
         {
            "EmpID": "24",
            "JoiningDate": "10/10/2023",
            "BankName": "sandeep",
            "AnnualCTC": "500000",
            "ExtraPerksOverTimeHours": "16:00:00",
            "Deductions": "8 hours",
            "Withwithoutpf": "...",
            "SalaryDate":"asp",
            },
            {       
                "EmpID": "25",
                "JoiningDate": "10/10/2023",
                "BankName": "rajesh",
                "AnnualCTC": "500000",
                "ExtraPerksOverTimeHours": "16:00:00",
                "Deductions": "8 hours",
                "Withwithoutpf": "...",
                "SalaryDate":"asp",
            },
            {
                "EmpID": "26",
                "JoiningDate": "10/10/2023",
                "BankName": "rakesh",
                "AnnualCTC": "500000",
                "ExtraPerksOverTimeHours": "16:00:00",
                "Deductions": "8 hours",
                "Withwithoutpf": "....",
                "SalaryDate":"asp",
            },
            {
                "EmpID": "27",
                "JoiningDate": "10/10/2023",
                "BankName": "divya",
                "AnnualCTC": "1500000",
                "ExtraPerksOverTimeHours": "16:00:00",
                "Deductions": "8 hours",
                "Withwithoutpf": "...",
                "SalaryDate":"asp",
            }
        ];

        var tableBody = $('#table-body');
    
    // Populate table rows with JSON data
    $.each(studentData, function(index, student) {
        var row = $('<tr></tr>');
        row.append('<td>' + student.EmpID  + '</td>');
        row.append('<td>' + student.JoiningDate + '</td>');
        row.append('<td>' + student.BankName+ '</td>');
        row.append('<td>' + student.AnnualCTC+ '</td>');
        row.append('<td>' + student.ExtraPerksOverTimeHours+ '</td>');
        row.append('<td>' + student.Deductions + '</td>');
        row.append('<td>' + student.Withwithoutpf + '</td>');
        row.append('<td>' + student.SalaryDate + '</td>');

        
        // Add a class to empty cells
        row.find('td').each(function() {
            if ($(this).html().trim() === '') {
                $(this).addClass('empty-cell');
            }
        });
        
        tableBody.append(row);
    });
});