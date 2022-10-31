package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isException(pobi)||isException(crong)) {
            return -1;
        }
        int answer = Integer.MAX_VALUE;
        int pobiMax = Math.max(searchMaxNum(pobi.get(0)), searchMaxNum(pobi.get(1)));
        int crongMax = Math.max(searchMaxNum(crong.get(0)), searchMaxNum(crong.get(1)));
        if (pobiMax > crongMax) {
            answer = 1;
        }
        if (pobiMax < crongMax) {
            answer = 2;
        }
        if (pobiMax == crongMax) {
            answer = 0;
        }
        return answer;
    }

    private static boolean isException(List<Integer> list) {
        for (Integer integer : list) {
            if (integer < 1 || integer > 400) {
                return true;
            }
        }
        if (list.get(1) - list.get(0) !=1) {
            return true;
        }
        return false;

    }


    private static int searchMaxNum(Integer num) {
        int mutiply = 1;
        int sum = 0;
        while (num != 0) {
            mutiply *= num % 10;
            sum += num % 10;
            num /= 10;
        }
        return Math.max(mutiply, sum);
    }
}