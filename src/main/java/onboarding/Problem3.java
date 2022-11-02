package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 3; i <= number; i++) {
            String[] num = String.valueOf(i).split("");

            for (String s : num) {
                int target = Integer.parseInt(s);

                if (target != 0 && target % 3 == 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
