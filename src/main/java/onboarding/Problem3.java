package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += getClap(Integer.toString(i));
        }

        return answer;
    }

    public static int getClap(String number) {
        int clap = 0;

        for (int i = 0; i < number.length(); i++) {
            if(isThreeSixNine(number.charAt(i))) {
                clap++;
            }
        }

        return clap;
    }

    public static boolean isThreeSixNine(char c) {
        int number = Character.getNumericValue(c);

        if (number == 0) {
            return false;
        }
        if (number % 3 == 0) {
            return true;
        }
        if (number % 6 == 0) {
            return true;
        }
        if (number % 9 == 0) {
            return true;
        }

        return false;
    }
}
