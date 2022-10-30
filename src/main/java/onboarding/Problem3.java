package onboarding;


public class Problem3 {
    public static int solution(int number) {
        return findTotalClapsFromNum(number);
    }

    private static int findTotalClapsFromNum(int num) {
        int clap = 0;
        for (int i = 1; i <= num; i++) {
            int temp = i;
            while ( temp > 0) {
                if (canClap(temp % 10)) {
                    clap += 1;
                }
                temp /= 10;
            }
        }
        return clap;
    }

    private static boolean canClap(int clap) {
        return clap == 3 || clap == 6 || clap == 9;
    }
}
