package cse419_LabAssgnmnt02;

import java.util.Scanner;

public class Sum_of_three_values {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int[] arr = new int[n];
		int a=0;
		int b=0; 
		int c=0;
		
		for(int i=0; i<n; i++) {
			int values = sc.nextInt();
			arr[i] = values;
		}
		
		first:
		for(int i=0; i<n-2; i++) {
			second:
			for(int j=i+1; j<n-1; j++) {
				for(int k=j+1; k<n; k++) {
					if(arr[i] + arr[j] + arr[k] == x) {
						a = i+1;
						b = j+1;
						c = k+1;
						break first;
					}
				}
			}
		}
		if(a != 0)
		    System.out.println(a + " " + b + " " + c);
		else
			System.out.println("IMPOSSIBLE");
	}
}
