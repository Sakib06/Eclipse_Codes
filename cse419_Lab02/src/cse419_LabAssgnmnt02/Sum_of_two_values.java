package cse419_LabAssgnmnt02;

import java.util.*;
public class Sum_of_two_values {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long x = sc.nextLong();
		long[] arr = new long[n];
		long a=0;
		long b=0;
		
		for(int i=0; i<n; i++) {
			long values = sc.nextLong();
			arr[i] = values;
		}
		label:
		for(int j=0; j<n-1; j++) {
			for(int k=j+1; k<n; k++) {
				if(arr[j] + arr[k] == x) {
					a = j+1;
					b = k+1;
					break label;
				}
			}
		} if(a != 0)
			System.out.println(a + " " + b);
		else 
			System.out.println("IMPOSSIBLE");
	}
}
