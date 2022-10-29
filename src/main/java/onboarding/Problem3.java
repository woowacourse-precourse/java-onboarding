package onboarding;

public class Problem3 {

    public static boolean validCheck(int number) {
        return number >= 1 && number <= 10000;
    }

    public static int countClap(int number) {
        int cnt = 0;
        int lastNumber;
        for(int i = 0; i<=number; i++){
            int temp = i;
            while (temp != 0) {
                lastNumber = temp % 10;
                if (lastNumber == 3 || lastNumber == 6 || lastNumber == 9) {
                    cnt++;
                }
                temp /= 10;
            }
        }
        return cnt;
    }

    public static int solution(int number) {
        if (!validCheck(number)) {
            throw new IllegalStateException("잘못된 입력입니다.");
        }
        int answer = 0;
        answer = countClap(number);
        return answer;
    }
}
