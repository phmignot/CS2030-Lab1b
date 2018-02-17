public class Customer {
    private final int id;
    private Server serverAssigned;
    private double arrivalTime;
    private double waitingTime;

    // Stop- watch 
    
    public Customer(int id){
        this.id = id;
        this.serverAssigned = null;
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
