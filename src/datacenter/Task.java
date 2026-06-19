package datacenter;

public class Task {

    private int id;
    private int burstTime;
    private int priority;
    private long arrivalTime;
    private long startTime;
    private long endTime;

    public Task(int id, int burstTime, int priority) {
        this.id = id;
        this.burstTime = burstTime;
        this.priority = priority;
        this.arrivalTime = System.currentTimeMillis();
    }

    public int getId() { return id; }
    public int getBurstTime() { return burstTime; }
    public int getPriority() { return priority; }
    public long getArrivalTime() { return arrivalTime; }

    public void setStartTime(long startTime) { this.startTime = startTime; }
    public void setEndTime(long endTime) { this.endTime = endTime; }

    public long getWaitTime() { return startTime - arrivalTime; }
    public long getExecutionTime() { return endTime - startTime; }

    @Override
    public String toString() {
        return "Task[id=" + id + ", burst=" + burstTime + ", prioridade=" + priority + "]";
    }
}