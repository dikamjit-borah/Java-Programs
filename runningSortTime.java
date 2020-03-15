import java.util.Random;                            //for random function
import java.util.concurrent.TimeUnit;               // to get system time

public class HelloWorld{
    
    public static void selectionSort(int[] array) 
    {

        int startScan, index, minIndex, minValue;
        for (startScan = 0; startScan < (array.length - 1); startScan++) 
        {
            minIndex = startScan;
            minValue = array[startScan];
            for (index = startScan + 1; index < array.length; index++) 
            {
                if (array[index] < minValue) 
                {
                    minValue = array[index];
                    minIndex = index;
                }
            }
            array[minIndex] = array[startScan];
            array[startScan] = minValue;
        }
    }
    
    


     public static void main(String []args){
         
         
         Random r = new Random();           	//Uses time in milliseconds as the seed.
         int[] array10000 = new int[10000];
         int[] array5000 = new int[5000];
         int[] array500000 = new int[500000];
         
        
        int i;
        
        long startTime = System.nanoTime();     //get the system time in nanoseconds. 
        for (i = 0; i<array10000.length; i++)
        {
            array10000[i] = r.nextInt(10000);      //allocate elements in array with integers between (0-5000)
        }
        long endTime = System.nanoTime();   //get the system time in nanoseconds. 
        long timeElapsed = endTime - startTime;        //substract the two times to get the elapsed time in nanoseconds. 
        
        System.out.println("Time to allocate elements randomly in array of size 10000   :   "  + timeElapsed + " ns = " + timeElapsed/1000000 + " ms");
        
        
        startTime = System.nanoTime();
        for (i = 0; i<array5000.length; i++)
        {
            array5000[i] = r.nextInt(10000);
        }
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        
        System.out.println("Time to allocate elements randomly in array of size 5000   :   "  + timeElapsed + " ns = " + timeElapsed/1000000 + " ms");
        
        
        startTime = System.nanoTime();
        for (i = 0; i<array500000.length; i++)
        {
            array500000[i] = r.nextInt(10000);
        }
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        
        System.out.println("Time to allocate elements randomly in array of size 500000   :   "  + timeElapsed + " ns = " + timeElapsed/1000000 + " ms");
        
        
        
        System.out.println("\nFirst 10 elements of array[10000]   :   ");
        for (i = 0; i<10; i++)
        {
            System.out.println(" " + array10000[i]);
        
        }
        
        startTime = System.nanoTime();
        selectionSort(array10000);
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        
        System.out.println("\nTime taken for Selection Sort in array of size 10000 = " +  timeElapsed + " ns = " + timeElapsed/1000000 + " ms");
        
        
        System.out.println("\nFirst 10 elements of array[10000] after Selection Sort    :   ");
        for (i = 0; i<10; i++)
        {
            System.out.println(" " + array10000[i]);
        
        }
    
        
        System.out.println("\nFirst 10 elements of array[5000]   :   ");
        for (i = 0; i<10; i++)
        {
            System.out.println(" " + array5000[i]);
        
        }
        
        startTime = System.nanoTime();
        selectionSort(array5000);
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        
        System.out.println("\nTime taken for Selection Sort in array of size 5000 = " +  timeElapsed + " ns = " + timeElapsed/1000000 + " ms");
        
        
        System.out.println("\nFirst 10 elements of array[5000] after Selection Sort    :   ");
        for (i = 0; i<10; i++)
        {
            System.out.println(" " + array5000[i]);
        
        }
    
        
        System.out.println("\nFirst 10 elements of array[500000]   :   ");
        for (i = 0; i<10; i++)
        {
            System.out.println(" " + array500000[i]);
        
        }
        
        startTime = System.nanoTime();
        selectionSort(array500000);
        endTime = System.nanoTime();
        timeElapsed = endTime - startTime;
        
        System.out.println("\nTime taken for Selection Sort in array of size 500000 = " +  timeElapsed + " ns = " + timeElapsed/1000000 + " ms");
        
        
        System.out.println("\nFirst 10 elements of array[500000] after Selection Sort    :   ");
        for (i = 0; i<10; i++)
        {
            System.out.println(" " + array500000[i]);
        
        }

        
     }
}