package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            String str = String.valueOf(i);
            // 3,6,9가 포함되어 있을 경우
            if (str.indexOf('3') != -1 || str.indexOf('6') != -1 || str.indexOf('9') != -1) {
                // 3,
                answer += countChar(str, '3');
                answer += countChar(str, '6');
                answer += countChar(str, '9');
            }
        }
        return answer;
    }

    // 입력한 문자의 개수를 출력해주는 함수
    public static long countChar(String str, char ch) {
        return str.chars()
                .filter(c -> c == ch)
                .count();
    }
}
