package onboarding;

public class Problem3 {

    static char[] convertToCharArray(int number) {
        String numString = Integer.toString(number);
        char[] numCharArray = numString.toCharArray();

        return numCharArray;
    }

    public static int solution(int number) {
        int answer = 0;

        convertToCharArray(number);

        return answer;
    }
}
