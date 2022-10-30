package onboarding;

public class Problem3 {
    public static int solution(int number) {
        // n까지 진행하면서 정규표현식으로 진행되는 문제
        int answer = 0;
        // 1) 1~number까지 진행하기
        // 시작값을 1로 했지만 3부터 진행해도 문제 X (369 최소 숫자가 3이므로)
        for (int i=1; i<=number;i++) {
            // 2) 숫자를 문자열로 교체하기
            String Strnumber = Integer.toString(i); // 문자열로 교환
            // 3) 정규표현식 값 만들기 ([]안에 있는 값이 있을 때 // ^ = not // 369가 아닌 값들 전부)
            String Regex = "[^369]";
            // 4) 정규표현식에 일치되는 값들 ""로 치환 후 길이 더하기
            answer += Strnumber.replaceAll(Regex,"").length();
        }
        return answer;
    }
}
