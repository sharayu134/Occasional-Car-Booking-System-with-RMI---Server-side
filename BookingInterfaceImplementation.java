import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BookingInterfaceImplementation extends UnicastRemoteObject implements BookingInterface {
	public  Connection con=null;
	Statement statement=null;
	
	  public BookingInterfaceImplementation() 
		        throws java.rmi.RemoteException { 
		        super(); 
		    /*    String url = "jdbc:mysql://localhost:3306/sonoo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";
		    	String username = "root";
		    	String password = "kvuc";
		    try{  
		    Class.forName("com.mysql.cj.jdbc.Driver");  
		     con=DriverManager.getConnection(url, username, password);  
		    //here sonoo is database name, root is username and password  
		    }catch(Exception e){ System.out.println(e);}  
		    */
		    } 
	  public int logsubmit(String u,String p)
		{
			  try
			   {
				  
				   Class.forName("com.mysql.cj.jdbc.Driver");  
				   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "kvuc");
				   String query = "SELECT * FROM login";
				   Statement st = con.createStatement();
				   ResultSet rs=null;
				     rs = st.executeQuery(query);
				    String name="",pass="";
				    while (rs.next())
				      {
				        
				        name = rs.getString("user");
				         pass = rs.getString("pass");
				         if (u.equalsIgnoreCase(name) && p.equalsIgnoreCase(pass)) 
					       {
					           
					           return 5;
					
					       } 
					       else 
					       {
					    	   if(!(rs.isLast()))
					    	   {
					    		   
					    	   }
					    	   else
					    	   {
					    		   return 4;
					    	   }
					       }
				        
				        
			
				        
				      }
				      st.close();
				     


			   }
			   catch(Exception ee)
			   {
				  
			   }
			  
		   return 0;  
			   
		}
		public int sign(String name, String mail, String s8,String country,String state,String mob)
		{
			try  
	        {  
				int x=0;
	            Class.forName("com.mysql.cj.jdbc.Driver");  
	            //String sql="insert into reg values(?,?,?,?,?,?)";
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "kvuc");  
	            PreparedStatement ps = con.prepareStatement("insert into reg values(?,?,?,?,?,?)");  
	            ps.setString(1, name);  
	            ps.setString(2, mail);  
	            ps.setString(3, s8);  
	            ps.setString(4, country);  
	            ps.setString(5, state);  
	            ps.setString(6, mob);  
	             ps.executeUpdate(); 
	            x++;  
	            if (x > 0)   
	            {  
	            	
	                
	                PreparedStatement ps1 = con.prepareStatement("insert into login values(?,?)");  
	                ps1.setString(1, name); 
	                ps1.setString(2, s8);
	                ps1.executeUpdate(); 
	                return 3;
	            }  
	            
	        }  
	        catch (Exception ex)   
	        {  
	            System.out.println(ex);  
	        }  
			return 1;

		}
		public int create(String carid,String duration,String start,String end)
		{
			int x=0;
			try  
	        {  
	            Class.forName("com.mysql.cj.jdbc.Driver");  
	            //String sql="insert into reg values(?,?,?,?,?,?)";
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "kvuc");  
	            PreparedStatement ps = con.prepareStatement("insert into createbooking values(?,?,?,?)");  
	            ps.setString(1, carid);  
	            ps.setString(2, duration);  
	            ps.setString(3, start);  
	            ps.setString(4, end);  
	            
	             ps.executeUpdate(); 
	            x++;  
	            if (x > 0)   
	            {  
	                return 7;                
	            }  
	            
	        }  
	        catch (Exception ex)   
	        {  
	            System.out.println(ex);  
	        }  
			return 1;
		}
		public void del(String carid)
		{
			try  
	        {  
	            Class.forName("com.mysql.cj.jdbc.Driver");  
	            System.out.println("testing");
	            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "kvuc");  
	            String query = "delete from createbooking where carid = ?";
	            PreparedStatement preparedStmt = con.prepareStatement(query);
	            preparedStmt.setString(1, carid);
	            preparedStmt.execute();
	          
	            
	            
	        }
			 catch(Exception e)
			 {
				 
			 }
		}
		public String[] get(String carid)
		{	
			
			 String ag[]= new String[4];
			try
			{
			 String id="";
			 String duration="";
			 String std="";
			 String ed="";
			 Class.forName("com.mysql.cj.jdbc.Driver");  
			   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sonoo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "kvuc");
			   String query = "SELECT * FROM createbooking where carid="+carid;
			   Statement st = con.createStatement();
			   ResultSet rs=null;
			     rs = st.executeQuery(query);
			    
			 		 while (rs.next())
					 {
		
			 			  ag[0]=rs.getString(1);
		
			             ag[1]= rs.getString(2);
		
			              ag[2]=rs.getString(3);
		
			              ag[3]=rs.getString(4);
					 }
			}
			catch(Exception ae)
			{
				
			}
			 return ag;     
			 
		}
		public String[] albook()
		{
			   String arr[]= new String[3];
			 try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/sonoo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "kvuc");
		            PreparedStatement pstm = con.prepareStatement("SELECT * FROM cars");
		            ResultSet Rs = pstm.executeQuery();
		         
		            while(Rs.next()){
		            	arr[0]=Integer.toString(Rs.getInt(1));
		            	
		            	arr[1]=Rs.getString(2);
		            	arr[2]=Rs.getString(3);
		               // model.addRow(new Object[]{Rs.getInt(1),Rs.getString(2),Rs.getString(3)});
		            }
		        } catch (Exception e) {
		            System.out.println(e.getMessage());
		        }
			   return arr;
		}
		
		
	
      
		
}