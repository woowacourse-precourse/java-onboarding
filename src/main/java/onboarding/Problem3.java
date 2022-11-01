package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        // 숫자의 각 자릿수에 접근하는 기능
        for (int i = 1; i < number + 1; i++) {
            String num = Integer.toString(i); // 숫자에서 문자열로 변환해준다

            for (int j = 0; j < num.length(); j++) { // for 문을 통해 각 자릿수에 접근한다
                char digit = num.charAt(j); // 각 자릿수
            }
        }
        return answer;
    }
}
