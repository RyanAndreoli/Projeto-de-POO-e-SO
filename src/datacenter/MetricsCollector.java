package datacenter;

import java.util.ArrayList;
import java.util.List;

public class MetricsCollector {

    private List<Task> tasks = new ArrayList<>();
    private long startTime = System.currentTimeMillis();

    public synchronized void record(Task task) {
        tasks.add(task);
    }

    public void printReport(String algoritmo) {
        double totalWait = 0;
        double totalExec = 0;

        for (Task t : tasks) {
            totalWait += t.getWaitTime();
            totalExec += t.getExecutionTime();
        }

        double avgWait = totalWait / tasks.size();
        double avgExec = totalExec / tasks.size();
        double throughput = tasks.size() / ((System.currentTimeMillis() - startTime) / 1000.0);

        System.out.println("\n=== Métricas: " + algoritmo + " ===");
        System.out.printf("Tempo médio de espera:   %.2f ms%n", avgWait);
        System.out.printf("Tempo médio de execução: %.2f ms%n", avgExec);
        System.out.printf("Throughput:              %.2f tarefas/segundo%n", throughput);
        System.out.println("Total de tarefas:        " + tasks.size());
    }
}