package onboarding;
import java.util.Scanner;
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int i=0; i<word.length(); i++) {
            if ((int)word.charAt(i)>96) {
                answer += (char)(219-(int)word.charAt(i));
            } else if ((int)word.charAt(i)>64) {
                answer += (char)(155-(int)word.charAt(i));
            } else {
                answer += " ";
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        System.out.println(solution(word));
    }
}
