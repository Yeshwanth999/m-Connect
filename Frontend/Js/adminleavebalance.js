function balance() {
    const data = [
        {
          "user id": "M-001",
          "Leave Type": "Sick",
          "Credited": 20,
          "Used": 1,
          "Balance": 19,
        },
        {
            "user id": "M-002",
            "Leave Type": "Paid",
            "Credited": 24,
            "Used": 5,
            "Balance": 19,
        },
        {
            "user id": "M-003",
            "Leave Type": "Sick",
            "Credited": 10,
            "Used": 1,
            "Balance": 9,
        },
        {
            "user id": "M-004",
            "Leave Type": "Casual",
            "Credited": 12,
            "Used": 1,
            "Balance": 11,
        },
        {
            "user id": "M-005",
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
