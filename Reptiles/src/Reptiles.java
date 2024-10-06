import java.util.Scanner;
public class Reptiles {

	public static void main(String[] args) {

		System.out.print("What is your weight in kg's?");
		Scanner input = new Scanner( System.in );
		double weight = input.nextDouble();
		
		System.out.print("What is your height in metres?");
		double height = input.nextDouble();
		
		double bmi = weight / (height * height);
		
		if (bmi < 18.5)
		{
			String classification = Underweight;
		}
		else 
		{
			if (bmi < 25)
			{
				String classification = Normal;
			}
			else 
			{
				if ( bmi < 29)
				{ 
					String classification = Overweight;
				}
				else 
				{
					String classification = Obese;
				}
			}
		}
			
		System.out.print("Your BMI is " + bmi + "which is classified as " + classification);
		
		

	}

}
