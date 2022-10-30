package onboarding;

public class Problem3 {

    static int cnt369(int num) {
        char[] strNum = String.valueOf(num).toCharArray();
        int numLen = strNum.length;
        int count = 0;
        for (int i = 0; i < numLen; i++)
            if ((strNum[i] == '3') || (strNum[i] == '6') || (strNum[i] == '9'))
                count += 1;
        return count;
    }

    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += cnt369(i);
        }
        return answer;
    }
}
