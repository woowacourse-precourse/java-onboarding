package onboarding;

public class Problem3 {
    public static int solution(int number) {

        int clapNum = 0;

        for (int i = 0; i <= number; i++) {
            int loopNum = i;
            while (loopNum > 0) {
                if (loopNum % 10 == 3 || loopNum % 10 == 6 || loopNum % 10 == 9) {
                    clapNum++;
                }

                loopNum /= 10;

                if (loopNum == 0) {
                    break;
                }
            }
        }

        return clapNum;
    }

    public static void main(String[] args) {
        int solution = solution(33);
        System.out.println("solution = " + solution);
    }
}
