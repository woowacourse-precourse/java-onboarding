package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        // Do loop until input value
        for (int i = 1; i <= number; ++i) {
            // Convert number to string
            String input = Integer.toString(i);

            for (int j = 0; j < input.length(); ++j) {
                // Get each number as a string
                char checkNumber = input.charAt(j);
                // Count if it equals to number that occurs clap
                if (checkNumber == '3' || checkNumber == '6' || checkNumber == '9') {
                    answer += 1;
                }
            }
        }
        return answer ;
    }
}
