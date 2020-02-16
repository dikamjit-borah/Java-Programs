import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Source {
	static public List<Integer> getSumOfListElements(List<Integer> first,List<Integer> second){
    //CODE HERE
    
    if(first==null&&second==null) return new ArrayList(); 
        else if(first==null)return second;
        else if(second==null)return first; 
    int firstSize = first.size();
    int secondSize = second.size();
    
    List<Integer> comboList = new ArrayList<Integer>(firstSize);
        
    int i, j ;
    
    if(firstSize>secondSize){ 
            for( i=0;i<secondSize;i++){ 
                int x= first.get(i) + second.get(i); 
                first.set(i,x); 
                
            } 
            return first; 
            
        } 
        else{ 
            for( i=0;i<firstSize;i++)
            { 
                int x= first.get(i) + second.get(i); 
                second.set(i,x); } 
                return second; 
            
        } 
    //return comboList;
	}
	static public List<Integer> strin2lis(String inputString)
	{
	    String[] nums = inputString.split(",");
	    List<Integer> strin2lisList = new ArrayList<Integer>();
	    
	    for(String num:nums)
	       strin2lisList.add(Integer.parseInt(num));
	        
	   return strin2lisList ;
	        
	}


	public static void main(String[] args) {
	    //CODE HERE
	    Scanner s = new Scanner(System.in);
	    String strin = s.nextLine();
	    strin = strin.replaceAll("\\s","");
	    strin = strin.trim();
	    strin2lis(strin);
	    List<Integer> firstList = strin2lis(strin);
	    strin = s.nextLine();
	    strin = strin.replaceAll("\\s","");
	    strin = strin.trim();
	    strin2lis(strin);
	    List<Integer> secondList = strin2lis(strin);
	    
	    List<Integer> sumList = getSumOfListElements(firstList, secondList);
	    System.out.println(sumList);
	}
}
