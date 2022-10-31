package onboarding;

/**
 * @작성자 rjsah09
 * @작성일 2022.10.31
 *
 * @수정내역
 * 2022.10.31 17:43 커밋 메시지 수정 후 재 push
 * */

public class Problem3 {
    public static int solution(int number) {
        int answer = getAnswer(number);
        return answer;
    }

    private static boolean isClap(int n){
        String str = Integer.toString(n);
        if(str.contains("3") || str.contains("6") || str.contains("9")) {
            return true;
        }

        return false;
    }

    private static int getClaps(int n) {
        int clap = 0;

        while(n > 0) {
            int now = n % 10;
            if(now == 3 || now == 6 || now == 9) {
                clap++;
            }
            n /= 10;
        }

        return clap;
    }

    private static int getAnswer(int n) {
        int clap = 0;

        for(int i = 1; i <= n; i++) {
            if(isClap(n)) {
                clap += getClaps(i);
            }
        }

        return clap;
    }

}
