import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
class Contacts
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
		Scanner s1 = new Scanner(System.in);
		String nam, email;
		String mobile;
		long mobileLong;
		nam = s1.nextLine();
	    mobile = s1.nextLine();
	    mobileLong = Long.parseLong(mobile);
		email = s1.nextLine();
		Contacts c = new Contacts(nam, mobileLong, email);
		c.emailId_setter(email);
		c.mobileNumber_setter(mobileLong);
		System.out.println(c);
	}
}
