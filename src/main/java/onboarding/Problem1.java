package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiMax = checkLeftRight(pobi.get(0),pobi.get(1));
        int crongMax = checkLeftRight(crong.get(0),crong.get(1));
        int answer = checkScore(pobiMax,crongMax);

        return answer;
    }

    private static int getMaxPage(int page){
        int num = 0;
        int sum = 0;
        int mul = 1;

        while (page>0){
            num = page%10;
            sum += num;
            mul *= num;
            page /= 10;
        }
        return Math.max(sum,mul);
    }

    private static int checkLeftRight(int leftPage, int rightPage){
        int left = getMaxPage(leftPage);
        int right = getMaxPage(rightPage);

        return Math.max(left,right);
    }

    private static int checkScore(int pobiScore, int crongScore){
        int answer = -1;

        if (pobiScore>crongScore) {
            answer = 1;
        } else if (pobiScore<crongScore){
            answer = 2;
        } else {
            answer = 0;
        }

        return answer;
    }
}
