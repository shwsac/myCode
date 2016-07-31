package arrays;

import java.util.Stack;

public class ReversePolishNotation {
    //Time limit exceeded
    // public int evalRPN(String[] tokens) {
    //     if(tokens.length == 0) {
    //         return 0;
    //     }
    //     if(tokens.length == 1) {
    //         return Integer.parseInt(tokens[0]);
    //     }
    //     HashSet<String> hset = new HashSet<>();
    //     hset.add("+");
    //     hset.add("-");
    //     hset.add("/");
    //     hset.add("*");
        
    //     int result = 0;
    //     Stack<Integer> stk = new Stack<Integer>();
    //     for(String str: tokens) {
    //         if(hset.contains(str)) {
    //              int a = Integer.valueOf(stk.pop());
    //              int b = Integer.valueOf(stk.pop());
    //              int c = 0;
    //              switch(str.charAt(0)) {
    //                  case '+' : c = a+b;
    //                               break;
    //                  case '*' : c = a*b;
    //                               break;
    //                  case '-' : c = b-a;
    //                               break;
    //                  case '/' :if(a==0) {
    //                               c=0;
    //                               } else {
    //                               c = b/a;
    //                               }
    //                               break;
    //                  default: break;
    //              }
    //              result = c;
    //              stk.push(c);
    //         } else {
    //             stk.push(Integer.valueOf(str));
    //         }
    //         System.out.println(stk.peek());
    //     }
    //     return result;
    // }
      public int evalRPN(String[] tokens) {
 
        int returnValue = 0;
 
        String operators = "+-*/";
 
        Stack<String> stack = new Stack<String>();
 
        for(String t : tokens){
            if(!operators.contains(t)){
                stack.push(t);
            }else{
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                int index = operators.indexOf(t);
                switch(index){
                    case 0:
                        stack.push(String.valueOf(a+b));
                        break;
                    case 1:
                        stack.push(String.valueOf(b-a));
                        break;
                    case 2:
                        stack.push(String.valueOf(a*b));
                        break;
                    case 3:
                        stack.push(String.valueOf(b/a));
                        break;
                }
            }
        }
 
        returnValue = Integer.valueOf(stack.pop());
 
        return returnValue;
 
    }

}
