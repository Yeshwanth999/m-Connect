$('#logoutBtn').on('click', function() {

    const type = 'GET';
    const url = '';

    //adminFetchLogout(url, type);

    console.log("Hi this is Admin log out...")

    sessionStorage.removeItem("usermail");
    sessionStorage.removeItem("password");
    window.location.href = "SignIn.html";
});