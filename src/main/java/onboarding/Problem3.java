package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
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

        if (c % 3 == 0) {
            return true;
        }
        if (c % 6 == 0) {
            return true;
        }
        if (c % 9 == 0) {
            return true;
        }

        return false;
    }
}
