package edu.ucalgary.oop;

import java.util.Objects;

public class Task {

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task task = (Task) obj;
        return Objects.equals(id, task.id) &&
               Objects.equals(title, task.title) &&
               isCompleted == task.isCompleted; 
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, isCompleted);
    }

    private String id;
    private String title;
    private boolean isCompleted;

    private Task(String id, String title){
        this.id = id;
        this.title = title;
        this.isCompleted = false;
    }

    public String getId(){
        return id;
    }

    public String getTitle(){
        return title;
    }

    public boolean isCompleted(){
        return isCompleted;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setCompleted(boolean isCompleted){
        this.isCompleted = isCompleted;
    }

    public Task copy() {
        return new Task(this.id, this.title);
    }



}
