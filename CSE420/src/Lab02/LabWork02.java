package Lab02;

import java.util.Scanner;
import java.util.LinkedList; 
import java.util.Stack; 

public class LabWork02 {
	
	public static void main (String[]args){
	    
	    Scanner sc = new Scanner(System.in);
	    
	    System.out.println("Enter How Many Numbers?:");
	    int n = sc.nextInt();
	    
	    String s[] = new String[n];
	    int errorCheck = 0;
	    Stack<Integer> webLineCount = new Stack<Integer>(); 
	    Stack<Integer> emailLineCount = new Stack<Integer>(); 
	   
	    for (int i = 0 ; i < n ; i++){
	      System.out.println("Enter Web/Email:");
	      s[i] = sc.next();
	    }  
	    
	    for (int i = 0 ; i < n ; i++){
	      
	      if(s[i].startsWith("www.") && s[i].endsWith(".com")){
	        
	        String[] check = s[i].split("\\." );
	        char[] c = check[1].toCharArray();
	        
	        for(int j = 0 ; j < c.length ; j++){
	          int a = (int) c[j];
	          if((a>=65 && a <=90) || (a>=97 && a<=122) || (a>=48 && a<=57)){
	          }
	          
	          else{
	            errorCheck++;
	          }
	        }
	        
	        if (errorCheck==0){
	          webLineCount.push(i);
	        }
	        else{
	          errorCheck = 0;
	        }
	      }
	      
	      else if(s[i].contains("@") && s[i].endsWith(".com")){
	        emailLineCount.push(i);
	      }
	    }
	    
	    
	    System.out.println("Website Line Numbers:");
	    for(int i = 0 ; i <= webLineCount.size() ; i++){
	      System.out.println(webLineCount.pop()+1);
	    }
	    
	    System.out.println();
	    
	    System.out.println("Email Line Numbers:");
	    for(int i = 0 ; i <= emailLineCount.size() ; i++){
	      System.out.println(emailLineCount.pop()+1);
	    }
	    
	  }

}