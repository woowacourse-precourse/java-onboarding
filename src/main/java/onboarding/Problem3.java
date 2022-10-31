package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int clap = 0;
        for(int i = 1; i < number + 1; i ++){
            char[] numCharArray = Integer.toString(i).toCharArray();
            for (char c : numCharArray) {
                if (c == '3' | c == '6' | c == '9') {
                    clap++;
                }
            }
        }
        return clap;
    }
}
