package onboarding;

/*
기능 목록
1. 1 ~ 10000 까지 수 증가하면서 박수 횟수 새기
 */
public class Problem3 {
    public static int solution(int number) {
        int clapCnt = 0;
        for(int i = 1; i <= number; i++){
            clapCnt += addClapCnt(i);
        }
        return clapCnt;
    }

    private static int addClapCnt(int num) {
        int clapCnt = 0;
        String[] split = String.valueOf(num).split("");
        for (String s : split) {
            int now = Integer.parseInt(s);
            if(now == 3 || now == 6 || now == 9)
                clapCnt++;
        }
        return clapCnt;
    }
}