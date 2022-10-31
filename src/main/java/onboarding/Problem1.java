package onboarding;

import java.util.List;

class Problem1 {

    public static int add(int pageNum) {
        int result = 0;

        while(pageNum>0) {
            result += pageNum%10;
            pageNum /= 10;
        }

        return result;
    }

    public static int mul(int pageNum) {
        int result = 1;

        while(pageNum>0) {
            result *= pageNum%10;
            pageNum /= 10;
        }

        return result;
    }

    public static int check(List<Integer> who) {
        //왼쪽, 오른쪽에 대한 덧셈, 곱셈 해주기
        int leftAdd = add(who.get(0));
        int rightAdd = add(who.get(1));
        int leftMul = mul(who.get(0));
        int rightMul = mul(who.get(1));

        int max = Integer.MIN_VALUE;
        int arr[] = {leftAdd, rightAdd, leftMul, rightMul};

        for (int i = 0; i < arr.length; i++) {
            if(max < arr[i])
                max = arr[i];
        }

        return max;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
    }
}