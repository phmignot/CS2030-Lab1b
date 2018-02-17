public class Customer {
    private final int id;
    private static int lastCustomerId;
    private Server serverAssigned;
    private double arrivalTime;
    private double waitingTime;

    // Stop- watch 
    
    public Customer(){
        this.serverAssigned = null;
        this.id = lastCustomerId;
        lastCustomerId++;
        arrivalTime = -1.0;
        waitingTime = -1.0;
    }


    public int getId() {
        return id;
    }

    public Server getServer() {
        return serverAssigned;
    }

    public double getArrivalTime() {
        return arrivalTime;
    }

    public double getWaitingTime() {
        return waitingTime;
    }
    
    public void stopWaiting(double time){
        this.waitingTime = time - getArrivalTime();
    }
}
