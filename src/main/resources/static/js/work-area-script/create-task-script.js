import URL_API from "../api-consts.js";

document.getElementById("task-form").addEventListener("submit", async (event) => {
    event.preventDefault();

    const form = document.getElementById("task-form");
    const submitter = document.getElementById("submit-btn");
    const formData = new FormData(form, submitter);
    const selectedCategoryOpt = document.getElementById("categories");
    try {
        const response = await fetch(URL_API + "/tasks/create", {
            method: "POST",
            headers: {
                "Content-Type":"application/json"
            },
            body: JSON.stringify({
                title: formData.get("title"),
                description: formData.get("description"),
                userEmail: JSON.parse(localStorage.getItem("user")).email,
                categoryName: selectedCategoryOpt.value,
                priorityLevel: formData.get("priority")
            })
        });
        
        if(!response.ok){
            const errorResponse = await response.json();
            throw errorResponse;
        }

        const responseData = await response.json();
        window.alert(`Tarefa "${responseData.title}" adcionada com sucesso`);
    } catch (error) {
        window.alert(`Erro ao criar tarefa: ${error.title || error.description}`);
    }
    form.reset();
    location.reload();
});