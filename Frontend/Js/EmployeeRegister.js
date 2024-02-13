// Function to validate the form
function validateForm() {
  var form = document.getElementById("registrationForm");
  var inputs = form.querySelectorAll("input, select, textarea");
  var isValid = true;

  inputs.forEach(function(input) {
      if (!input.validity.valid) {
          isValid = false;
          if (input.id !== "") {
              var label = document.querySelector("label[for='" + input.id + "']");
              label.innerHTML += " <span class='error'></span>";
          }
      }
  });

  return isValid;
}

document.getElementById("registrationForm").addEventListener("submit", function(event) {
  event.preventDefault();

  // Validate the form
  let isValidForm = validateForm();

  if (isValidForm) {
      // Form is valid, proceed with form submission
      var formData = {
          personalInformation: {
              name: $('#name').val(),
              dob: $('#dob').val(),
              gender: $('#gender').val(),
              bloodGroup: $('#bloodGroup').val(),
              maritalStatus: $('#maritalStatus').val()
          },
          contactInformation: {
              officialEmail: $('#officialEmail').val(),
              personalEmail: $('#personalEmail').val(),
              phoneNumber: $('#phoneNumber').val(),
              alternatePhoneNumber: $('#alternatePhoneNumber').val()
          },
          address: {
              currentAddress: $('#currentAddress').val(),
              permanentAddress: $('#permanentAddress').val(),
              houseType: $('#houseType').val(),
              stayingSince: $('#stayingSince').val(),
              citySince: $('#citySince').val()
          }
      };

      var jsonData = JSON.stringify(formData);

      console.log(jsonData);

      // Process the form submission
      submitForm(jsonData);
  }
});

// Function to handle form submission
function submitForm(data) {
  const MySwal = Swal.mixin({
    scrollbarPadding: false
  });
  
  console.log('Form data:', data);
  MySwal.fire({
    title: 'Success',
    text: 'Form submitted successfully!',
    icon: 'success',
  }).then(() => {
      // Reset the form after successful submission
      document.getElementById("registrationForm").reset();
  });
}
