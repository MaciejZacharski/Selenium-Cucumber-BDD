package SeleniumDemo.Models;

public class Task {

    private String taskNumber;
    private String taskDescription;

    public Task(String taskNumber, String taskDescription) {
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
    }

    @Override
    public String toString() {
        return "Task{" +
                "taskNumber='" + taskNumber + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                '}';
    }
}
