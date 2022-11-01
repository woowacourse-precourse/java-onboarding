package onboarding;

public class Problem3 {

    private static int getClap(int num){

        int clap = 0;
        while (num != 0) {

            int temp = num % 10;
            if (temp != 0 && (temp % 3 == 0 || temp % 6 == 0 || temp % 9 == 0)){
                clap += 1;
            }

            num = num / 10;
        }

        return clap;
    }
    public static int solution(int number) {

        int cnt = 0;
        for (int i=1; i <= number; i++){
            cnt += getClap(i);
        }

        return cnt;
    }
}
