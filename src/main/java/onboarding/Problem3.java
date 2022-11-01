package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        if (isError(number)) {
            return -1;
        }

        for (int i = 1; i <= number; i++) {
            answer += getClap(Integer.toString(i));
        }

        return answer;
    }

    public static boolean isError(int number) {
        return (number < 1) || (number > 10000);
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

    public static boolean isThreeSixNine(char number) {
        return (number == '3') || (number == '6') || (number == '9');
    }
}
