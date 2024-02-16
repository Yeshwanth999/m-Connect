function OpenEmployees() {

    var employeeListDiv = document.getElementById("employeeList");
    employeeListDiv.classList.toggle("hidden");

    
      // Example employee data
      var employees = [
        { name: "Employee 1", photo: "./Assets/MICRODEN.png" },
        { name: "Employee 2", photo: "./Assets/MICRODEN.png" },
        { name: "Employee 3", photo: "./Assets/MICRODEN.png" },
        { name: "Employee 1", photo: "./Assets/MICRODEN.png" },
        { name: "Employee 2", photo: "./Assets/MICRODEN.png" },{ name: "Employee 1", photo: "./Assets/MICRODEN.png" },
        { name: "Employee 2", photo: "./Assets/MICRODEN.png" },{ name: "Employee 1", photo: "./Assets/MICRODEN.png" },
        { name: "Employee 2", photo: "./Assets/MICRODEN.png" },{ name: "Employee 1", photo: "./Assets/MICRODEN.png" },
        { name: "Employee 2", photo: "./Assets/MICRODEN.png" },{ name: "Employee 1", photo: "./Assets/MICRODEN.png" },
        { name: "Employee 2", photo: "./Assets/MICRODEN.png" },{ name: "Employee 1", photo: "./Assets/MICRODEN.png" },
        { name: "Employee 2", photo: "./Assets/MICRODEN.png" },{ name: "Employee 1", photo: "./Assets/MICRODEN.png" },
        { name: "Employee 2", photo: "./Assets/MICRODEN.png" },{ name: "Employee 1", photo: "./Assets/MICRODEN.png" },
        { name: "Employee 2", photo: "./Assets/MICRODEN.png" },{ name: "Employee 1", photo: "./Assets/MICRODEN.png" },
        { name: "Employee 2", photo: "./Assets/MICRODEN.png" },{ name: "Employee 1", photo: "./Assets/MICRODEN.png" },
        { name: "Employee 2", photo: "./Assets/MICRODEN.png" },{ name: "Employee 1", photo: "./Assets/MICRODEN.png" },
        { name: "Employee 2", photo: "./Assets/MICRODEN.png" },{ name: "Employee 1", photo: "./Assets/MICRODEN.png" },
        { name: "Employee 2", photo: "./Assets/MICRODEN.png" },{ name: "Employee 1", photo: "./Assets/MICRODEN.png" },
        { name: "Employee 2", photo: "./Assets/MICRODEN.png" },{ name: "Employee 1", photo: "./Assets/MICRODEN.png" },
        { name: "Employee 2", photo: "./Assets/MICRODEN.png" },{ name: "Employee 1", photo: "./Assets/MICRODEN.png" },
        { name: "Employee 2", photo: "./Assets/MICRODEN.png" },{ name: "Employee 1", photo: "./Assets/MICRODEN.png" },
        { name: "Employee 2", photo: "./Assets/MICRODEN.png" },{ name: "Employee 1", photo: "./Assets/MICRODEN.png" },
        { name: "Employee 2", photo: "./Assets/MICRODEN.png" },{ name: "Employee 1", photo: "./Assets/MICRODEN.png" },
        { name: "Employee 2", photo: "./Assets/MICRODEN.png" },
      ];

      employees.forEach(function (employee) {
        var employeeDiv = document.createElement("div");
        employeeDiv.classList.add("employee");
        var img = document.createElement("img");
        img.src = employee.photo;
        img.alt = employee.name;
        img.height = "100";
        img.width = "100";
        var namePara = document.createElement("p");
        namePara.textContent = employee.name;
        employeeDiv.appendChild(img);
        employeeDiv.appendChild(namePara);
        employeeListDiv.appendChild(employeeDiv);

        // Adding click event listener to employee divs
        employeeDiv.addEventListener("click", function () {
          // Example action when employee div is clicked
          console.log("Employee clicked: " + employee.name);
        });
      });
    
  
  }