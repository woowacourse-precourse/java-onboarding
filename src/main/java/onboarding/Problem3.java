package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i < number + 1; i++) {
            answer += countClaps(i);
        }
        return answer;
    }

    /**
     * count how many claps(3, 6, 9) in parameter 'target'
     * @param target
     * @return
     */
    static int countClaps(int target) {
        int clap = 0;

        while (target != 0) {
            if (((target % 10) == 3) || ((target % 10) == 6) || ((target % 10) == 9)) {
                clap++;
            }
            target /= 10;
        }

        return clap;
    }
}
