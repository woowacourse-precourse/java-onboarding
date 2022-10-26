package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        if (number > 3) {
            answer = getHandClap(number);
        }
        System.out.println(answer);
        return answer;
    }

    public static int getHandClap(int number) {
        int totalCount = 0;
        for (int i = 3; i < number + 1; i++) {
            totalCount += getCount(i);
        }
        return totalCount;
    }

    public static int getCount(int number) {
        int count = 0;
        while (number > 0) {
            int target = number % 10;
            if (target != 0 && target % 3 == 0) {
                count += 1;
            }
            number /= 10;
        }
        return count;
    }
}
