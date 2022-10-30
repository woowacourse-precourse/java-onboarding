package onboarding;

public class Problem3 {
    public static int solution(int number) {
        return playGame(number);
    }

    /**
     * 1부터 number까지 3,6,9 게임하기
     * @param number
     * @return int
     */
    private static int playGame(int number) {
        int clap = 0;
        for (int i = 1; i <= number; i++) {
            clap = clapping(i, clap);
        }
        return clap;
    }

    /**
     * 숫자가 3, 6, 9 를 포함하고 있는 만큼 박수치기
     * @param i
     * @param clap
     * @return int
     */
    private static int clapping(int i, int clap) {
        String str = String.valueOf(i);
        for (int j = 0; j < str.length(); j++) {
            if (isContain(str.charAt(j))) {
                clap++;
            }
        }
        return clap;
    }

    /**
     * 숫자가 3,6,9를 포함하고 있는지 판별
     * @param number
     * @return 포함하면 true / 포함하지 않으면 false
     */
    private static boolean isContain(char number) {
        if (number == '3' || number == '6' || number == '9') {
            return true;
        }
        return false;
    }
}
