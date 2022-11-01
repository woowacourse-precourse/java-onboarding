package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 페이지 예외사항 처리
        if(exception(pobi.get(0), pobi.get(1)) || exception(crong.get(0), crong.get(1)))
            return answer = -1;

        // 승 패 무승부 처리
        int pobiNum = compareNum(pobi.get(0), pobi.get(1));
        int crongNum = compareNum(crong.get(0), crong.get(1));

        if(pobiNum>crongNum)
            answer = 1;
        else if(pobiNum<crongNum)
            answer = 2;
        else
            answer = 0;

        return answer;
    }

    // 합구하기
    public static int addNum(int num) {
        int sum = 0;

        while(num!=0) {
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }

    // 곱구하기
    public static int multiNum(int num) {
        int sum = 1;

        while(num!=0) {
            sum *= num % 10;
            num /= 10;
        }

        return sum;
    }

    // 큰 숫자 찾기
    public static int compareNum(int num1, int num2) {
        int left = Math.max(addNum(num1), multiNum(num1));
        int right = Math.max(addNum(num2), multiNum(num2));
        int big = Math.max(left, right);

        return big;
    }

    // 페이지 예외사항 처리
    // 페이지 오류
    // 처음이거나 끝페이지
    public static boolean exception(int num1, int num2) {
        boolean except = false;

        if(num2 - num1 != 1)
            except = true;
        else if(num1==1 || num2==400)
            except = true;

        return except;
    }
}