package onboarding;

import java.util.Scanner;
import java.util.Stack;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String PW = sc.next();
        System.out.println(solution(PW));
    }
public static String solution(String cryptogram) {
  String answer = "";
  Stack<String> stack = new Stack<>();
  String[] cryptogramList = cryptogram.split("");
  for(String c : cryptogramList){
    if(!stack.isEmpty() && stack.peek().equals(c)){
      stack.pop();
    }
    else {
      stack.add(c);
    }
  }
  return String.join("", stack);
    }
}
