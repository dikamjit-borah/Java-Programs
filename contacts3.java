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

    
    public void mobileNumber_setter(long mobileNumber) throws ContactsNotFoundException
    {
        if(String.valueOf(mobileNumber).length()<10){
            throw new ContactsNotFoundException("Mobile number is not Valid");
            
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
class ContactsNotFoundException extends Exception
{
    ContactsNotFoundException(String s)
    {
        super(s);
    }
}
class ContactService
{

    public static int io_contactsArray = 0;
    public static Contacts[] contactsArray = new Contacts[5];
    void addContacts(Contacts contact)
    {
        contactsArray[io_contactsArray] = contact;
        io_contactsArray++;
    }
    Contacts searchContact(String nam) throws ContactsNotFoundException
    {
        for(int i = 0; i<contactsArray.length; i++)
        {
           
               if(contactsArray[i].name.toLowerCase().equals(nam))
                {
                    return contactsArray[i];
                }
               
       }
       throw new ContactsNotFoundException("Contact not found");
    }
    Contacts searchContact(long mobileNumbe) throws ContactsNotFoundException
    {
        for(int i = 0; i<contactsArray.length; i++)
        {
           
               if(contactsArray[i].mobileNumber == mobileNumbe)
                {
                    return contactsArray[i];
                }
               
       }
       throw new ContactsNotFoundException("Contact not found");
    }
    
  
    void displayContacts(){
        for(int i = 0; i<contactsArray.length; i++)
        {
            System.out.println(contactsArray[i]);
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
		for(int i = 0; i<5; i++)
		{
		    nam = s1.nextLine();
	        mobile = s1.nextLine();
	        mobileLong = Long.parseLong(mobile);
		    email = s1.nextLine();
		    Contacts c = new Contacts(nam, mobileLong, email);
		    c.emailId_setter(email);
		   c.mobileNumber_setter(mobileLong);
		   cc.addContacts(c);
		}
		
		try{
		    System.out.println(cc.searchContact((918494651l)));
		    
		}
		catch(Exception e){System.out.println(e.getMessage());}
		
	}
}
