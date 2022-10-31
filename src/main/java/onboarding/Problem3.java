package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return getClapCount(number);
    }

    static int getClapCount(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            int current = i;

            while (current != 0) {
                int temp = current % 10;
                if (temp == 3 || temp == 6 || temp == 9) {
                    count++;
                }
                current /= 10;
            }
        }
        return count;
    }

}
