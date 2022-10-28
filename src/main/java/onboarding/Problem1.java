package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static boolean hasError(List<Integer> list) {
        int left = list.get(0);
        int right = list.get(1);

        //페이지 번호가 1~400인지 확인
        if(left < 1 || left > 400) return true;
        if(right < 1 || right > 400) return true;

        //왼쪽 페이지 번호가 홀수 인지 확인
        if (left % 2 == 0) return true;

        //숫자가 연속적인지 확인 (오른쪽 페이지 번호가 짝수 인지 확인)
        return (right - left != 1);
    }

    public static int getScore(List<Integer> list){
        //왼쪽 페이지에서 큰 수
        int left = Math.max(addNum(list.get(0)),mulNum(list.get(0)));
        //오른쪽 페이지에서 큰 수
        int right = Math.max(addNum(list.get(1)), mulNum(list.get(1)));

        //두 숫자중 더 큰수 리턴
        return Math.max(left, right);
    }

    public static int addNum(int n){
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static int mulNum(int n){
        int sum = 1;
        while (n != 0) {
            sum *= n % 10;
            n /= 10;
        }
        return sum;
    }
}