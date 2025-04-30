import URL_API from "./api-consts.js";

document.getElementById("login-form").addEventListener("submit", async (event) => {
    event.preventDefault();

    const email = document.getElementById("email-field");
    
    try {
        const response = await fetch(URL_API + "/users/login", { 
            method: "POST",
            headers: {
                "Content-Type":"application/json"
            },
            body: JSON.stringify({
                email: email.value
            })
        });

        if(!response.ok){
            const errorResponse = await response.json();
            throw errorResponse;
        }

        const data = await response.json();
        localStorage.setItem("user", JSON.stringify(data));
        window.alert("Bem vindo de volta " + data.name);
        window.location.href = "work-area.html";
    }catch(error){
        window.alert(`Erro ao realizar login: ${error.email || "erro desconhecido, volte mais tarde."}`);
    }
});