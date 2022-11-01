package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            String stringNumber = String.valueOf(i);

            answer += get369Number(stringNumber);
        }

        return answer;
    }

    private static int get369Number(String stringNumber) {
        int count = 0;

        for (int j = 0; j < stringNumber.length(); j++) {
            if (stringNumber.charAt(j) == '3'
                || stringNumber.charAt(j) == '6'
                || stringNumber.charAt(j) == '9') {
                count++;
            }
        }
        return count;
    }
}
