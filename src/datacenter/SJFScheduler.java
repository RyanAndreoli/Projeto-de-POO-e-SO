cat > ~/projeto\ poo/src/datacenter/SJFScheduler.java << 'EOF'
package datacenter;

import java.util.PriorityQueue;

public class SJFScheduler implements Scheduler {

    private final PriorityQueue<Task> fila = new PriorityQueue<>(
        (a, b) -> a.getBurstTime() - b.getBurstTime()
    );

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
EOF