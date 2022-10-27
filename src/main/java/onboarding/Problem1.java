package onboarding;

import java.util.List;

class Problem1 {
    public static int sum(int p) {
        //왼쪽 페이지와 오른쪽 페이지의 각 자리수의 합을 비교해서 더 큰 값을 반환
        int sum = 0;

        while(p != 0) {
            sum += (p % 10);
            p = p / 10;
        }

        return sum;
    }

    public static int mul(int p) {
        //왼쪽 페이지와 오른쪽 페이지의 각 자리수의 곱을 비교해서 더 큰 값을 반환
        int sum = 0;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiSum1 = sum(pobi.get(0));
        int pobiSum2 = sum(pobi.get(1));
        int crongSum1 = sum(crong.get(0));
        int crongSum2 = sum(crong.get(1));


        return answer;
    }
}