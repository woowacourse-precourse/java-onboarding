package onboarding;

public class Problem3 {
    private static int count;

    public static int solution(int number) {
        int answer = 0;
        return answer;
    }

    private static void checkNumber(int num) {
        StringBuilder number = new StringBuilder(Integer.toString(num));

        for (int i = 0; i < number.length(); i++) {
            check369(number.charAt(i));
        }
    }
}
