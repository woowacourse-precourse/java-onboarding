package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static int makeClapCount(int number) {
        if (number <= 0)
            return 0;

        int count = 0;
        switch (number % 10) {
            case 3:
            case 6:
            case 9:
                ++count;
                break;
            default:
                break;
        }
        return count + makeClapCount(number / 10);
    }
}