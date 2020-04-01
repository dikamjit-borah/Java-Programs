
import java.util.*;
public class Main
{
  public static void ColoumnLargest (int coloumns, int[][]array)
  {

    for (int i = 0; i < coloumns; i++)
      {
	int max = array[0][i];
	for (int j = 1; j < array[i].length; j++)
	  if (array[j][i] > max)
	      max = array[j][i];

	  System.out.println ("Largest of " + i + " coloumn is " + max);
      }
  }

  public static void RowLargest (int rows, int[][]array)
  {
    int i = 0;


    int max = 0;

    while (i < rows)
      {
	for (int j = 0; j < array[i].length; j++)
	  {
	    if (array[i][j] > max)
	      {
		max = array[i][j];
	      }
	  }

	System.out.println ("Largest of " + i + " row is " + max);
	max = 0;
	i++;

      }
  }

  public static void LargestInMatrix (int rows, int coloumns, int[][]array)
  {
    int i, j;


    int max = array[0][0];

    for (i = 0; i < rows; i++)
      {

	for (j = 0; j < coloumns; j++)
	  {
	    if (array[i][j] > max)
	      max = array[i][j];
	  }
      }
    System.out.print ("Largest element in the matrix is  :   " + max);
  }

  // Driver code 
  public static void main (String[]args)
  {
    int[][] array = new int[10][10];
    Scanner s = new Scanner (System.in);
    int rows = 3, coloumns = 5;
    int i, j;
    System.out.print ("Enter the element for the matrix   :  \n");
    for (i = 0; i < rows; i++)
      {

	for (j = 0; j < coloumns; j++)
	  {
	    array[i][j] = s.nextInt ();
	  }
      }


    System.out.print ("The matrix is :   \n");
    for (i = 0; i < rows; i++)
      {

	for (j = 0; j < coloumns; j++)
	  {
	    System.out.print (array[i][j] + " ");
	  }
	System.out.println ("\n");
      }
    // Calling the functions
    ColoumnLargest (coloumns, array);
    RowLargest (rows, array);
    LargestInMatrix (rows, coloumns, array);
  }
}
