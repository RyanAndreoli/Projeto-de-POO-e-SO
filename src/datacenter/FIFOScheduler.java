package datacenter;

import java.util.LinkedList;
import java.util.Queue;

public class FIFOScheduler implements Scheduler {

    private final Queue<Task> fila = new LinkedList<>();

    @Override
    public synchronized void addTask(Task task) {
        fila.add(task);
    }

    @Override
    public synchronized Task nextTask() {
        return fila.poll();
    }

    @Override
    public synchronized boolean hasTasks() {
        return !fila.isEmpty();
    }
}
