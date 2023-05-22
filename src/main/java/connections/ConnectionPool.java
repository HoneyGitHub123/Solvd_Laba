package connections;

import java.sql.Connection;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConnectionPool {

    private final ConcurrentLinkedQueue<Connection>pool;
    private int maxSize;
    public static volatile ConnectionPool instance;

    public ConnectionPool(int maxSize)
    {
        this.maxSize=maxSize;
        pool=new ConcurrentLinkedQueue<>();
    }

    public static ConnectionPool getInstance(int maxSize)
    {
        if(instance==null){
            synchronized (ConnectionPool.class){
                if(instance==null){
                    instance=new ConnectionPool(maxSize);
                }
            }
        }return instance;
    }

    //returns the object from top of the queue and remove it
    public Connection getConnection(){
        return pool.poll();
    }
public void releaseConnection(Connection connection){
        pool.add(connection);
}
}



