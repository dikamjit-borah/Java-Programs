class Rock
{
    //declare the required variables
    int number_of_samples;
    String desc;
    float weight;
    
    //Constructor for class Rock
    Rock(int number_of_samples, float weight) // takes the no of sample and weight as parameters
    {
        this.number_of_samples = number_of_samples;  //initialize the value of number_of_samples with the one passed in the constructor function
        this.weight = weight;  //initialize the value of weight with the one passed in the constructor function
        this.desc = "UNCLASSIFIED";
    }
    
    public int getNos() // method to get the number_of_samples
    {
        return number_of_samples;  //return the number_of_samples
    
    }

    
    public float getWeight()// method to get the weight
    {
        return weight;
    
    }

    public String getDesc()// method to get the description
    {
        return desc;
    
    }

}

class IngeniousRock extends Rock  //IngeniousRock is a child class of Rock so extends Rock
{
    IngeniousRock(int number_of_samples, float weight)
    {
        super(number_of_samples, weight);   //calls the base class constructor with the parameter values it gets through the object
        this.desc = "Igneous rock is formed through the cooling and solidification of magma or lava.";
    }
}



class SedimentaryRock extends Rock
{
    SedimentaryRock(int number_of_samples, float weight)
    {
        super(number_of_samples, weight);
        this.desc = "Sedimentary rocks are types of rock that are formed by the accumulation or deposition of small particles.";
    }
}


class MetamorphicRock extends Rock
{
    MetamorphicRock(int number_of_samples, float weight)
    {
        super(number_of_samples, weight);
        this.desc = "Metamorphic rocks arise from the transformation of existing rock types, in a process called metamorphism.";
    }
}

public class Main
{
	public static void main(String[] args) {
		
		IngeniousRock ir = new IngeniousRock(5, 66);            //create a object of Class IngeniousRock and call the constructor by passing number_of_samples = 5 and weight = 66
		SedimentaryRock sr = new SedimentaryRock(12, 30);
		MetamorphicRock mr = new MetamorphicRock(8, 100);
	
		System.out.println("\nThe number_of_samples of IngeniousRock is = " + ir.getWeight());
		System.out.println("The weight of IngeniousRock is = " +ir.getNos());
		System.out.println(ir.getDesc());
		
		System.out.println("\nThe number_of_samples of SedimentaryRock is = " + sr.getWeight());
		System.out.println("The weight of SedimentaryRock is = " +sr.getNos());
		System.out.println(sr.getDesc());
		
		System.out.println("\nThe number_of_samples of MetamorphicRock is = " + mr.getWeight());
		System.out.println("The weight of MetamorphicRock is = " +mr.getNos());
		System.out.println(mr.getDesc());
	}
}
