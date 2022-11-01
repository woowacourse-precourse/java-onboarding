package onboarding;

public class Problem3 {
    public static final char CONDITION1_CHAR_3 = '3';
    public static final char CONDITION2_CHAR_6 = '6';
    public static final char CONDITION3_CHAR_9 = '9';

    public static int getNumber(int number) {
        int sum = 0;
        for(int i = 1; i <= number; i++)
        {
            String num = String.valueOf(i);
            sum += num.chars().filter(numWord -> numWord == CONDITION1_CHAR_3).count();
            sum += num.chars().filter(numWord -> numWord == CONDITION2_CHAR_6).count();
            sum += num.chars().filter(numWord -> numWord == CONDITION3_CHAR_9).count();
        }
        return sum;
    }

    public static int solution(int number) {
        int answer = getNumber(number);
        return answer;
    }
}
