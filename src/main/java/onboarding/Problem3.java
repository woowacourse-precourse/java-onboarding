package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int i = 0;
        for (i = 0; i <= number; i++) {
            String numberStr = String.valueOf(i);
            if (numberStr.contains("3") || numberStr.contains("6") || numberStr.contains("9")) {
                System.out.println(numberStr);
            }
        }

        int answer = 3;
        return answer;

    }
}
