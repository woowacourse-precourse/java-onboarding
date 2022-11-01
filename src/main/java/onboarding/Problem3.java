package onboarding;

public class Problem3 {

    public static boolean countThreeSixNine(int num){
        if (num == 3 || num == 6 || num == 9) return true;
        return false;
    }
    public static int countClap(int num) {
        int cnt = 0;
        while (num != 0) {
            if(countThreeSixNine(num % 10)) cnt++;
            num /= 10;
        }
        return cnt;
    }

    public static int solution(int number) {
        int[] totalClap = new int[10001];
        totalClap[0] = 0;
        totalClap[1] = 0;
        for(int i=2; i <= number; i++) totalClap[i] = totalClap[i - 1] + countClap(i);
        return totalClap[number];
    }
}