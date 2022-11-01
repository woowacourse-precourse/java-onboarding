package onboarding;

public class Problem3 {

    static char[] convertToCharArray(int number) {
        String numString = Integer.toString(number);
        char[] numCharArray = numString.toCharArray();

        return numCharArray;
    }

    static int checkThreeSixNine(char[] numCharArray) {
        int count = 0;

        for (char x: numCharArray) {
            if (x == '3' || x == '6' || x == '9') {
                count++;
            }
        }

        return count;
    }

    public static int solution(int number) {
        int answer = 0;
        int i = 1;

        while (i <= number) {
            char[] numCharArray = convertToCharArray(i);
            answer += checkThreeSixNine(numCharArray);
            i++;
        }

        return answer;
    }
}
