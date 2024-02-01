// Function to show input fields for editing
function editSection(sectionId) {
    // Hide display area
    document.getElementById(sectionId + "Display").style.display = "none";
    // Show input fields for editing
    document.getElementById(sectionId + "Fields").style.display = "block";
  }
  
  // Function to save changes
  function saveSection(sectionId) {
    // Get input values
    var inputs = document.getElementById(sectionId + "Fields").querySelectorAll("input, select, textarea");
    var displayContent = "";
    // Update display content
    inputs.forEach(function(input) {
      if (input.type !== "button") {
        displayContent += "<p><strong>" + input.previousElementSibling.textContent.replace(":", "") + ":</strong> " + input.value + "</p>";
      }
    });
    // Update display area with edited content
    document.getElementById(sectionId + "Display").innerHTML = displayContent;
    // Hide input fields
    document.getElementById(sectionId + "Fields").style.display = "none";
    // Show updated display area
    document.getElementById(sectionId + "Display").style.display = "block";
  }
  
  // Function to cancel editing
  function cancelEdit(sectionId) {
    // Hide input fields
    document.getElementById(sectionId + "Fields").style.display = "none";
    // Show display area without changes
    document.getElementById(sectionId + "Display").style.display = "block";
  }
  
  // You can add event listeners and additional logic as needed
  