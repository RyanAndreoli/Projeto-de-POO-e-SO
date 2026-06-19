package datacenter;

public interface Scheduler {
    void addTask(Task task);
    Task nextTask();
    boolean hasTasks();
}