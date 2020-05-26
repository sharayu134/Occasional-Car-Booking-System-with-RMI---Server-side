
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;

public interface BookingInterface extends java.rmi.Remote {
	  
	//public void login() throws  RemoteException, SQLException;
	public String[] albook()throws  RemoteException, SQLException;
	public String[] get(String carid)throws  RemoteException, SQLException;
	public	void del(String carid)throws  RemoteException, SQLException;
	public int create(String carid,String duration,String start,String end)throws  RemoteException, SQLException;
	public int sign(String name, String mail, String s8,String country,String state,String mob)throws  RemoteException, SQLException;
	public int logsubmit(String u,String p)throws  RemoteException, SQLException;

	
}
