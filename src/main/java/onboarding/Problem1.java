package onboarding;

import java.util.List;

class Problem1 {

    public static int findMax(List<Integer> pageList){
        int leftPage = pageList.get(0);
        int rightPage = pageList.get(1);
        int result;

        if(rightPage-1 != leftPage || rightPage == leftPage || leftPage == 1 || rightPage == 400)
            return -1;

        int maxLeft = CompareMax(Sum(leftPage), Mul(leftPage));
        int maxRight = CompareMax(Sum(rightPage), Mul(rightPage));

        result = CompareMax(maxLeft, maxRight);

        return result;
    }

    public static int Sum(int page){
        int sum = 0;

        while(page > 0) {sum += page%10; page /= 10;}
        return sum;
    }

    public static int CompareMax(int c1, int c2){
        int max = 0;

        if(c1>c2){max = c1;}
        else if(c1==c2){max = c1;}
        else{max = c2;}

        return max;
    }

    public static int Mul(int page){
        int sum = 0;

        while(page > 0) {sum *= page%10; page /= 10;}
        return sum;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiAns = findMax(pobi);
        int crongAns = findMax(crong);

        if(pobiAns == -1 || crongAns == -1){
            answer = -1;

        }else {
            switch (Integer.compare(pobiAns, crongAns)) {
                case 0:
                    answer = 0;
                    break;
                case 1:
                    answer = 1;
                    break;
                case -1:
                    answer = 2;
                    break;
            }
        }
        return answer;
    }
}