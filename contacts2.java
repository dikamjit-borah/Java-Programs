import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class Contacts extends ContactService
{
    
  String name, emailId;
  long mobileNumber;
  Contacts()
    {
        
        this.mobileNumber = 0;
        this.emailId ="";
        this.name = "";
    }

    Contacts (Contacts contact)
    {
       
        name = contact.name;
        mobileNumber = contact.mobileNumber;
        emailId = contact.emailId;
    }

    Contacts(String name, long mobileNumber, String emailId)
    {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.emailId = emailId;
    } //parametrised constructure

    public String toString()
    {
        return "Name: "+ this.name + "\nMobileNumber: " + this.mobileNumber;
    }

    public long mobileNumber_getter()
    {
        return this.mobileNumber;
    }
    public String emailId_getter()
    {
        
        return this.emailId;
    }

    
    public void mobileNumber_setter(long mobileNumber) throws InvalidMobileNumberException
    {
        if(String.valueOf(mobileNumber).length()<10){
            throw new InvalidMobileNumberException("Mobile number is not Valid");
            
        }
        this.mobileNumber = mobileNumber;
    }

    
    public void emailId_setter(String emailId) throws InvalidEmailIdException
    {
          String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
            if(emailId.matches(regex))
                this.emailId = emailId;
            else
                throw new InvalidEmailIdException("Email Id is not valid");
         
    }

}

class ContactService
{
    public static Contacts[] SIMContacts = new Contacts[3];
    public static Contacts[] phoneContacts= new Contacts[3];
    public static Contacts[] c_all = new Contacts[6];
    
    void sort()
    {
        int k = 0;
        for(int i = 0; i< SIMContacts.length; i++)
        {
            c_all[k] = SIMContacts[i];
            k++;
        }
        for(int j = 0; j<phoneContacts.length; j++)
        {
            c_all[k] = phoneContacts[j];
            k++;
        }
        
        Contacts temp;
        for (int i = 0; i < c_all.length; i++) 
        {
            for (int j = i + 1; j < c_all.length; j++)
            {
                if(c_all[i] == null || c_all[j] == null)
                    break;
                else if (c_all[i].name.compareTo(c_all[j].name)>0) 
                {
                    temp = c_all[i];
                    c_all[i] = c_all[j];
                    c_all[j] = temp;
                }
            }
        }
    }
    void displayContacts(){
        sort();
        for(int i = 0; i<c_all.length; i++)
        {
            System.out.println(c_all[i]);
        }
    }
}

class InvalidMobileNumberException extends Exception
{
    InvalidMobileNumberException(String s)
    {
        super(s);
    }
}

class InvalidEmailIdException extends Exception
{
    InvalidEmailIdException(String s)
    {
        super(s);
    }
}

// Class name should be "Source",
// otherwise solution won't be accepted
public class Source {
	public static void main(String args[] ) throws Exception {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT */
		int index = 0;
		Scanner s1 = new Scanner(System.in);
		
		String nam, email;
		String mobile;
		long mobileLong;
		 ContactService cc = new ContactService();
		for(int i = 0; i<3; i++)
		{
		    nam = s1.nextLine();
	        mobile = s1.nextLine();
	        mobileLong = Long.parseLong(mobile);
		    email = s1.nextLine();
		    Contacts c = new Contacts(nam, mobileLong, email);
		    c.emailId_setter(email);
		   c.mobileNumber_setter(mobileLong);
		    cc.SIMContacts[index++] = c;
		}
		index = 0;
	    for(int i = 0; i<3; i++)
		{
		    nam = s1.nextLine();
	        mobile = s1.nextLine();
	        mobileLong = Long.parseLong(mobile);
		    email = s1.nextLine();
		    Contacts c = new Contacts(nam, mobileLong, email);
		    c.emailId_setter(email);
		   c.mobileNumber_setter(mobileLong);
		    cc.phoneContacts[index++] = c;
		}
	
		cc.displayContacts();
	}
}
