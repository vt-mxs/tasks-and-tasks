import URL_API from "../api-consts.js";

document.getElementById("task-form").addEventListener("submit", async (event) => {
   event.preventDefault();

   // Pegando info da task que está sendo editada
   const taskInfo = JSON.parse(localStorage.getItem("task_info"));
   if(!taskInfo || !taskInfo.id){
      window.alert("Erro: tarefa não encontrada para edição.");
      return;
   }

   const form = document.getElementById("task-form");
   const formData = new FormData(form);

   const selectedCategoryOpt = document.getElementById("categories");
   
   try {
      const response = await fetch(URL_API + "/tasks/update", {
         method: "PUT",
         headers: {
            "Content-Type": "application/json"
         },
         body: JSON.stringify({
            id: taskInfo.id,
            title: formData.get("title"),
            description: formData.get("description"),
            categoryName: selectedCategoryOpt.value,
            priorityLevel: formData.get("priority")
         })
      });

      if(!response.ok){
         const errorResponse = await response.json();
         throw errorResponse;
      }

      const responseData = await response.json();
      window.alert(`Tarefa "${responseData.title}" atualizada com sucesso`);
   } catch (error) {
      window.alert(`Erro ao atualizar tarefa: ${error.title || error.description || error}`);
   }

   // Limpando e fechando o form
   form.reset();
   //localStorage.removeItem("task_info");
   // location.reload();
   window.close();
});
