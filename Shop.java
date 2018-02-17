import java.util.ArrayList;
import java.util.List;

public class Shop {

    private final List<Server> serverList = new ArrayList<>();
    private final int numberServer;
    private final List<CustomerQueue> queueList = new ArrayList<>();
    private Statistique shopStats;
    
    public Shop(int numberServeur){
        this.numberServer = numberServeur;
        inciateShopList(numberServer);
        shopStats = new Statistique();
    }

    /**
     * Builds a list of Servers and a list of their CustomerQueue associated, of the size of the input given.
     * @param numberServer
     */
    private void inciateShopList(int numberServer){
        for (int serverId = 0; serverId < numberServer; serverId++){
            Server toAdd = new Server(serverId);
            serverList.add(toAdd);
            queueList.add(new CustomerQueue());
        }
    }

    /**
     * Looks in the serverList for a server idle
     * @return Server Idle
     */

    public Server findServeurIdle(){
        int compter = 0;
        while (compter < numberServer){
            Server nextServer = serverList.get(compter);
            if (nextServer.getStatus() == Server.IDLE){
                return nextServer;
            }
            compter++;
        }
        return null;
    }

    /**
     * Looks in the queueList for a CustomerQueue empty
     * @return CustomerQueue 
     */

    public CustomerQueue findEmptyQueue(){
        int compter = 0;
        while (compter < numberServer){
            CustomerQueue nextQueue = queueList.get(compter);
            if (nextQueue.isEmpty()){
                return nextQueue;
            }
            compter++;
        }
        return null;
    }
    
    public boolean isServerQueueEmpty(int serverId){
        return (getCustomerQueue(serverId).isEmpty());
    }
    
    public CustomerQueue getCustomerQueue(int index){
        return queueList.get(index);
    }
    
    public Customer getCustumerInQueue(int serverId){
        Customer customer = getCustomerQueue(serverId).remove();
        return customer;
    }
    
    /**
     * Records a leaving customer in the statistics
     * @param customerId 
     * @param time
     */
    public void recordLeaving(int customerId ,double time) {
        System.out.printf("%6.3f %d leaves\n", time, customerId);
        shopStats.incrementLostCustomer();
    }

    /**
     * Updates statistics due to a DoneEvent.
     * @param time
     */
    public void recordDone(double time){
        shopStats.recordDone(time);
    }
}
