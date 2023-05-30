package Lab01;

import java.io.*;
import java.util.*;


public class Test {
  public static void main(String[] args) throws FileNotFoundException  {
    
    ArrayList<String> keylist = new ArrayList<String>();
    Scanner keys = new Scanner(new FileReader("keyword.txt"));
    while(keys.hasNext()){
      keylist.add(keys.next());
    }
    
    
    Scanner sc = new Scanner(new FileReader("input.txt"));
    
    ArrayList<String> keyword = new ArrayList<String>();
    ArrayList<String> identifiers = new ArrayList<String>();
    ArrayList<String> operator = new ArrayList<String>();
    ArrayList<String> logical = new ArrayList<String>();
    ArrayList<String> bool = new ArrayList<String>();
    ArrayList<String> number = new ArrayList<String>();
    ArrayList<String> others = new ArrayList<String>();
    
    while(sc.hasNext()) {
      String temp = sc.next();
      if(temp.equals("==")||temp.equals(">")||temp.equals(">=")||temp.equals("<")||temp.equals("<=")||temp.equals("!=")) {
        if(!logical.contains(temp))
          logical.add(temp);  
      }
      
      else if(temp.equals("true")||temp.equals("false")) {
        if(!bool.contains(temp))
          bool.add(temp);
      }
      else if(keylist.contains(temp)) {
        if(!keyword.contains(temp))
          keyword.add(temp);
      }
      else if(temp.equals("+")||temp.equals("-")||temp.equals("=")) {
        if(!operator.contains(temp))
          operator.add(temp);
      }
      
      else if(((int)temp.charAt(0)>=65&&(int)temp.charAt(0)<=90)||((int)temp.charAt(0)>=97&&(int)temp.charAt(0)<=122)) {
        boolean black=false;
        for(int i=0;i<temp.length();i++){
          if((((int)temp.charAt(i)>=65 && (int)temp.charAt(i)<=90)||((int)temp.charAt(i)>=97 && (int)temp.charAt(i)<=122)) ==false){
            black=true;
            break;
          }
        }
        if(!identifiers.contains(temp) && black==false)
          identifiers.add(temp);
        
      }
      else if((int)temp.charAt(0)>=48 && (int)temp.charAt(0)<=57) {
        boolean black=false;
        int count=0;
        for(int i=0;i<temp.length();i++){
          if((((int)temp.charAt(i)>=48 && (int)temp.charAt(i)<=57)==false) && temp.charAt(i)!='.'){
            if(temp.charAt(i)=='.'){
              count++;
            }
            black=true;
            break;
          }
        }
        if(!identifiers.contains(temp) && black==false && count<=1)
          number.add(temp);
      }
      else {
        if(!others.contains(temp))
          others.add(temp);
      }
      
    }
    
    System.out.print("Keywords : ");
    for(int i=0;i<keyword.size();i++) {
      if(i==keyword.size()-1){
        System.out.print(keyword.get(i));
      }
      else{
        System.out.print(keyword.get(i)+", ");
      }
    }
    
    System.out.println();
    
    System.out.print("Identifiers : ");
    for(int i=0;i<identifiers.size();i++) {
      if(i==identifiers.size()-1){
        System.out.print(identifiers.get(i));
      }
      else{
        System.out.print(identifiers.get(i)+", ");
      }
    }
    
    System.out.println();    
    System.out.print("Math Operators : ");
    for(int i=0;i<operator.size();i++) {
      if(i==operator.size()-1){
        System.out.print(operator.get(i));
      }
      else{
        System.out.print(operator.get(i)+", ");
      }
    }
    
    System.out.println();        
    System.out.print("Logical Operators : ");
    for(int i=0;i<logical.size();i++) {
      if(i==(logical.size())-1){
        System.out.print(logical.get(i)+" ");
      }
      else{
        System.out.print(logical.get(i)+", ");
      }
    }
    
    System.out.println();
    System.out.print("Numerical Values : ");
    for(int i=0;i<number.size();i++) {
      if(i==(number.size())-1){
        System.out.print(number.get(i)+" ");
      }
      else{
        System.out.print(number.get(i)+", ");
      }
    }
    
    System.out.println();
    System.out.print("Others : ");
    for(int i=0;i<others.size();i++) {
      System.out.print(others.get(i)+" ");
    }
  }
  
}
