package onboarding;

public class Problem3 {

    // 각 자리의 수가 3 or 6 or 9 인지 확인하여 총 개수를 return
    public static int checkNum(String str, int strLen) {
        int res = 0;
        char tmp;

        for (int i = 0; i < strLen; i++) {
            tmp = str.charAt(i);
            if (tmp == '3' || tmp == '6' || tmp == '9') {
                res += 1;
            }
        }

        return res;
    }
    public static int solution(int number) {
        int answer = 0;
        String tmp;
        int strLen;

        // 1부터 number까지 3,6,9가 포함된 개수를 확인
        for (int i = 1; i <= number; i++) {
            tmp = String.valueOf(i);
            strLen = tmp.length();
            answer += checkNum(tmp, strLen);
        }

        return answer;
    }
}
