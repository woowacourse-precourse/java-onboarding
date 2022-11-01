package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer +=countThreeNumbers(i);
        }

        return answer;
    }

    /* 주어진 정수에서 3,6,9 개수의 합을 구하는 메서드 */
    private static int countThreeNumbers(int number) {
        int result = 0;
        String stringNumber = Integer.toString(number);

        for (int i = 0; i < stringNumber.length(); i++) {
            char c =stringNumber.charAt(i);
            if (c == '3' || c == '6' || c=='9') {
                result++;
            }
        }

        return result;
    }
}
