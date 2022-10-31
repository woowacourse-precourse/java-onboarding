package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        if (number > 10000 || number < 1) {
            return -1;
        }
        for (int i = 1; i <= number; i++) {
            answer += func(i);
        }
        return answer;
    }

    public static int func(int num) {
        String[] str = String.valueOf(num).split("");
        int count = 0;
        for (String j : str) {
            int k = Integer.parseInt(j);
            if (k % 3 == 0 && k != 0) {
                count += 1;
            }
        }
        return count;
    }
}


