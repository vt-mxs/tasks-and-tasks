let taskInfo = JSON.parse(localStorage.getItem("task_info"));
console.log("Task info carregada:", taskInfo);

console.log(taskInfo);
document.getElementById("title").value = taskInfo.title || "";
document.getElementById("description-area").value = taskInfo.description || "";

const selectEl = document.getElementById("categories");

if(selectEl){
   selectEl.value = taskInfo.category.name;
}

const priorityRadios = document.querySelectorAll('input[name="priority"]');
priorityRadios.forEach(radio => {
   if(radio.value === taskInfo.priority.level){
      radio.checked = true;
   }
});