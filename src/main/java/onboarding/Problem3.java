package onboarding;

public class Problem3 {
    private static char THREE = '3';
    private static char SIX = '6';
    private static char NINE = '9';
    public static int solution(int number) {
        int answer = 0;
        answer = intToStringAndCount(number, answer);
        return answer;
    }

    private static int intToStringAndCount(int number, int answer) {
        for (int i = 1; i <= number; i++) {
            String num = String.valueOf(i);
            answer = countNumber(answer, num);
        }
        return answer;
    }

    private static int countNumber(int count, String num) {
        for (int j = 0; j < num.length(); j++) {
            char checkNumber = num.charAt(j);
            if (existThreeSixNine(checkNumber)) {
                count++;
            }
        }
        return count;
    }

    private static boolean existThreeSixNine(char checkNumber) {
        return checkNumber == THREE || checkNumber == SIX || checkNumber == NINE;
    }
}
