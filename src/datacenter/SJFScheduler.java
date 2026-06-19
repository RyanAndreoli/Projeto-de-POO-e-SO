package datacenter;

import java.util.PriorityQueue;

public class SJFScheduler implements Scheduler {

    private PriorityQueue<Task> fila = new PriorityQueue<>(
        (a, b) -> a.getBurstTime() - b.getBurstTime()
    );

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