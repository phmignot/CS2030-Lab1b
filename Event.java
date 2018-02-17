/**
 * Event encapsulations information about the time an event is supposed to occur, and its type.
 */

public class Event {
    protected double time; // The time this event will occur
    protected Customer customer; // The type of event, indicates what should happen when an event occurs.

    
    /**
     * Create a Event
     */

    public Event() {
    }

    public double getTime(){
        return this.time;
    }

    
    /**
     * Should be overwrite by subclasses
     * @param shop
     */
    public Event run(Shop shop){
        return null;
    }
}
