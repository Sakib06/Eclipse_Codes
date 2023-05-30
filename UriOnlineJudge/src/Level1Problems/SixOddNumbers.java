package Level1Problems;

import java.util.Scanner;

public class SixOddNumbers {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Input a positive integer number:");
		int input = sc.nextInt();
		int n = input;
		
		if(input%2==0) {
			n = input+1;
			for(int i=0; i<6; i++) {
				System.out.println(n);
				n = n+2;
			}
			
		}
		else {
			for(int i=0; i<6; i++) {
				System.out.println(n);
				n = n+2;
			}
		}
		
	}

}
