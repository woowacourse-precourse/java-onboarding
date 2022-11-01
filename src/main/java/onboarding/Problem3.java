package onboarding;

/**
 * 기능 목록
 * 1. 검증할 수를 char[]로 변환
 * 2. 3,6,9 몇 개 포함됐는지 세는 함수
 */
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            char[] numbers = String.valueOf(i).toCharArray();

            answer += count369(numbers);
        }

        return answer;
    }

    public static int count369(char[] numbers) {
        int count = 0;

        for (char number : numbers) {
            if (number == '3' || number == '6' || number == '9') {
                count++;
            }
        }

        return count;
    }
}
