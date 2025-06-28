import URL_API from "../api-consts.js";

document.getElementById("card-form").addEventListener("submit", async (event) => {
    event.preventDefault();

    const name = document.getElementById("name");
    const email = document.getElementById("email");

    try {
        // localhost:8080/api/users/create
        const response = await fetch(URL_API + "/users/create", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                name: name.value,
                email: email.value
            })
        });
        
        if(!response.ok) {
            const responseError = await response.json();
            throw responseError;
        }

        const data = await response.json();
        localStorage.setItem("user", JSON.stringify(data));
        window.alert("Prazer em te conhecer " + data.name);
        window.location.href = "work-area.html";
    }catch(error){
        window.alert(`Erro ao cadastrar: ${error.email || error.name || "error desconhecido, volte mais tarde."}`);
    }
    name.value = "";
    email.value = "";
});