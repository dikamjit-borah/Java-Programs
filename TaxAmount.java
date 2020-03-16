import java.util.*;
import java.lang.Math;

class TaxCalculator 
{
   
    //Constants for tax groups
    //private static final double RICH = 250000;
    //...
    //Constants for tax rates
    private static final double R_RATE = 0.25;
    private static final double M_RATE = 0.25;
    private static final double A_RATE = 0.25;
    //...   
   int i;
    //Compute total income
    public double computeTotalIncome(double[] incomes)
    {
        double incomesSum = 0.0;
        for( i = 0; i<incomes.length; i++)
        {
            
            incomesSum+=incomes[i];
            
        }
        
        return incomesSum;
        
    }
        //Compute total deduction
    public double computeTotalDeduction(double[] deductions)
    {
        double deductionsSum = 0.0;
        for( i = 0; i<deductions.length; i++)
        {
            
            deductionsSum+=deductions[i];
            
        }
        
        return deductionsSum;
    }
        //Compute taxableIncome income
    public double computeTaxableIncome(double incomesSum, double deductionsSum)
    {
        double taxableIncome ;
        if(incomesSum>deductionsSum)
            taxableIncome = incomesSum - deductionsSum;
        else
            taxableIncome = 0;
        return taxableIncome;
    }
    
        //Compute tax taxGroup
    public char computeTaxGroup(double taxableIncome)
    {
        char taxGroup = 'x';
        if(taxableIncome >=250000)
            taxGroup = 'R';
        else if(taxableIncome >=70000)
            taxGroup = 'M';
        else if(taxableIncome >=30000)
            taxGroup = 'A';
        else
            taxGroup = 'P';
        return taxGroup;
    }
    
        //Compute tax amount
    public double computeTax(double taxableIncome, char taxGroup)
    {
        double taxAmount = 0;
        if(taxGroup == 'R')
            taxAmount = R_RATE*taxableIncome;
        else if(taxGroup == 'M')
            taxAmount = M_RATE*taxableIncome;
        else if(taxGroup == 'A')
            taxAmount = A_RATE*taxableIncome;
        
        return taxAmount;
    }
    
    //Display tax information
    public void display(double incomes, double deductions, double taxableIncome, char taxGroup, double taxAmount)
    {
        System.out.println("\n\t######TAX-INFORMATION######\n");
        System.out.println("\t INCOME\t\t = $" +incomes);
        System.out.println("\t DEDUCTIONS\t = $"+deductions);
        System.out.println("\t TAXABLE INCOME\t = $"+taxableIncome);
        System.out.println("\t TAX GROUP\t = "+taxGroup);
        System.out.println("\t TAX AMOUNT\t = $"+taxAmount);
    }
    
}

public class Main
{
 public static void main(String[] args) 
    {
        Scanner keyboard = new Scanner(System.in);
        //Variables
        
        //...
        //Input income and deduction
        //Repeatedly until 0.0 is entered
        //Input income and deduction
        //if positive, add to incomes[]
        //else if negative, add to deductions[]
        double input;
        List<Double> incomesList = new ArrayList<Double>();
        List<Double> deductionsList = new ArrayList<Double>();
        do
        {
            System.out.println("\nENTER AMOUNT(0 TO EXIT) = $");
            input = keyboard.nextInt();
            if(input>0)
            {
                incomesList.add(input);
            }
            else
            {
                deductionsList.add(input);
            }
            System.out.println("INCOME LIST     = " + incomesList);
            System.out.println("DEDUCTIONS LIST = " + deductionsList);
        }while(input!=0);
        
        int i;
        double incomes[] = new double[incomesList.size()];
        double deductions[] = new double[deductionsList.size()];
 
        for( i = 0; i<incomes.length; i++)
        {
            incomes[i] = incomesList.get(i);
        }

        for( i = 0; i<deductions.length; i++)
        {
            deductions[i] = Math.abs(deductionsList.get(i));
        }
        
        TaxCalculator t = new TaxCalculator();
    
        double totalIncome, totalDeduction, taxableIncome, taxAmount;
        char taxGroup = 'x';
        //Compute total income
        totalIncome = t.computeTotalIncome(incomes);
        //Compute total deduction
        totalDeduction = t.computeTotalDeduction(deductions);
        //Compute taxableIncome income
        taxableIncome = t.computeTaxableIncome(totalIncome, totalDeduction);
        //Compute tax taxGroup
        taxGroup = t.computeTaxGroup(taxableIncome);
        //Compute tax amount
        taxAmount = t.computeTax(taxableIncome, taxGroup);
        //Display tax information
        t.display(totalIncome, totalDeduction,taxableIncome, taxGroup, taxAmount); 
    }
}
