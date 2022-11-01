package onboarding;

public class Problem3 {
    public static int solution(int number) {
        /*
         * 숫자를 자릿수 별로 확인하여 3,6,9인지 확인하여 횟수 구한다.
         */
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            String strNum = String.valueOf(i);
            answer += countClaps(strNum);
        }

        return answer;
    }

    public static boolean is369(int num) {
        if (num == 3 || num == 6 || num == 9) {
            return true;
        } else {
            return false;
        }
    }

    public static int countClaps(String strNum) {
        int cnt = 0;

        for (int i = 0; i < strNum.length(); i++) {
            int num = strNum.charAt(i) - '0';

            if (is369(num)) {
                cnt += 1;
            }
        }

        return cnt;
    }
}
