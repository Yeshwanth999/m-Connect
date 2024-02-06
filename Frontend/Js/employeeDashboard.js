
document.getElementById('profileImageInput').addEventListener('change', function() {
    var file = this.files[0];
    var reader = new FileReader();
  
    reader.onload = function(e) {
      document.getElementById('profileImage').setAttribute('src', e.target.result);
    }
  
    reader.readAsDataURL(file);
});


const month = new Date();
const options = {
  month: "long"
};

const year1 = new Date();

let year = year1.getFullYear();

const date1 = new Date();

let date = date1.getDate();

const day = new Date();

const options2 = {
  weekday: "long"
};

console.log(day.toLocaleString("en-IN", options2));

function myFunction() {
  document.getElementById("month").innerText = month.toLocaleString(
    "en-IN",
    options
  );
  document.getElementById("year").innerText = year;
  document.getElementById("date").innerText = date;
  document.getElementById("day").innerText = day.toLocaleString(
    "en-IN",
    options2
  );
}
myFunction();


function loadPage(url) {
  document.getElementById('iframe-content').src = url;
}

  
  