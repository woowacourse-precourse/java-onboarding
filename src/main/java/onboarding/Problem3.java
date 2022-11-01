package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        Problem3 p3 = new Problem3();
        for (int i = 1; i <= number; i++) {
            answer += p3.getClapPerEachNum(i);
        }
        return answer;
    }


    private boolean is369(int number) {  //TODO: 필요성 검토
        while (number > 0) {
            int temp = number % 10;
            if (temp == 3 || temp == 6 || temp == 9) {
                return true;
            }
            number /= 10;
        }
        return false;
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
