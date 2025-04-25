import URL_API from "./api-consts.js";

document.getElementById("login-form").addEventListener("submit", async (event) => {
    event.preventDefault();

    const email = document.getElementById("email-field");
    
    await fetch(URL_API + "/users/login", { 
        method: "POST",
        headers: {
            "Content-Type":"application/json"
        },
        body: JSON.stringify({
            email: email.value
        })
    })
    .then(response => {
        if(!response.ok) throw new Error("Erro ao realizar login");
        return response.json();
    })
    .then(data => {
        window.alert("Bem vindo de volta " + data.name)
    })
    .catch(error => {
        window.alert(error.message)
    });
});