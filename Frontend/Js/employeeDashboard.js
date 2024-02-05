
document.getElementById('profileImageInput').addEventListener('change', function() {
    var file = this.files[0];
    var reader = new FileReader();
  
    reader.onload = function(e) {
      document.getElementById('profileImage').setAttribute('src', e.target.result);
    }
  
    reader.readAsDataURL(file);
  });

  
  