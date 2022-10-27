package onboarding;

import java.util.List;

class Problem1 {

    //한 페이지 번호의 각 자리 숫자를 모두 더하는 함수
    static int sum(int n) {
        int num = 0;
        while (n % 10 != 0) {
            num += (n % 10);
            n /= 10;
        }
        return num;
    }
    //한 페이지 번호의 각 자리 숫자를 모두 곱하는 함수
    static int product(int n){
        int num=1;
        while (n % 10 != 0) {
            num *= (n % 10);
            n/=10;
        }
        return num;
    }
    //한명의 최대 점수를 구하는 함수
    static int getMax(List<Integer> a){
        int maxNumber =0;
        for (int number : a) {
            maxNumber = Math.max(maxNumber, Math.max(sum(number), product(number)));
        }
        return maxNumber;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //예외처리 (페이지가 연속하지 않는경우)

        //포비와 크롱의 점수를 비교하여 answer을 결정

        return answer;
    }
}