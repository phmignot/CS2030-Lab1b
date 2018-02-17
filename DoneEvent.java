/**
 * 
 */
public class DoneEvent extends Event{
    
    public DoneEvent(double time, Customer customerDone) {
        this.time = time;
        this.customer = customerDone;
    }
    
    public Event run(Shop shop){
        double waitingTime = customer.getWaitingTime();
        shop.recordDone(waitingTime);
        Server serverDone = customer.getServer();
        if (shop.isServerQueueEmpty(serverDone.getId())){
            Customer nextCustomer = shop.getCustumerInQueue(serverDone.getId());
            Event serveEvent = new ServeEvent(time, nextCustomer);
            return serveEvent;
        }
        serverDone.setIdle();
        return null;
    }
}
