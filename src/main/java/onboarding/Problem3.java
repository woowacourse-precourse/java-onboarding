package onboarding;


import java.util.List;

public class Problem3 {

    private static final List<Integer> CLAP_LIST = List.of(3, 6, 9);

    public static int solution(int number) {
        return findTotalClapsFromNum(number);
    }

    private static int findTotalClapsFromNum(int num) {
        int totalClap = 0;
        for (int i = 1; i <= num; i++) {
            int temp = i;
            while ( temp > 0) {
                if (canClap(temp % 10))
                    totalClap += 1;
                temp /= 10;
            }
        }
        return totalClap;
    }

    private static boolean canClap(int n) {
        for (int clap : CLAP_LIST) {
            if (n == clap)
                return true;
        }
        return false;
    }
}
