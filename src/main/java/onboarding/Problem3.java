package onboarding;

public class Problem3 {
    private static final int[] CLAP_NUM = new int[10001];

    public static int solution(int number) {
        int answer = 0;

        for (int i = 2; i <= number; ++i) {
            CLAP_NUM[i] = CLAP_NUM[i - 1] + countClapNum(i);
        }
        answer = CLAP_NUM[number];
        return answer;
    }

    public static int countClapNum(int number) {
        int clapNum = 0;
        while (number > 0) {
            clapNum += addOneClapOrNot(number % 10);
            number = number / 10;
        }
        return clapNum;
    }

    public static int addOneClapOrNot(int num) {
        if (num == 3 || num == 6 || num == 9)
            return 1;
        return 0;
    }
}
