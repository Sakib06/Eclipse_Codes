package Level1Problems;

import java.io.File;
import java.util.Scanner;
public class BankerAlgorithm {
 public static void main(String[] args) throws Exception {
    File file = new File("E:\\Eclipse\\CSE321\\src\\labTask.txt");
        
        Scanner in = new Scanner(file);
        int process = in.nextInt();
        int resource = in.nextInt();
        int max[][] = new int[process][resource];
        for (int i = 0; i < process; i++) {
            for (int j = 0; j < resource; j++) {
                max[i][j] = in.nextInt();
            }
        }

        int locate[][] = new int[process][resource];
        for (int i = 0; i < process; i++) {
            for (int j = 0; j < resource; j++) {
                locate[i][j] = in.nextInt();
            }
        }

        int available[] = new int[resource];
        for (int i = 0; i < resource; i++) {
            available[i] = in.nextInt();
        }

        int required[][] = new int[process][resource];
        for (int i = 0; i < process; i++) {
            for (int j = 0; j < resource; j++) {
                required[i][j] = max[i][j] - locate[i][j];
            }
        }

        int[][] placement = new int[process][resource];
        System.out.println("Need matrix :");
        for (int i = 0; i < process; i++) {
            for (int j = 0; j < resource; j++) {
                System.out.print(required[i][j] + "  ");
            }
            System.out.println();
        }

        if (safeCheck(process, resource, available, locate, required, placement)) {
            System.out.println("Safe sequence is :");
            for (int i = 0; i < process; i++) {
                System.out.print((char) ('A' + safety[i]) + " ");
            }
            System.out.println();
            System.out.println("Change in available resource matrix :");
            for (int i = 0; i < process; i++) {
                for (int j = 0; j < resource; j++) {
                    System.out.print(placement[i][j] + "  ");
                }
                System.out.println();
            }
        } else {
            System.out.println("System is unsafe");
        }

    }
    static int process, resource, safety[] = new int[process + 10];

    public static boolean safeCheck(int process, int resource, int available[], int allocate[][], int required[][], int afterChange[][]) {
        boolean safeFlag[] = new boolean[process];
        for (int i = 0; i < process; i++) {
            safeFlag[i] = false;
        }

        int check1 = 0;
        int check2 = 0;
        do {
            for (int i = 0; i < process; i++) {
                boolean flag = true;
                if (safeFlag[i] == false) {
                    for (int j = 0; j < resource; j++) {
                        if (available[j] < required[i][j]) {
                            flag = false;
                        }
                    }
                    if (flag == true) {
                        for (int j = 0; j < resource; j++) {
                            available[j] = available[j] + allocate[i][j];
                            afterChange[check1][j] = available[j];

                        }
                        safety[check1] = i;
                        check1++;
                        safeFlag[i] = true;
                    }
                }
            }
            check2++;
        }
   while (check1 < process && check2 < process);
        if (check1 > process) {
            return false;
        } else {
            return true;
        }
    }
}
