import URL_API from "../api-consts.js";

async function loadTasks() {
    const userEmail = JSON.parse(localStorage.getItem("user")).email;
    const response = await fetch(URL_API + "/tasks/getAll?email=" + encodeURIComponent(userEmail), {
        method: "GET",
        headers: {
            "Content-Type":"application/json"
        }
    });

    if(!response.ok){
        const responseError = await response.json();
        throw responseError;
    }
    
    return await response.json();
}

async function showTasks() {
    try {
        const data = await loadTasks();
        
        const taskList = document.getElementById("task-list");
        let tasksLis = [];

        data.forEach(task => {
            const taskElement = document.createElement("li");
            taskElement.innerText = `Titulo: ${task.title} | Descrição: ${task.description} | Completada: ${(task.completed)? "Sim" : "Não"} | Categoria: ${task.category.name} | Prioridade: ${task.priority.level}`;
            tasksLis.push(taskList.appendChild(taskElement));
        });
        return tasksLis;
    } catch (error) {
        window.alert(`Problemas técnicos :( ${error}`);
    }
}

async function formatTasks() {
    const tasksLis = await showTasks();
    tasksLis.forEach(taskLi => {
        taskLi.style.listStyle = "none";
        taskLi.style.color = "#fff"
        taskLi.style.padding = "2%";
    });
}

formatTasks();