import URL_API from "../api-consts.js";

async function deleteTask(taskId) {
   if(!taskId){
      console.log("não definido");
      return;
   }

   const userEmail = JSON.parse(localStorage.getItem("user")).email;
   const response = await fetch(URL_API + "/tasks/deleteById/" + encodeURIComponent(taskId), {
      method: 'DELETE',
      headers: {
         'Content-Type': 'application/json'
      }
   });
   if(!response.ok){
      const responseError = await response.json();
      throw responseError;
   }

   const taskRow = document.querySelector(`tr.task th.task-${taskId}`)?.parentElement;
   if (taskRow) {
      taskRow.remove();
   }
}

document.addEventListener("click", (e) => {
   if(!e.target && !e.target.matches(".delete-task-btn")){
      console.log("delete task btn não definido");
      return;
   }

   let wantToDelete = window.confirm("Tem certeza que quer deletar essa tarefa?");

   if(wantToDelete){
      const taskId = e.target.dataset.id;
      deleteTask(taskId)
   }
   else {
      window.alert("Operação cancelada");
   }
});