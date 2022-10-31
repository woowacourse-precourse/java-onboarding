package onboarding;

public class Problem3 {

    public static int getCount(int number) {
        int count = 0;

        String num = String.valueOf(number);
        String[] digits = num.split("");

        for (int i = 0; i < digits.length; i++) {
            if(digits[i].equals("3") || digits[i].equals("6") || digits[i].equals("9")) count++;
        }
        return count;
    }
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += getCount(i);
        }
        return answer;
    }
}
