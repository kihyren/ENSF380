package edu.ucalgary.oop;

interface IToDoList {
    void addTask(Task task);
    void deleteTask(String id);
    void editTask(String id, String newTitle, boolean completed);
    void undo();
    List<Task> listTasks();
}
