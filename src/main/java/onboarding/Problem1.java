package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiLeftMax = Integer.max(addAllNumbers(pobi.get(0)), multiplyAllNumbers(pobi.get(0)));
        int pobiRightMax = Integer.max(addAllNumbers(pobi.get(1)), multiplyAllNumbers(pobi.get(1)));
        int pobiScore = Integer.max(pobiLeftMax, pobiRightMax);

        int crongLeftMax = Integer.max(addAllNumbers(crong.get(0)), multiplyAllNumbers(crong.get(0)));
        int crongRightMax = Integer.max(addAllNumbers(crong.get(1)), multiplyAllNumbers(crong.get(1)));
        int crongScore = Integer.max(crongLeftMax, crongRightMax);



        return answer;
    }
    private static int addAllNumbers(int page){
        int sum = 0;
        while (page > 0){
            sum += page % 10;
            page /= 10;
        }
        return sum;
    }

    private static int multiplyAllNumbers(int page){
        int sum = 1;
        while (page > 0){
            sum *= page % 10;
            page /= 10;
        }
        return sum;
    }
}