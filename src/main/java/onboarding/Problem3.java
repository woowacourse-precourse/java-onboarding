package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            String temp = Integer.toString(i);
            char[] chr = temp.toCharArray();

            for (char j: chr) {
                if (j == '3' || j == '6' || j =='9') {
                    answer += 1;
                }
            }
        }

        return answer;
    }
}
