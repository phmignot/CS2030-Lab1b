

/**
 * Simulator encapsulates all the information relevant to the current simulation.
 */

public class Simulator {

    // The first two members are constants, used to configure the simulator.
    public static final int MAX_NUMBER_OF_EVENTS = 100; // Maximum number of events
    /* to Server class public static final double SERVICE_TIME = 1.0; // Time spent serving a customer
*/
    // The next two members are used to store scheduled events
    private Event[] events; // Array of events, order of events not guaranteed.
    private int numOfEvents; // The number of events in the event array.
    private Shop shop;
     /** to the server
    // The next three members are used to record the states of the simulation
    private boolean customerBeingServed; // is a customer currently being served?
    private boolean customerWaiting; // is a customer currently waiting?
    private double timeStartedWaiting; // the time the current waiting customer started waiting
*/
     /** To the Stats
    // The next three members are used to keep track of simulation statistics
    private double totalWaitingTime; // total time everyone spent waiting
    private int totalNumOfServedCustomer; // how many customer has waited
    private int totalNumOfLostCustomer; // how many customer has been lost
*/
    /** to the server
    // The next three members are used to identify customer
    private int lastCustomerId; // starts from 0 and increases as customer arrives.
    private int servedCustomerId; // id of the customer being served, if any
    private int waitingCustomerId; // id of the customer currently waiting, if any
     */
     
    /**
     * Create a simulator, initialize the value.
     */
    public Simulator() {
        this.events = new Event[this.MAX_NUMBER_OF_EVENTS];
        this.numOfEvents = 0;
        this.shop = new Shop(5);
        /**this.customerWaiting = false;
        this.customerBeingServed = false;
        this.lastCustomerId = 0;
        this.servedCustomerId = -1;
        this.waitingCustomerId = -1;
         */
    }
    
    /**
     * Schedule the event with the simulator.  The simulator maintains
     * an array of event (in arbitrary order) and this method simply
     * appends the given event to the end of the array.
     *
     * @return true if the event is added successfully; false otherwise.
     */
    public boolean scheduleEventInSimulator(Event e) {
        if (this.numOfEvents >= this.MAX_NUMBER_OF_EVENTS) {
            return false;
        } else {
            // append e as the last element in array sim.events.
            this.events[this.numOfEvents] = e;
            this.numOfEvents++;
            return true;
        }
    }

    /**
     * Run the simulator until there is no more events scheduled.
     */

    public void runSimulator() {
        while (this.numOfEvents > 0) {
            Event e = this.getNextEarliestEvent();
            Event resultEvent = e.run(shop);
            boolean isAdd = scheduleEventInSimulator(resultEvent);
            if (!isAdd) {
                System.err.println("Warning: too many events.  " +
                        "Simulation result will not be correct.");
            }
        }
        //Stats.printStats();
    }

    /**
     * Find the next event with the earliest timestamp, breaking
     * ties arbitrarily.  The event is then deleted from the array.
     * This is an O(n) algorithm.  Better algorithm exists.  To be
     * improved in later labs using a min heap.
     *
     * @return the next event
     */

    private Event getNextEarliestEvent() {
        int nextEventIndex = -1;

        // Scan linearly through the array to find the event
        // with earliest (smallest) timestamp.
        double minTime = Double.MAX_VALUE;
        for (int i = 0; i < this.numOfEvents; i++) {
            if (this.events[i].getTime() < minTime) {
                minTime = this.events[i].getTime();
                nextEventIndex = i;
            }
        }

        // Get the earliest event
        Event e = this.events[nextEventIndex];

        // Replace the earliest event with the last element in
        // the array.
        this.events[nextEventIndex] = this.events[this.numOfEvents - 1];
        this.numOfEvents--;
        return e;
    }



    /**
     * Simulate the event based on event type.
     */
/*
    private void simulateEvent(Event e) {
        switch (e.getEventType()) {
            case Event.CUSTOMER_ARRIVE:
                // A customer has arrived.  Increase the ID and assign it to this customer.
                this.lastCustomerId++;
                System.out.printf("%6.3f %d arrives\n", e.getTime(), this.lastCustomerId);

                // If there is no customer currently being served.  Serve this one.
                int currentCustomer = this.lastCustomerId;
                if (!this.customerBeingServed) {
                    this.serveCustomer( e.getTime(), currentCustomer);
                } else if (!this.customerWaiting) {
                    // If there is a customer currently being served, and noone is waiting, wait.
                    this.makeCustomerWait( e.getTime(), currentCustomer);
                } else {
                    // If there is a customer currently being served, and someone is waiting, the
                    // customer just leaves and go elsewhere (maximum only one waiting customer).
                    this.customerLeaves(e.getTime(), currentCustomer);
                }
                break;
            case Event.CUSTOMER_DONE:
                // A customer is done being served.
                System.out.printf("%6.3f %d done\n", e.getTime(), this.servedCustomerId);
                if (this.customerWaiting) {
                    // Someone is waiting, serve this waiting someone.
                    this.serveWaitingCustomer(e.getTime());
                } else {
                    // Server idle
                    this.customerBeingServed = false;
                }
                break;
            default:
                System.err.printf("Unknown event type %d\n", e.getEventType());
        }
    }

*/
    /**
     * Serve the current customer with given id at given time in the given simulator.
     * Precondition: noone must be served at this time.
     */
    /** to Server
    private void serveCustomer(double time, int id) {
        assert this.customerBeingServed == false;
        this.customerBeingServed = true;
        this.servedCustomerId = id;
        System.out.printf("%6.3f %d served\n", time, id);
        Event e = new Event(time + this.SERVICE_TIME, Event.CUSTOMER_DONE);
        boolean ok = this.scheduleEventInSimulator(e);
        if (!ok) {
            System.err.println("Warning: too many events.  Simulation result will not be correct.");
        }
        this.totalNumOfServedCustomer++;
        assert this.customerBeingServed == true;
    }
*/
    /**
     * Make the current customer with given id wait starting at given time in the given simulator.
     * Precondition: someone is being served but noone is waiting
     * Postcondition: someone is being served, and someone is waiting
     */
/*
    private void makeCustomerWait(double time, int id) {
        assert this.customerBeingServed == true;
        assert this.customerWaiting == false;
        this.waitingCustomerId = id;
        System.out.printf("%6.3f %d waits\n", time, id);
        this.customerWaiting = true;
        this.timeStartedWaiting = time;
        assert this.customerBeingServed == true;
        assert this.customerWaiting == true;
    }
*/
    /**
     * Make the current customer with given id wait, starting at given time in the given simulator.
     * Precondition: someone must be waiting, and noone is being served.
     * Postcondition: noone is waiting, and someone is being served.
     */
/*  
    private void serveWaitingCustomer(double time) {
        assert this.customerBeingServed == false;
        assert this.customerWaiting == true;
        this.customerWaiting = false;
        this.serveCustomer( time, this.waitingCustomerId);
        this.totalWaitingTime += (time - this.timeStartedWaiting);
        assert this.customerBeingServed == true;
        assert this.customerWaiting == false;
    }
*/
    /**
     * Make the current customer with given id leave, at given time in the given simulator.
     * Precondition: someone must be waiting, and someone is being served.
     * Postcondition: someone must be waiting, and someone is being served.
     */
    /** to Customer
    private void customerLeaves(double time, int id) {
        assert this.customerBeingServed == true;
        assert this.customerWaiting == true;
        System.out.printf("%6.3f %d leaves\n", time, id);
        this.totalNumOfLostCustomer++;
        assert this.customerBeingServed == true;
        assert this.customerWaiting == true;
    }
     */
}