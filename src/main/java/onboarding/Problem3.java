package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i < number + 1; i ++) {                                 // 1부터 number까지
            String numStr = Integer.toString(i);                                // 현재 외칠 숫자를 문자열로 변환
            for (int j = 0; j < numStr.length(); j++) {                         // 현재 외칠 숫자의 각 자릿수별로
                char numChar = numStr.charAt(j);                                // 현재 자릿수가
                if (numChar == '3' || numChar == '6' || numChar == '9') {       // 3 or 6 or 9이면
                    answer += 1;                                                // 박수 횟수 증가
                }
            }
        }
        return answer;
    }
}
