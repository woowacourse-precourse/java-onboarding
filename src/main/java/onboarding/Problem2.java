package onboarding;
import java.util.Scanner;
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        Problem2 m = new Problem2();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(m.solution(str));
        return answer;
    }
    public static String solution(String str) {
		String answer = "";
		
		for (int i = 0; i < str.length(); i++) {
			if(str.indexOf(str.charAt(i)) == i) answer += str.charAt(i);
		}
		
		return answer;
	}

}
