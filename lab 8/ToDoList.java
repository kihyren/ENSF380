import java.util.List;
import java.util.Stack;

public class ToDoList implements IToDoList {
    private Stack<List<Task>> history;
    private List<Task> tasks;

    public ToDoList(){
        this.history = new Stack<>();
        this.tasks = new List<>();
    }

    public listTasks(){
        return this.tasks;
    }

    public void addTask(Task task){
        this.tasks.add(task);
        history.push(tasks);
    }

    public void deleteTask(String id){
        if (tasks.length == 0){
            return;
        }

        for (int i = 0; i < tasks.length; i++){
            Task thisTask = tasks.get(i);
            if (thisTask.equals(id)){
                tasks.remove(i);
                history.push(tasks);
                return;
            }
        }
        return;
    }

    public void editTask(String id, String newTitle, boolean completed){

        for (int i = 0; i < tasks.length; i++){
            Task thisTask = tasks.get(i);
            if (thisTask.equals(id)){
                thisTask.setCompleted(completed);
                thisTask.setTitle(newTitle);
                history.push(tasks);
                return;
            }
        }
    }

    public void undo(){
        this.tasks = history.pop();
    }

}
