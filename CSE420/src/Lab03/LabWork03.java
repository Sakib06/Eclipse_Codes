package Lab03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LabWork03 {
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String expression= "a(bc)*de";
    System.out.print("How many values?");
    int num=sc.nextInt();
    
    for(int count = 0; count<num; count++){
        System.out.print("Enter an example: "); 
        String example = sc.next();
    
        Pattern p = Pattern.compile(expression);
        Matcher m = p.matcher(example);
    
        if (m.find()){
            System.out.println("No match found!"+(count+1));
        }
        else {
            System.out.println("Match Found!"+(count+1));
        }
    }
    }
}
