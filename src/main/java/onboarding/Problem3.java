package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        // 숫자의 각 자릿수에 접근하는 기능
        for (int i = 1; i < number + 1; i++) {
            String num = Integer.toString(i); // 숫자에서 문자열로 변환해준다

            for (int j = 0; j < num.length(); j++) { // for 문을 통해 각 자릿수에 접근한다
                char digit = num.charAt(j); // 각 자릿수
                // 각 자릿수가 3, 6, 9인지 판별하는 기능
                if (digit == '3' || digit == '6' || digit == '9') { // 자릿수가 3 또는 6 또는 9일 경우
                    answer += 1;
                }
            }
        }
        return answer;
    }
}
