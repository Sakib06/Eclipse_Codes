package LabTasks;

import java.util.*;
public class RoundRobin 
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of processes:");
        int n=sc.nextInt();
        int p[]=new int[n];
        int bt[]=new int[n];
        int wt[]=new int[n];
        int tat[]=new int[n];
        int fbt[]=new int[n];
        System.out.println("Enter the quantum time:");
        int qt=sc.nextInt();
        System.out.println("Enter the burst times:");
        int gc=0,i,j,tbt=0;
        for(i=0;i<n;i++)
        {
          p[i]=i+1;
          bt[i]=sc.nextInt(); 
          fbt[i]=bt[i];
          tbt+=bt[i];
        }
        while(tbt>0)
        {
            for (i = 0; i < n; i++) 
            {
                if (bt[i] > qt) {
                    bt[i] -= qt;tbt-=qt;
                    System.out.println("p"+p[i]+":"+gc+"-"+(gc+qt));gc+=qt;
                    for (j = 0; j < n; j++) {
                        if ((j != i) && (bt[j] != 0)) wt[j] += qt;
                    }
                }
                else 
                {
                    if(bt[i]>0){
                        System.out.println("p"+p[i]+":"+gc+"-"+(gc+bt[i]));gc+=bt[i];}
                        for (j = 0; j < n; j++) {
                            if ((j != i) && (bt[j] != 0)) wt[j] += bt[i];
                        }
                    tbt-=bt[i];
                    bt[i] = 0;
                }
            }
        }
        tat[i] = wt[i] + fbt[i];
        System.out.println("\n\nprocess\t\tBT\tWT\tTAT");
        for (i = 0; i < n; i++) {
            System.out.println("process" + (i + 1) + "\t" + fbt[i] + "\t" + wt[i] + "\t" + tat[i]);
        }
    }
}
