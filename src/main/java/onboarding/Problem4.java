package onboarding;

public class Problem4 {
    public static int setSum(char alphabet) {
        int sum;
        if (Character.isUpperCase(alphabet)) sum = 155;
        else if (Character.isLowerCase(alphabet)) sum = 219;
        else sum = 2 * alphabet;

        return sum;
    }
    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
