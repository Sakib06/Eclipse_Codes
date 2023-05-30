package cse419_LabAssgnmnt02;

import java.util.Scanner;
public class Distinct_Numbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n];
		int count = 0;
		int equal = 0;
		
		for(int i=0; i<n; i++) {
			equal = 0;
			int nums = sc.nextInt();
			arr[i] = nums;
			if(i == 0) {
				count++;
			}
			else{
				for(int j=i-1; j>=0; j--) {
					if(arr[i] == arr[j]) {
						equal++;
						break;
					}
				}
				if(equal==0)
					count++;
				else count = count;
			}
		}
		System.out.println(count);
	}
}
