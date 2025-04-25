import URL_API from "./api-consts.js";

document.getElementById("card-form").addEventListener("submit", async (event) => {
    event.preventDefault();

    const name = document.getElementById("name");
    const email = document.getElementById("email");

    // localhost:8080/api/users/create
    await fetch(URL_API + "/users/create", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            name: name.value,
            email: email.value
        })
    })
    .then(response => {
        if(!response.ok) throw new Error("Erro ao cadastrar");
        return response.json();
    })
    .then(data => {
        localStorage.setItem("user", JSON.stringify(data));
        window.alert("Prazer em te conhecer " + data.name);
        window.location.href = "work-area.html";
    })
    .catch(error => {
        window.alert("Erro ao cadastrar: " + error.message);
    });

    name.value = "";
    email.value = "";
});