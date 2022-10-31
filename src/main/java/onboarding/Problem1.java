package onboarding;

import java.util.List;

public class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
//        int answer = Integer.MAX_VALUE;

        //페이지 검증
        int p1 = pobi.get(0);
        int p2 = pobi.get(1);

        int c1 = crong.get(0);
        int c2 = crong.get(1);

        if (p1 == 0 && p2 == 400 && c1 == 0 && c2 == 400) {
            System.out.println("책을 다시 펼치세요");
        }

        if ((p1 + 1 != p2) || (c1 + 1 != c2)) {
            return -1;
        }

        //점수 획득
        int pobiLeft = getScore(sum(p1), multiply(p1));
        int pobiRight = getScore(sum(p2), multiply(p2));

        int pNum = getScore(pobiLeft, pobiRight);

        int crongLeft = getScore(sum(c1), multiply(c1));
        int crongRight = getScore(sum(c2), multiply(c2));

        int cNum = getScore(crongLeft, crongRight);

        if (pNum == cNum) {
            return 0;
        }

        return pNum > cNum ? 1 : 2;

    }

    //페이지 최댓값 비교
    private static int getScore(int sum, int multiply) {
        return sum > multiply ? sum : multiply;
    }

    //페이지 자릿수 덧셈
    public static int sum(int n) {
        int result = 0;

        while (n > 0) {
            result += n % 10;
            n /= 10;
        }

        return result;
    }

    //페이지 자릿수 곱셈
    public static int multiply(int n) {
        int result = 1;

        while (n > 0) {
            result *= n % 10;
            n /= 10;
        }


        return result;
    }


}