package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static int countNumber(int num) {
        String strNum = Integer.toString(num);
        int count = 0;

        for (int i = 0; i < strNum.length(); i++) {
            if (strNum.charAt(i) == '3' || strNum.charAt(i) == '6' || strNum.charAt(i) == '9') {
                count++;
            }
        }

        return count;
    }
}
