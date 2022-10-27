package onboarding;

/**
 * 기능목록(추후 다른 방법으로 리펙토리 가능성 있음)
 * 1. 어떤 한 숫자에 박수를 몇번 쳐야하는지 확인하는 메서드 구현
 * 2. 1~number 까지 반복
 */

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer +=checkClap(i);
        }
        return answer;
    }

    private static int checkClap(int num) {
        int clapCnt = 0;
        while (num > 0) {
            int eachDigit = num % 10;
            switch (eachDigit) {
                case 3:
                case 6:
                case 9:
                    clapCnt++;
                    break;
                default:
                    break;
            }
            num /= 10;
        }

        return clapCnt;
    }

}
