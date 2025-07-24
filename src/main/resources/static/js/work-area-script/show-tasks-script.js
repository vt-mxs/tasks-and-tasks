import URL_API from "../api-consts.js";

export async function loadTasks() {
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

export async function getTaskById(id) {
    const response = await fetch(URL_API + "/tasks/getById?id=" + encodeURIComponent(id), {
        method: "GET",
        headers: {
            "Content-Type":"application/json"
        }
    });
    if(!response.ok){
        const responseError = await response.json();
        throw responseError;
    }
    return response;
}

function formatTasks(tasks) {
    let tab = '';
    
    for(let i = 0; i < tasks.length; i++){
        const task = tasks.at(i);
        tab += `
            <tr class="task">
                <th class="task-${task.id}">${task.title}</th>
                <th class="task-${task.id}">${task.description}</th>
                <th class="task-${task.id}">${((task.completed)? "Sim" : "Não")}</th>
                <th class="task-${task.id}">${task.category.name}</th>
                <th class="task-${task.id}">${task.priority.level}</th>
                <th class="task-btns-${task.id}">
                    <button class="button">Concluir</button>
                    <button class="button">Editar</button>
                    <button class="button delete-task-btn" data-id="${task.id}">Excluir</button>
                </th>
            </tr>
        `;
    }
    
    document.getElementById("tasks-table").innerHTML += tab;
}

async function showTasks() {
    try {
        const data = await loadTasks();
        formatTasks(data);
        // const taskList = document.getElementById("task-list");
        
        
        // data.forEach(task => {
        //     const taskElement = document.createElement("li");
        //     taskElement.innerText = `Titulo: ${task.title} | Descrição: ${task.description} | Completada: ${(task.completed)? "Sim" : "Não"} | Categoria: ${task.category.name} | Prioridade: ${task.priority.level}`;
        //     tasksLis.push(taskList.appendChild(taskElement));
        // });
        // return tasksLis;
    } catch (error) {
        console.log(JSON.stringify(error));
        
        window.alert(`Problemas técnicos :( ${error}`);
    }
}

showTasks();