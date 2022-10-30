package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = clapCount(number);

        return answer;
    }
    // 3 6 9 계산하는 메서드
    public static int clapCount(int number) {
        int count = 0;
        for (int i = 0; i <= number; i++) {
            int temp = i;
            int length = (temp + "").length();
            for (int j = 0; j < length; j++) {
                int tempNum = temp % 10;
                if (tempNum == 3 || tempNum == 6 || tempNum == 9) {
                    count++;
                }
                temp /= 10;
            }
        }
        return count;
    }
}
