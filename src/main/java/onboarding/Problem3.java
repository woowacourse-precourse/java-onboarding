package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {

            String numberStr = String.valueOf(i);
            if (numberStr.contains("3") || numberStr.contains("6") || numberStr.contains("9")) {
                count++;
                System.out.println(count);
            }
        }

        int answer = count;
        return answer;

    }
}
