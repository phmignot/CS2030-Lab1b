public class Server {
    private final int id;
    private int status;
    
    public static final int IDLE = 0;
    public static final int OCCUPIED = 1;

    public Server(int serveurId) {
        this.status = IDLE;
        this.id = serveurId;
    }

    public int getId() {
        return id;
    }

    public int getStatus() {
        return status;
    }
    
    public void setIdle(){
        status = IDLE;
    }
    
    public void setOccupied(){
        status = OCCUPIED;
    }
}
