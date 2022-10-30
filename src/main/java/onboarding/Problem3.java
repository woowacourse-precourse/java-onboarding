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

}
