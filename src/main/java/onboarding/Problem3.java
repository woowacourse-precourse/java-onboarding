package onboarding;

public class Problem3 {

    public static int getCount(int number) {
        int count = 0;

        String num = String.valueOf(number);
        String[] digits = num.split("");

        for (int i = 0; i < digits.length; i++) {
            if(digits[i] == "3" || digits[i] == "6" || digits[i] == "9") count++;
        }
        return count;
    }
    public static int solution(int number) {
        int answer = 0;
        
        return answer;
    }
}
