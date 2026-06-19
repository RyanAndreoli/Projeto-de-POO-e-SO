package datacenter;

import java.util.LinkedList;
import java.util.Queue;

public class FIFOScheduler implements Scheduler {

    private Queue<Task> fila = new LinkedList<>();

    @Override
    public void addTask(Task task) {
        fila.add(task);
    }

    @Override
    public Task nextTask() {
        return fila.poll();
    }

    @Override
    public boolean hasTasks() {
        return !fila.isEmpty();
    }
}