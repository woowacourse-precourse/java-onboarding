import java.util.Scanner;

package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        // i번째의 문자의 인덱스 번호와 같으면(처음등장 or 유일한 str) 해당 인덱스 문자를 추가
		for (int i = 0; i < str.length(); i++) { 
			if (str.indexOf(str.charAt(i)) == i)
				answer += str.charAt(i);

		}
		return answer;
    public static void main(String[] args) {
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		String str = kb.next();
		System.out.println(T.solution(str));
	}
    }
}
