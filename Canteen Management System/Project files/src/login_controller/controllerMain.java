
package login_controller;

import login_model.loginModel;

public class controllerMain 
{
    
    loginModel modelobj = new loginModel();
    
    public boolean loginCheck(String user,String pass)
    {
        return modelobj.passCheck(user,pass);
    }
    
    public boolean Incomedb (String pay,String change,String total)
    {
        return modelobj.incomeDB(pay,change,total);
    }
    
    public boolean changePassWord (String newUser,String newPass)
    {
        return modelobj.changePass(newUser,newPass);
    }
    
    public boolean AddPUpdate (String PID,String IMAGE,String PNAME,String PTYPE,String PPRICE)
    {
        
        return modelobj.updateTable(PID,IMAGE,PNAME,PTYPE,PPRICE);
    }
    
    public boolean removerow ()
    {
        return modelobj.deletrow();
    }
    
}
