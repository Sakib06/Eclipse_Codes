package CgpaCalculator;
import java.util.*;

public class CgpaCalculator {
	
	public static void main(String[] args)
	{
		System.out.println("Please enter your gpa of individual courses. After you have entered gpa of all the courses then enter '-1' to see Cgpa.");
		Scanner sc = new Scanner(System.in);
		
		double gpa = 0;
		double cgpa = 0;
		double credits = 0;
		
		for(;;) {
			gpa = sc.nextDouble();
			if(gpa == -1)
				break;
			cgpa += gpa;
			credits += 1;
		}
		
		System.out.println("Total CGPA is: " + (double)(cgpa/credits));
	}

}
