package AndikhaWisanggeniJSleepRJ;

public class Account extends Serializable implements FileParser
{
    public String name;
    public String email;
    public String password;
    
    public Account(int id, String name, String email, String password){
        super(id);
        this.name = name;
        this.email = email;
        
    }
    
    public String toString(){
        return "Name    = " + this.name + "\n" + "Email     = " + this.email + "\n";
    }
    
    public Object write (){
        return null;
    }
    public boolean read(String string){
        return false;
    }
    /*
    public String name;
    public String email;
    public String password;
    public Account(){
    }*/
}
