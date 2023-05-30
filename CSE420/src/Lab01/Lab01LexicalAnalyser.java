package Lab01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Lab01LexicalAnalyser {

    
        
      public static boolean checkkeywords(String c,String keywords[]) {
        for(int i=0;i<keywords.length;i++){
         if(keywords[i].equals(c)){
         return true;
         }
        }
         return false;
    }
      public static boolean checkkeywords2(String c,String keywords[]) {
        for(int i=0;i<keywords.length;i++){
         if(keywords[i].equals(c)){
         return true;
         }
        }
         return false;
    }

    private static boolean checkMath(String c,String MathOp[]) {
    for(int i=0;i<MathOp.length;i++){
         if(MathOp[i].equals(c)){
         return true;
         }
        }
         return false;
    }

    private static boolean checkLogic(String c,String[] LogicalOperators) {
      for(int i=0;i<LogicalOperators.length;i++){
         if(LogicalOperators[i].equals(c)){
         return true;
         }
        }
        return false;
    }
    
      private static boolean checkvarAssign(HashMap<String, String> hmap,String token) {
          
          Iterator hm=hmap.entrySet().iterator();
          while(hm.hasNext())
          {
          Map.Entry mapElement = (Map.Entry)hm.next();
          String c=(String) mapElement.getKey();
          if(c.equals(token)){
          return true;
          }
          }
          return false;
    }
      
    private static boolean checkNum(String token) {
    boolean num=false;
    try{
     Double a= Double.parseDouble(token);
      num =true;
    }
    catch(Exception e){
    num=false;
    }
    return num;
    
    }

       

    
    
    public static void main(String[] args) {
        // TODO code application logic here
        
         String keywords[]={"int","double","long long int","long double","float","string","if"};
         String Keywords2[]={"for","else","if"};
      String MathOp[]={"+","-","*","/","%","=","(",")",";"};
      String LogicalOperators[]={">","<","==",">=","<="};
      
      Scanner sc=new Scanner(System.in);
      String line=sc.nextLine();
      String tokens[]=line.split(" ");
       
      ArrayList<String>MathO=new ArrayList();
         ArrayList<String>Oth=new ArrayList();
      ArrayList<String>LogicO=new ArrayList();
      ArrayList<String>Num=new ArrayList();
      HashMap<String, String> hmap = new HashMap();
      ArrayList<String>other=new ArrayList();
   
      for(int i=0;i<tokens.length;i++){
         
         boolean a=checkkeywords(tokens[i],keywords); 
        
         if(a){
            boolean checkerror=false;                        //checkerror to stop the iteration completely if any mistake found
            for(int j=i+1;j<tokens.length;j++){       
          
            boolean mc=checkMath(tokens[j],MathOp);
           
             if(mc==true&&j==i+1){
             System.out.println("identifier missing");             //check whether it is a matop or logic ope if yes then error                                                      //identifier missing else its a identifier
             checkerror=true;
             break;
             }
             
             
            boolean mc2=checkLogic(tokens[i],LogicalOperators);
             if(mc2==true&&j==i+1){
             System.out.println("identifier missing");
             checkerror=true;
             break;
             }
             if(mc==false&&mc2==false){
             hmap.put(tokens[j],tokens[i]);
             }             
             else{
              i=j-1;
              break;
             }
             }
            if(checkerror){
            break;
            }
            
         }
         
         else{
             boolean mo=checkkeywords2(tokens[i],Keywords2);
          if(mo){
          other.add(tokens[i]);
          }
            boolean mc=checkMath(tokens[i],MathOp);
           if(mc){
           if("(".equals(tokens[i])||")".equals(tokens[i])||";".equals(tokens[i])){
           Oth.add(tokens[i]);
           }  
           else{
           MathO.add(tokens[i]);
           }
           }
            boolean mc2=checkLogic(tokens[i],LogicalOperators);
           if(mc2){
           LogicO.add(tokens[i]);
           }
           boolean mc3=checkNum(tokens[i]);
           if(mc3==true){
           Num.add(tokens[i]);
           }
           if(mc==false&&mc2==false&&mc3==false&&mo==false){
            boolean check=checkvarAssign(hmap,tokens[i]);
            if(check == false){
            System.out.println("VARIABLE = "+tokens[i]+" doesnot have any keyword");
            }
           }
         }

     }
      System.out.println();
      System.out.println("Printing the Symbol Table");
      System.out.println("=========================================================================");
      System.out.println("Keywords with corressponding identifiers = "+hmap);
      
      System.out.println("MatheMatical Operators = "+MathO);
      System.out.println("Logical Operators = "+LogicO);
      System.out.println("Numeric Values are = "+Num);
      System.out.println("Others "+Oth);
    }
      
}
