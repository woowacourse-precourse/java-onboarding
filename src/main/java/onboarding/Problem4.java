package onboarding;
import java.util.Scanner;
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int i=0; i<word.length(); i++) { //반복문을 이용하여 문자 하나하나 변환하기
            if ((int)word.charAt(i)>96) { //대문자의 경우
                answer += (char)(219-(int)word.charAt(i));
            } else if ((int)word.charAt(i)>64) { //소문자의 경우
                answer += (char)(155-(int)word.charAt(i));
            } else { //문자가 아닐경우
                answer += word.charAt(i);
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
