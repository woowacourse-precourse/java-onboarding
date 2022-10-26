package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

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
}
