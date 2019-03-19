
package comertermproject;
import java.lang.*;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.*;
       
/**
 *
 * @author Nathan Comer
 */
public class ComerTermProject {

		
    public static void main(String[] args){
        
        
        ComerTermProject N = new ComerTermProject();
        System.out.println("Step 1");
        while(Interface.done()==false){
        System.out.println("Step 2");
        }
        N.initializeSandQ();
        System.out.println("Step 3");
        N.type(Interface.getEquation());
        System.out.println("Step 4");
        ComerTermProject.Interface.addDialogue();
        ComerTermProject.Interface.getValues();
        N.solve();
       
        
    }
    
    static GUI Interface = new GUI();
    public static Queue q;
    public static Stack S;
    public static Stack n;
    public static String Constants="";
    public String postfix = "";
    public void initializeSandQ(){
        q = new Queue(Interface.equationLength());
        S = new Stack(Interface.equationLength());
        n = new Stack(Interface.equationLength());
    }
        
    
    
     /**
      * 
      * @param string to resolve
      * @param k starting position of the constant
      * @return 
      */   
     static String extractIntString(String sin, int k){
         String s = new String();
         while(sin.charAt(k)>='0'
             && sin.charAt(k)<='9'){
             s+=sin.charAt(k);
             k++;
             if(k>=sin.length()){
                 return s;
             }
         }
         
         return s;
     }   
     
     /**
      * To do:  save the tokens when discovered
      * @param sin Expression
      * @return 
      */
     
     
     public String type(String sin){
        String s= new String();
        int c = 0;
        // Case 0: if first char is a negative sign
        if (sin.charAt(c)=='-'){
            c++;
            String num = "-"+ extractIntString(sin, c);
            c+=num.length();
            q.enqueue(num);

        }
        // Loop for rest of string
        for (; c<sin.length();c++){
            System.out.println(c);
            char nextChar=sin.charAt(c);
            //Case 1: if start of variable name
            //      TODO:  Make this handle variables of length > 1
            if(sin.charAt(c)>='a'
                    && sin.charAt(c)<='z'){
                s="";
                s+=sin.charAt(c);
                for(;(c+1)<sin.length()&&sin.charAt(c+1)>='a'
                    && sin.charAt(c+1)<='z';c++){
                s+=sin.charAt(c++);
                }
                q.enqueue(s);
                q.variables(s);
                postfix+=s;
            }
            //Case 2: if start of a positive constant
            //      TODO:  Make this handle variables of length > 1
            else if(sin.charAt(c)>='0'
                    && sin.charAt(c)<='9'){
                String num = extractIntString(sin, c);
                c+=(num.length()-1);
                q.enqueue(num);
                Constants+=" "+num;
                
            }
            //Case 3: if start of operator not negative or subtraction
            else if((sin.charAt(c)=='+')||(sin.charAt(c)=='*')||(sin.charAt(c)=='/')||(sin.charAt(c)=='%')){
                if(S.next==0){
                    S.push(sin.charAt(c));
                }else if((checkPrecedence(sin.charAt(c))<(checkPrecedence(S.peek())))){
                    while((S.next>0&&checkPrecedence(sin.charAt(c))<(checkPrecedence(S.peek())))){
                    S.pop();
                    }
                }else{
                    S.push(sin.charAt(c));
                }
                
            }
            //Case 4: if start of operator  negative or subtraction
            //      TODO:  Make this handle variables of length > 1
            else if(sin.charAt(c)=='-'){
                //Case 4.1: Handle subtraction
                S.push(sin.charAt(c));
                //Case 4.2: Handle negative constant
            }
            //Case 5: Handle parenthesis.
            else if((nextChar=='(')||(nextChar==')')){
                S.push(nextChar);
            }
        }
        while(S.next!=0){
            S.pop();
        }
        return s;
    }
     
    public int checkPrecedence(char n) {
        int precedence = 0;
        if(n=='+'|| n=='-') {
             precedence = 2;
        }
        else if(n=='*'|| n=='/') {
             precedence = 4;
        }
        else if(n=='(') {
             precedence = 0;
        }
    return precedence;
        }
    
    
    public void solve(){
        double number1=0;
        double number2=0;
        double result=0;
        String i = "";
        for(int j = 0; j < q.array.length; j++){
            i+=q.array[j];
        }
        for(int b = 0; b<i.length();b++){
            char ch = i.charAt(b);
                for(int w = 0; q.storeVar[0][w]!=null;w++){
                    System.out.println(q.storeVar[0][w]);
                        if(ch==(q.storeVar[0][w].charAt(0))){
                            System.out.println("ch value"+ch);
                System.out.println(q.storeVar[0][0]);
                System.out.println(q.storeVar[1][0]);
                            
                            for(int h =0;h<q.storeVar[1][w].length();h++){
                            
                            System.out.println("SSSSSSSS: "+ch);
                                ch=q.storeVar[1][w].charAt(0);
                                if(q.storeVar[1][w].length()>1){
                                ch+=q.storeVar[1][w].charAt(h+1);
                                }
                                System.out.println("FFFFFFFF: "+ch);
                            
                        }        
                    }
                }
                
                if(ch>='0'&&ch<='9'){
                    Double input = (double)ch-'0';
                    n.pushDouble(input);System.out.println("Push CH:"+input);
                    System.out.println("pushed");
                }else{
                    number1=(n.popDouble());System.out.println("NUMBER111:"+number1);
                    number2=(n.popDouble());System.out.println("NUMBER2L"+number2);
                    switch(ch){
                        case '+':result=number1+number2;System.out.println("added"+number1+" "+number2+" "+result);break;
                        case '-':result=number2-number1;break;
                        case '*':result=number1*number2;break;
                        case '/':result=number2/number1;break;
                        case '(':n.nextDouble++;solve();
                        case ')':n.nextDouble--;solve();
                        default:result=0;
                    }
                    n.pushDouble(result);
                }
            
        }
            System.out.println("Result:" +result);
        }
//                String token = q.array[j];
//            if (!"+".equals(token) && !"*".equals(token) && !"-".equals(token) && !"/".equals(token)) {
//                s.push(Integer.parseInt(token)); 
//
//        }   else {
//                String Operator = q.array[j];
//                number1 = q.dequeue();
//                number2 = q.dequeue();
//                if (Operator.equals("/")){
//                    result = number1 / number2;}
//                else if(Operator.equals("*")){
//                    result = number1 * number2;}
//                else if(Operator.equals("+")){
//                    result = number1 + number2;}
//                else if(Operator.equals("-")){
//                    result = number1 - number2;}
//                else System.out.println("Illeagal symbol");
//    }
//    }
        
}

