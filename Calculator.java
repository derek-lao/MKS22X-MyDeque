public class Calculator{
    /*Evaluate a postfix expression stored in s.
     *Assume valid postfix notation, separated by spaces.
     */
    public static double eval(String s){
      MyDeque<Double> deque = new MyDeque<Double>();
      String[] tokenList = s.split(" ");
      for(int i = 0 ; i < tokenList.length ; i ++)
      {// may have to check for NumberFormatException
        if(!isOperand(tokenList[i]))
        {
          deque.addLast(Double.parseDouble(tokenList[i]));
        }
        if(i > 1 && isOperand(tokenList[i]))
        {
          String operand = tokenList[i];
          Double second = deque.removeLast();
          Double first = deque.removeLast();
          Double result = 0.0;
          if(operand.equals("+"))
          result = first + second;
          else if(operand.equals("-"))
          result = first - second;
          else if(operand.equals("*"))
          result = first * second;
          else if(operand.equals("/"))
          result = first / second;
          else if(operand.equals("%"))
          {
            result = first % second;
          }

          deque.addLast(result);
        }
      }
      return deque.getFirst();
    }

    public static boolean isOperand(String token){
      String[] operandList = {"+","-","*","/","%"};
      for(String operand : operandList)
      {
        if(token.equals(operand))
        return true;
      }
      return false;
    }

    public static void main(String[] args){
      // System.out.println(eval("1 0 +"));//1.0
      // System.out.println(eval("1 2 +"));//3.0
      // System.out.println(eval("1 2 -"));//-1.0
      // System.out.println(eval("1 2 *"));//2.0
      // System.out.println(eval("3 2 *"));//6.0
      // System.out.println(eval("3 2 /"));//1.5
      // System.out.println(eval("18 4 %"));//2.0
      // // all of above works
      System.out.println(eval("3 4 5 + *"));//27.0
      System.out.println(eval("1 2 3 4 5 6 7 8 9 10 + + + + + + + + +"));//55.0
      System.out.println(eval("5 0 /"));//infinity
      System.out.println(eval("37 4 5 6 7 + - * %"));//5?
      System.out.println(eval("4 5 6 7 + - *"));//-32.0
      System.out.println(eval("37 -33 %"));
    }
}
