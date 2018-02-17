/**
 * 
 */


public class Statistique {
    

    // The next three members are used to keep track of simulation statistics
    private double totalWaitingTime; // total time everyone spent waiting
    private int totalNumOfServedCustomer; // how many customer has waited
    private int totalNumOfLostCustomer; // how many customer has been lost

    public Statistique(){
        totalWaitingTime=0; // total time everyone spent waiting
        totalNumOfServedCustomer=0; // how many customer has waited
        totalNumOfLostCustomer=0;
    }

    public double getTotalWaitingTime(){
        return totalWaitingTime;
    }

    public int getTotalNumOfServedCustomer(){
        return totalNumOfServedCustomer;
    }

    public int getTotalNumOfLostCustomer(){
        return totalNumOfLostCustomer;
    }
    
    public double getAverageWaitingTime(){
        return (getTotalWaitingTime() / getTotalNumOfServedCustomer());
    }

    public void incrementLostCustomer() {
        this.totalNumOfLostCustomer += 1;
    }

    public void incrementServedCustomer() {
        this.totalNumOfServedCustomer += 1;
    }

    /**
     * Adds the total waiting time by the intput
     * @param waitingTime
     */
    public void addTotalWaitingTime(double waitingTime) {
        this.totalWaitingTime += waitingTime;
    }

    /**
     * Updates statistics due to a DoneEvent. 
     * @param time
     */
    
    public void recordDone(double time){
        addTotalWaitingTime(time);
        incrementServedCustomer();
    }

    // Print stats as three numbers:
    // <avg waiting time> <number of served customer> <number of lost customer>
    
    public void printStats(){
        System.out.printf("%.3f %d %d\n", getAverageWaitingTime(),
                getTotalNumOfServedCustomer(), getTotalNumOfLostCustomer());
    }
}
