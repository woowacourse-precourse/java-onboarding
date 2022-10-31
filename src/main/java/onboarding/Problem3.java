package onboarding;

class Game369 {
    private int number;

    public Game369(int number) {
        this.number = number;
    }

    public int calculateClapCount() {
        int clapCnt = 0;
        for (int i = 1; i <= number; i++) {
            clapCnt += addClapCnt(i);
        }
        return clapCnt;
    }

    private int addClapCnt(int num) {
        int clapCnt = 0;
        String[] split = String.valueOf(num).split("");
        for (String s : split) {
            int now = Integer.parseInt(s);
            if (isClapCondition(now))
                clapCnt++;
        }
        return clapCnt;
    }

    private boolean isClapCondition(int num) {
        if(num == 3 || num == 6 || num == 9)
            return true;
        return false;
    }
}

/*
기능 목록
1. 1 ~ 10000 까지 수 증가하면서 박수 횟수 새기
 */
public class Problem3 {
    public static int solution(int number) {
        Game369 game369 = new Game369(number);
        return game369.calculateClapCount();
    }
}