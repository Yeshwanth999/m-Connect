
document.getElementById('profileImageInput').addEventListener('change', function () {
  var file = this.files[0];
  var reader = new FileReader();

  reader.onload = function (e) {
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


function loadPage(pageUrl) {
  document.getElementById('iframe-content').src = pageUrl;
}



let mainTimerInterval;
let breakTimerInterval;
let breakStart = JSON.parse(localStorage.getItem('breakStart')) || [];
let breakEnd = JSON.parse(localStorage.getItem('breakEnd')) || [];
let totalMainSeconds = parseInt(sessionStorage.getItem('totalMainSeconds')) || 0;
let isMainTimerRunning = JSON.parse(sessionStorage.getItem('isMainTimerRunning')) || false;
let isBreakTime = JSON.parse(sessionStorage.getItem('isBreakTime')) || false;

function startTimer() {
  document.querySelector('.startTimer').style.display = 'none';
  document.querySelector('.timerDiv').style.display = 'block';
  document.querySelector('#timerValue').style.display = 'block';
  if (!isMainTimerRunning) {
    mainTimerInterval = setInterval(updateMainTimer, 1000);
    isMainTimerRunning = true;
    sessionStorage.setItem('isMainTimerRunning', JSON.stringify(isMainTimerRunning));
  }
  const loginTime = new Date().toLocaleTimeString();
  const loginDate = new Date().toLocaleDateString();
  console.log("logged in date: " + loginDate);
  console.log("Logged in at: " + loginTime);
}

function updateMainTimer() {
  if (!isBreakTime) {
    totalMainSeconds++;
    sessionStorage.setItem('totalMainSeconds', totalMainSeconds);
    const formattedTime = formatTime(totalMainSeconds);
    document.getElementById('timerValue').innerText = formattedTime;
    updateTotalTime();
  }
}

function toggleBreak() {
  if (!isMainTimerRunning)
    return;

  if (!isBreakTime) {
    if (breakStart.length < 3) {
      isBreakTime = true;
      sessionStorage.setItem('isBreakTime', JSON.stringify(isBreakTime));
      breakStart.push(totalMainSeconds);
      localStorage.setItem('breakStart', JSON.stringify(breakStart));
      breakTimerInterval = setInterval(updateBreakTimer, 1000);

      // console.log("Break " + breakStart.length + " started at: " + new Date().toLocaleTimeString());
      if (1 == breakStart.length) {
        const firstBreak = new Date().toLocaleTimeString();
        console.log(firstBreak + " : firstbreak in");
      }
      if (2 == breakStart.length) {
        const secondBreak = new Date().toLocaleTimeString();
        console.log(secondBreak + " : secondbreak in");
      }
      if (3 == breakStart.length) {
        const thirdBreak = new Date().toLocaleTimeString();
        console.log(thirdBreak + " : thirdbreak in");
      }


    }
  }

  else {
    isBreakTime = false;
    sessionStorage.setItem('isBreakTime', JSON.stringify(isBreakTime));
    breakEnd.push(totalMainSeconds);
    localStorage.setItem('breakEnd', JSON.stringify(breakEnd));
    // console.log("Break " + breakEnd.length + " ended at: " + new Date().toLocaleTimeString());
    if (1 == breakEnd.length) {
      const firstBreakout = new Date().toLocaleTimeString();
      console.log(firstBreakout + " : firstbreakout");
    }
    if (2 == breakEnd.length) {
      const secondBreakout = new Date().toLocaleTimeString();
      console.log(secondBreakout + " : secondbreakout");
    }
    if (3 == breakEnd.length) {
      const thirdBreakout = new Date().toLocaleTimeString();
      console.log(thirdBreakout + " : thirdbreakout");
    }
    updateBreakTime();
  }
}

function handleLogout() {
  clearInterval(mainTimerInterval);
  clearInterval(breakTimerInterval);
  updateTotalTime();
  alert('Logged out!\nTotal login time: ' + formatTime(totalMainSeconds));
  console.log("Logged out at: " + new Date().toLocaleTimeString());
  console.log("Total login time: " + formatTime(totalMainSeconds));
  resetTimers();
}

function resetTimers() {
  totalMainSeconds = 0;
  breakStart = [];
  breakEnd = [];
  isMainTimerRunning = false;
  isBreakTime = false;
  sessionStorage.removeItem('totalMainSeconds');
  sessionStorage.removeItem('isMainTimerRunning');
  sessionStorage.removeItem('isBreakTime');
  document.querySelector('.startTimer').style.display = 'block';
  document.querySelector('.timerDiv').style.display = 'none';
  document.getElementById('timerValue').innerText = '00:00:00';
  document.getElementById('break1Time').innerText = '00:00:00';
  document.getElementById('break2Time').innerText = '00:00:00';
  document.getElementById('break3Time').innerText = '00:00:00';
  document.getElementById('totalTimeValue').innerText = '00:00:00';
}

function formatTime(seconds) {
  const hours = Math.floor(seconds / 3600);
  const minutes = Math.floor((seconds % 3600) / 60);
  const remainingSeconds = seconds % 60;
  const formattedHours = padZero(hours);
  const formattedMinutes = padZero(minutes);
  const formattedSeconds = padZero(remainingSeconds);
  return `${formattedHours}:${formattedMinutes}:${formattedSeconds}`;
}

function padZero(value) {
  return value < 10 ? `0${value}` : value;
}

function updateBreakTimer() {
  if (isBreakTime) {
    totalMainSeconds++;
    updateTotalTime();
  }
}

function updateBreakTime() {
  let totalBreakTime = calculateBreakTime();
  sessionStorage.setItem('breakTime', JSON.stringify(totalBreakTime));
  document.getElementById('totalBreakTime').innerText = formatTime(totalBreakTime);
}

function calculateBreakTime() {
  let totalBreakTime = 0;
  for (let i = 0; i < breakStart.length; i++) {
    totalBreakTime += breakEnd[i] - breakStart[i];
  }
  return totalBreakTime;
}

function updateTotalTime() {
  let totalLoginTime = totalMainSeconds - calculateBreakTime();
  document.getElementById('totalTimeValue').innerText = formatTime(totalLoginTime);
  sessionStorage.setItem('totalLoginTime', formatTime(totalLoginTime));

  // console.log("Total Login Time: " + formatTime(totalLoginTime));
  // console.log("Total Break Time: " + formatTime(calculateBreakTime()));
}

window.onload = function () {
  totalMainSeconds = parseInt(localStorage.getItem('totalMainSeconds')) || 0;
  isMainTimerRunning = JSON.parse(localStorage.getItem('isMainTimerRunning')) || false;
  isBreakTime = JSON.parse(localStorage.getItem('isBreakTime')) || false;
  breakStart = JSON.parse(localStorage.getItem('breakStart')) || [];
  breakEnd = JSON.parse(localStorage.getItem('breakEnd')) || [];

  if (isMainTimerRunning) {
    document.querySelector('.startTimer').style.display = 'none';
    document.querySelector('.timerDiv').style.display = 'block';
    document.querySelector('#timerValue').style.display = 'block';
    mainTimerInterval = setInterval(updateMainTimer, 1000);
    if (isBreakTime) {
      breakTimerInterval = setInterval(updateBreakTimer, 1000);
    }
    updateBreakTime();
    updateTotalTime();
  }
}
window.addEventListener('beforeunload', function (event) {
  localStorage.setItem('totalMainSeconds', totalMainSeconds);
  localStorage.setItem('isMainTimerRunning', isMainTimerRunning);
  localStorage.setItem('isBreakTime', isBreakTime);
  localStorage.setItem('breakStart', JSON.stringify(breakStart));
  localStorage.setItem('breakEnd', JSON.stringify(breakEnd));
});

