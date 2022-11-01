package onboarding;

public class Problem3 {

    public static int solution(int number) {

        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += calculateClap(i);
        }
        return answer;
    }

    public static int calculateClap(int currentNumber) {

        int clap = 0;
        String str = String.valueOf(currentNumber);

        if (!str.contains("3") && !str.contains("6") && !str.contains("9")) {
            return clap;
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '3' || str.charAt(i) == '6' || str.charAt(i) == '9') {
                    clap++;
                }
            }
        }
        return clap;
    }
}
