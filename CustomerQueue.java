import java.util.AbstractQueue;
import java.util.concurrent.ArrayBlockingQueue;

public class CustomerQueue {
    public static final int CAPACITY_QUEUE = 1;
    private final AbstractQueue<Customer> customerQueue;
    
    public CustomerQueue(){
        this.customerQueue = new ArrayBlockingQueue<>(CAPACITY_QUEUE);
    }
    
    public boolean isEmpty(){
        return customerQueue.isEmpty();
    }
    
    public void add(Customer customer){
        customerQueue.add(customer);
    }
    
    public Customer remove() {
        return customerQueue.remove();
    }
    
}
