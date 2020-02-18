/*
encrypt(String message): String     
The input message String to the method should be encrypted as per the below rules. encrypted message should be returned back.
message should be converted to lower case
a and e should be replaced with each other
o and u should be replaced with each other
i should be replaced with ! and space should be replaced with +
In case of Consonant, It should be replaced with next immediate consonant
In case of digit, it should be replaced with next digit
z should be replaced with b and 0 with 1
Assume that the input string is alphanumeric without special characters
*/


import java.util.*;
public class Source
{
    public static String encrypt(String message)
    {
        char c = 'a';
        message = message.toLowerCase();
        StringBuilder string = new StringBuilder(message);
    System.out.println(message);
        for (int i = 0 ; i<message.length()-1; i++)
        {
            c = message.charAt(i);
            //System.out.println(c);
            if(c=='a')
                string.setCharAt(i, 'e');
            else if(c=='e')
                 string.setCharAt(i, 'a');
             else if(c=='o')
                 string.setCharAt(i, 'u');
            else if(c=='u')
                 string.setCharAt(i, 'o');
            else if(c=='i')
                 string.setCharAt(i, '!');
            else if(c==' ')
                 string.setCharAt(i, '+');
            else if(c=='z')
                 string.setCharAt(i, 'b');
            else if(c=='0')
                 string.setCharAt(i, '1');
            else if(Character.isDigit(c))
            {
                string.setCharAt(i, ((char)((int)c + 1 )));
            }
            
            else
            {
            		if((message.charAt(i + 1) == 'a')||(message.charAt(i + 1) == 'e')||(message.charAt(i + 1) == 'i')||(message.charAt(i + 1) == 'o')||(message.charAt(i + 1) == 'u'))
            		{
            			 string.setCharAt(i, (char)((int)c + 1));
            		}
            		else
            		{
                        string.setCharAt(i, (char)((int)c + 2));
            		}
            }
          
        }
        System.out.println(string.toString());
        return string.toString();
    }
    
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        String encrypted = encrypt(s.nextLine());
    }
}