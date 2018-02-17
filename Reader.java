import java.io.FileNotFoundException;
import java.util.Scanner;

public class Reader {

    public Reader(String[] args) {
        Scanner data = createScanner(args);
        if (data == null) {
            return;
        }
        readInput(data);
    }

    /**
     * Adds a new event arrival to the simulator from a given time.
     * @param time
     * @return true, if the arrival has been accepted
     */

    private boolean generateArrival(double time){ 
        //Event arrival = new ArrivalEvent(time, );
        //return simulator.scheduleEventInSimulator(arrival);
        return false;
    }

    /**
    private Server generateServer(Customer customer){
        
    }
    
    private genrateDone(Customer customer){
        
    }
     */

    // The input file consists of a sequence of arrival timestamp
    // (not necessary in order)
    // .

    /**
     * Generates the schedule of event from data 
     * @param data
     */
    public void readInput(Scanner data){
        while (data.hasNextDouble()) {
            boolean accepted = false;//generateArrival(data.nextDouble(), Event.CUSTOMER_ARRIVE);
            if (!accepted) {
                System.err.printf("warning: too many events.  Skipping the rest.");
                data.close();
                break;
            }
        }
        data.close();
    }
    
    
    /**
     * Create and return a scanner.  If a command line arguement is given,
     * treat the argument as a file, and open a scanner on the file.  Else,
     * open a scanner that reads from standard input.
     *
     * @return a scanner or `null` if a filename is given but cannot be open.
     */
    public static Scanner createScanner(String[] args) {
        Scanner s = null;
        try {
            // Read from stdin if no filename is given, otherwise
            // read from the given file.
            if (args.length == 0) {
                s = new Scanner(System.in);
            } else {
                java.io.FileReader f = new java.io.FileReader(args[0]);
                s = new Scanner(f);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Unable to open file " + args[0] + " " + ex + "\n");
        } finally {
            return s;
        }
    }
}
