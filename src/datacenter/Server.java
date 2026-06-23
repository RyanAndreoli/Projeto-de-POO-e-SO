package datacenter;

public class Server implements Runnable {

    private int id;
    private Scheduler scheduler;
    private MetricsCollector metrics;

    public Server(int id, Scheduler scheduler, MetricsCollector metrics) {
        this.id = id;
        this.scheduler = scheduler;
        this.metrics = metrics;
    }

    @Override
    public void run() {
        while (true) {
            Task task = scheduler.nextTask();
            if (task == null) break;

            task.setStartTime(System.currentTimeMillis());
            System.out.println("Servidor " + id + " executando " + task);

            try {
                Thread.sleep(task.getBurstTime() * 100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }

            task.setEndTime(System.currentTimeMillis());
            System.out.println("Servidor " + id + " finalizou " + task);
            metrics.record(task);
        }
    }
}
