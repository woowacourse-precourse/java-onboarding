package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        Problem3 p3 = new Problem3();
        for (int i = 1; i <= number; i++) {
            if (p3.is369(i)) {
                answer += p3.getClapPerEachNum(i);
            }
        }
        return answer;
    }


    private boolean is369(int number) {
        String num = String.valueOf(number);
        return num.contains("3") || num.contains("6") || num.contains("9");
    }

    private int getClapPerEachNum(int number) {
        int count = 0;

        while (number > 0) {
            int temp = number % 10;
            if (temp == 3 || temp == 6 || temp == 9) {
                count++;
            }
            number /= 10;
        }
        return count;
    }
}
