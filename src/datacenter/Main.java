package datacenter;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("=== FIFO ===");
        DataCenter dc1 = new DataCenter(new FIFOScheduler(), 2);
        dc1.submitTask(new Task(1, 5, 2));
        dc1.submitTask(new Task(2, 3, 1));
        dc1.submitTask(new Task(3, 8, 3));
        dc1.submitTask(new Task(4, 2, 1));
        dc1.start("FIFO");

        System.out.println("\n=== SJF ===");
        DataCenter dc2 = new DataCenter(new SJFScheduler(), 2);
        dc2.submitTask(new Task(1, 5, 2));
        dc2.submitTask(new Task(2, 3, 1));
        dc2.submitTask(new Task(3, 8, 3));
        dc2.submitTask(new Task(4, 2, 1));
        dc2.start("SJF");
    }
}