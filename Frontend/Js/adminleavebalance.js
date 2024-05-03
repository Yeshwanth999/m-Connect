function balance() {
    const data = [
        {
          "Email": "yeswanth@gmail.com",
          "Leave Type": "Sick",
          "Credited": 20,
          "Used": 1,
          "Balance": 19,
        },
        {
            "Email": "priya@gmail.com",
            "Leave Type": "Paid",
            "Credited": 24,
            "Used": 5,
            "Balance": 19,
        },
        {
            "Email": "Nagi@gmail.com",
            "Leave Type": "Sick",
            "Credited": 10,
            "Used": 1,
            "Balance": 9,
        },
        {
            "Email": "omsai@gmail.com",
            "Leave Type": "Casual",
            "Credited": 12,
            "Used": 1,
            "Balance": 11,
        },
        {
            "Email": "divya@gmail.com",
            "Leave Type": "Emergency",
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
