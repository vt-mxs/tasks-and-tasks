document.getElementById("tasks-table").addEventListener("click", (e) => {
   const target = e.target;

   if (!target.matches(".edit-task-btn")) return;

   const taskInfo = target.dataset.info;
   
   localStorage.setItem("task_info", taskInfo);
   console.log(JSON.stringify(taskInfo));
   
   
   const openWindow = window.open("edit-task-area.html", "Atualizar tarefa", "left=auto,rigth=auto,width=600,height=900");

   if(!openWindow) window.alert("Não foi possivel abrir janela, desative o bloqueador de popups");

   const interval = setInterval(() => {
      if (openWindow.closed) {
         localStorage.removeItem("task_info");
         location.reload();
         clearInterval(interval);
      }
   }, 500);
});