package onboarding;
import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String W = sc.nextLine();
       System.out.println(solution(W));
    }
    public static String solution(String word) {
      String answer = "";
      for(int i = 0; i < word.length(); i++){
        char c = word.charAt(i);
        if(Character.isUpperCase(c)){
          c = (char) (90 - c + 65);
        }
        else if (Character.isLowerCase(c)) {
          c = (char) (122 - c + 97);
        }
        answer += String.valueOf(c);
      }
      return answer;
    }
}
