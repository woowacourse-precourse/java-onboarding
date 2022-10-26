package onboarding;

public class Problem3 {

    public static int countOf369(int num) {
        int sum = 0;
        String strNum = String.valueOf(num);
        for (int i = 0; i < strNum.length(); i++) {
            int digit = strNum.charAt(i) - '0';
            if (digit == 3 || digit == 6 || digit == 9){
                sum++;
            }
        }
        return sum;
    }

    public static int solution(int number) {
        int answer = 0;

        return answer;
    }
}
