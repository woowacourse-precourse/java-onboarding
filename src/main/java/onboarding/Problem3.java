package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return countClap(number);
    }

    private static int countClap(int number) {
        int clap = 0;
        for(int i = 1; i <= number; i++) {
            String num = String.valueOf(i);
            clap = counting(clap, num);
        }
        return clap;
    }

    private static int counting(int clap, String number) {
        for(int j = 0; j < number.length(); j++) {
            int numericValue = number.charAt(j)-'0';
            if((numericValue) % 3 == 0 && (numericValue != 0)) {
                clap++;
            }
        }
        return clap;
    }
}