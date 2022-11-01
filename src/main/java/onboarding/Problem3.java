package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        String numToString;
        for (int i = 0; i <= number; i ++) {
            numToString = String.valueOf(i);
            for (int j = 0; j < numToString.length(); j++) {
                if (contains(numToString.charAt(j))) {
                    answer ++;
                }
            }
        }
        return answer;
    }

    static boolean contains(char num) {
        char[] clap_cases = {'3', '6', '9'};
        for (int i = 0; i < 3; i ++) {
            if (clap_cases[i] == num) {
                return true;
            }
        }
        return false;
    }
}
