package onboarding;

import java.util.List;

class Problem1 {

    public static int findMax(List<Integer> pageList){
        int leftPage = pageList.get(0);
        int rightPage = pageList.get(1);
        int result;

        // 예외처리
        if(rightPage-1 != leftPage || leftPage == 1 || rightPage == 400)
            return -1;

        int maxLeft = CompareMax(Sum(leftPage), Mul(leftPage)); // 왼쪽 페이지의 합, 곱 중 큰 것
        int maxRight = CompareMax(Sum(rightPage), Mul(rightPage)); // 오른쪽 페이지의 합, 곱 중 큰 것

        result = CompareMax(maxLeft, maxRight); // 가장 큰 값

        return result;
    }

    public static int Sum(int page){
        int sum = 0;

        while(page > 0) {sum += page%10; page /= 10;}
        return sum;
    }

    public static int Mul(int page){
        int mul = 1;

        while(page > 0) {mul *= page%10; page /= 10;}
        return mul;
    }

    public static int CompareMax(int c1, int c2){
        int max;

        if (c1>c2){max = c1;}
        else if (c1==c2){max = c1;}
        else{max = c2;}

        return max;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiAns = findMax(pobi);
        int crongAns = findMax(crong);

        if(pobiAns == -1 || crongAns == -1){
            answer = -1;

        }else {
            switch (Integer.compare(pobiAns, crongAns)) {
                case 1: // 포비가 이긴 경우
                    answer = 1;
                    break;
                case 0: // 비긴 경우
                    answer = 0;
                    break;
                case -1: // 크롱이 이긴 경우
                    answer = 2;
                    break;
            }
        }
        return answer;
    }
}