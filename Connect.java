import java.sql.*;

public class Connect
{
        public static void main (String[] args)
        {
                Connection conn = null;

                try
                {
                        String userName = "ambago";
                        String password = "fishandchips";
                        String url = "jdbc:mysql://database2.cs.tamu.edu/ambago-db1";
                        Class.forName ("com.mysql.jdbc.Driver").newInstance ();
                        conn = DriverManager.getConnection (url, userName, password);
                        System.out.println ("Database connection established");
                }
                catch (Exception e)
                {
                        System.err.println ("Cannot connect to database server");
                        System.out.println("Connection Issue: " + e.getMessage());
                }
                finally
                {
                        if (conn != null)
                        {
                                try
                                {
                                        conn.close ();
                                        System.out.println ("Database connection terminated");
                                }
                                catch (Exception e) { /* ignore close errors */ }
                        }
                }
        }
}
