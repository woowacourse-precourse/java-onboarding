package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer;
        for (int i = 1; i < number; i++) {
            if (containThreeSixNine(i)) {
            }
        }

        return 1;
    }

    public static boolean containThreeSixNine(int num) {
        String str = Integer.toString(num);
        return str.contains("3") || str.contains("6") || str.contains("9");
    }
}
