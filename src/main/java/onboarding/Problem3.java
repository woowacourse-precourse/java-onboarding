package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for (int num = 1; num <= number; num ++) {
            answer += countNum(Integer.toString(num), '3');
            answer += countNum(Integer.toString(num), '6');
            answer += countNum(Integer.toString(num), '9');
        }
        return answer;
    }

    public static int countNum(String strNum, char num) {
        int count = 0;
        for (int ind = 0; ind < strNum.length(); ind++) {
            if (strNum.charAt(ind) == num) {
                count++;
            }
        }
        return count;
    }
}
