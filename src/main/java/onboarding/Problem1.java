package onboarding;

import java.util.List;

class Problem1 {

    public static List<Integer> getSumNMul(Integer page) {
        int sum = 0;
        int mul = 1;
        for (String strPage : page.toString().split("")) {
            sum += Integer.parseInt(strPage);
            mul *= Integer.parseInt(strPage);
        }
        return List.of(sum,mul);
    }

    public static int maxVal(List<Integer> pages) {
        int maxVal = Integer.MIN_VALUE;
        for (Integer page : pages) {
            List<Integer> sumNmul = getSumNMul(page);
            if (maxVal<sumNmul.get(0)) {
                maxVal = sumNmul.get(0);
            }
            if (maxVal<sumNmul.get(1)) {
                maxVal = sumNmul.get(1);
            }
        }
        return maxVal;
    }

    public static boolean exception(Integer pobiFirst,Integer pobiSecond,Integer crongFirst,Integer crongSecond) {
        return (pobiSecond - pobiFirst != 1) ||
                (crongSecond - crongFirst != 1) ||
                (pobiFirst == 1) || (pobiSecond == 400) ||
                (crongFirst == 1) || (crongSecond == 400);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;
        if (exception(pobi.get(0),pobi.get(1),crong.get(0),crong.get(1))) {
            answer = -1;
            return answer;
        }
        int pobiScore = maxVal(pobi);
        int crongScore = maxVal(crong);
        if (pobiScore == crongScore) {
            answer = 0;
        } else if (pobiScore > crongScore) {
            answer = 1;
        } else {
            answer = 2;
        }
        return answer;
    }
}