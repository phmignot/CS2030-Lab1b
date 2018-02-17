/**
 *
 */
public class ServeEvent extends Event{

    public static final double SERVICE_TIME = 1.0; // Time spent serving a customer
    
    public ServeEvent(double time, Customer customerServe) {
        this.time = time;
        this.customer = customerServe ;
    }

    public Event run(Shop shop){
        System.out.printf("%6.3f %d served\n", time, customer.getId());
        customer.stopWaiting(time);
        Server serverAssigned = customer.getServer();
        serverAssigned.setOccupied(); 
        DoneEvent DoneEvent = new DoneEvent(time + SERVICE_TIME, customer);
        return DoneEvent;
    }
}

/**
 DoneEvent doneE = new DoneEvent(time + this.SERVICE_TIME, Event.CUSTOMER_DONE);
 boolean ok = sim.scheduleEventInSimulator(doneE);
 if (!ok) {
 System.err.println("Warning: too many events.  Simulation result will not be correct.");
 }
 S.totalNumOfServedCustomer++;
 assert this.customerBeingServed == true; 
 */