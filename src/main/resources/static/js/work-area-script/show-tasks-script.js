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

async function formatTasks(tasks) {
    let tab = '';
    tasks.forEach(task => {
        tab += `
            <tr class="task">
                <th>${task.title}</th>
                <th>${task.description}</th>
                <th>${((task.completed)? "Sim" : "Não")}</th>
                <th>${task.category.name}</th>
                <th>${task.priority.level}</th>
                <th>
                    <button class="button">Concluir</button>
                    <button class="button">Editar</button>
                    <button class="button">Excluir</button>
                </th>
            </tr>
        `;
    });
    document.getElementById("tasks-table").innerHTML += tab;
}

async function showTasks() {
    try {
        const data = await loadTasks();
        console.log(data);
        
        formatTasks(data);
        // const taskList = document.getElementById("task-list");
        
        
        // data.forEach(task => {
        //     const taskElement = document.createElement("li");
        //     taskElement.innerText = `Titulo: ${task.title} | Descrição: ${task.description} | Completada: ${(task.completed)? "Sim" : "Não"} | Categoria: ${task.category.name} | Prioridade: ${task.priority.level}`;
        //     tasksLis.push(taskList.appendChild(taskElement));
        // });
        // return tasksLis;
    } catch (error) {
        window.alert(`Problemas técnicos :( ${error}`);
    }
}

showTasks();