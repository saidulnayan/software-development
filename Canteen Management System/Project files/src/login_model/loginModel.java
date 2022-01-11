
package login_model;
import com.mysql.jdbc.Connection;
import static java.lang.Float.parseFloat;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;

public class loginModel 
{
    
    Connection conn = null;
    Statement statement = null;
    ResultSet resultset= null;
    
    public loginModel()
    {
        
        try
        {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3307/","root","");
            System.out.println("connected");
        }
        catch(Exception e)
        {
            System.out.println("e");
        }
    }
    
    // login connection check
    public boolean passCheck(String user, String pass)
    {
        try
        {
            statement =(Statement)conn.createStatement();
            resultset = statement.executeQuery("SELECT * FROM model.logintable WHERE username='"+user+"' AND password='"+pass+"'");
        
            if(resultset.next())
            {
                return true;
            }
        }
        catch(Exception e)
        {
         System.err.println(e);
        }
        return false;
    }
    
    // product table data collection
    public Object[][] getInfo()
    {
        Object data[][]=new Object[rowCount()][5];
        try
        {
            statement=(Statement)conn.createStatement();
            resultset=statement.executeQuery("SELECT * from model.producttable");
           
            int i=0;
            while(resultset.next())
            {
            
                for(int j=0;j<1;j++)
                {
                    data[i][0]=resultset.getString(1);
                    data[i][1]=resultset.getString(3);
                    data[i][2]=resultset.getString(4);
                    data[i][3]=resultset.getString(5);
                    data[i][4]=resultset.getString(2);
                    
                }
                i++;
            }
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        return data;
    }
    
    public int rowCount()
    {
        int sum=0;
        try
        {
            statement=(Statement)conn.createStatement();
            resultset=statement.executeQuery("SELECT count(product_id) as sum FROM model.producttable");
           
            if(resultset.next())
            {
                sum=resultset.getInt(1);
                
            }
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        return sum;
    }
    
    // data upload to income table
    public boolean incomeDB(String pay, String change, String total)
    {
        try
        {
            statement =(Statement)conn.createStatement();
            statement.execute("insert into model.incometable (received_amount,change_amount,total_amount)values('" + pay + "','" + change + "','" + total + "')");
        
            if(resultset.next())
            {
                return true;
            }
        }
        catch(Exception e)
        {
         System.err.println(e);
        }
        return false;
    }
    
    
    // Income table data collection
    public String[][] getInfoIncome()
    {
        String dataIncome[][]=new String[rowCountI()][5];
        try
        {
            statement=(Statement)conn.createStatement();
            resultset=statement.executeQuery("SELECT * from model.incometable");
           
            int i=0;
            while(resultset.next())
            {
            
                for(int j=0;j<5;j++)
                {
                    dataIncome[i][j]=resultset.getString(j+1);
                }
                i++;
            }
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        return dataIncome;
    }
    
    public int rowCountI()
    {
        int sum=0;
        try
        {
            statement=(Statement)conn.createStatement();
            resultset=statement.executeQuery("SELECT count(order_id) as sum FROM model.incometable");
           
            if(resultset.next())
            {
                sum=resultset.getInt(1);
                
            }
        }
        catch (Exception e)
        {
            System.err.println(e);
        }
        return sum;
    }
    
    // data upload to login table
    public boolean changePass(String newUser, String newPass)
    {
        try
        {
            statement =(Statement)conn.createStatement();
            statement.execute(" UPDATE model.logintable SET username = '"+newUser+"', password = '"+newPass+"' WHERE userId = "+1+";");
        
            if(resultset.next())
            {
                return true;
            }
        }
        catch(Exception e)
        {
         System.err.println(e);
        }
        return false;
    }
    
    // updated data upload to product table
    public boolean updateTable(String PID,String IMAGE, String PNAME, String PTYPE, String PPRICE)
    {
        try
        {
            statement =(Statement)conn.createStatement();
            float nPRICE = parseFloat(PPRICE);
            statement.execute("insert into model.producttable (product_id,product_img,product_name,about,unit_price)values('" + PID + "','" + IMAGE + "','" + PNAME + "','" + PTYPE + "','" + nPRICE + "')");        
            
            if(resultset.next())
            {
                return true;
            }
        }
        catch(Exception e)
        {
         System.err.println(e);
        }
        return false;
    }
    
    // remove previous row data from product table
    public boolean deletrow()
    {
        try
        {
            statement =(Statement)conn.createStatement();
            statement.execute("DELETE FROM model.producttable");        
            
            if(resultset.next())
            {
                return true;
            }
        }
        catch(Exception e)
        {
         System.err.println(e);
        }
        return false;
    }
    
    

   
}
