package ProjectName;

import java.util.*;

public class ClassName {

	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Number of Courses completed: ");
		int n = sc.nextInt();
		
		double cgpa=0;
		double credit=0;
		for(int i=0; i<n; i++) {
			credit += 3;
			System.out.println("Enter your GPA");
			double gpa = 3.0 * sc.nextDouble();
			cgpa += gpa;
		}
		
		System.out.println("CGPA is: " + (double)(cgpa/credit));
	}
}
