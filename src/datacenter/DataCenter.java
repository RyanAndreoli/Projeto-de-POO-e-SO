package datacenter;

import java.util.ArrayList;
import java.util.List;

public class DataCenter {

    private Scheduler scheduler;
    private int numServers;
    private MetricsCollector metrics;

    public DataCenter(Scheduler scheduler, int numServers) {
        this.scheduler = scheduler;
        this.numServers = numServers;
        this.metrics = new MetricsCollector();
    }

    public void submitTask(Task task) {
        scheduler.addTask(task);
    }

    public void start(String algoritmo) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();

        for (int i = 1; i <= numServers; i++) {
            Server server = new Server(i, scheduler, metrics);
            Thread t = new Thread(server);
            threads.add(t);
            t.start();
        }

        for (Thread t : threads) {
            t.join();
        }

        metrics.printReport(algoritmo);
    }
}