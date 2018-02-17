public class ArrivalEvent extends Event {
    
    public ArrivalEvent(double when, Customer newCustomer){
        this.time = when;
        this.customer = newCustomer;        
    }
    
    
    @Override
    public Event run(Shop shop){
        Server assignedServer = shop.findServeurIdle();
        if (assignedServer != null){ 
            assignedServer.setOccupied();
            return new ServeEvent(time, customer);        
        }
        CustomerQueue queue = shop.findEmptyQueue();
        if (queue != null){
            queue.add(customer);
            return null;
        }
        shop.recordLeaving(customer.getId(), time);
        return null;
    }
    
    

    
    //if ser
}

/* NOTES
If server is idle
make server occupied
generate a ServeEvent
Or else
If there’s someone at the queue
Customer leaves (update the statistics)
If queue is empty
Customer queues (start timer, Customer should have a “stop-watch”
 */
