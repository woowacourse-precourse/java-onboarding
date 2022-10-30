package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(checkInput(pobi, crong))     // 예외사항 체크
            return -1;

        return answer;
    }

    public static boolean checkInput(List<Integer> pobi, List<Integer> crong){
        if (pobi.get(0) <= 1 || crong.get(1) >= 400)    // 페이지 범위 초과
            return true;
        if (pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1))     // 같은 면의 페이지가 아님
            return true;
        if (pobi.get(0) % 2 != 1 || crong.get(0) % 2 != 1)      // 왼쪽 페이지가 홀수, 오른쪽 페이지가 짝수가 아님
            return true;

        return false;
    }

    public static int numPlus(int num){
        int sum = 0;

        sum += num/100;     // 100의 자리
        num %= 100;
        sum += num/10;      // 10의 자리
        num %= 10;
        sum += num;         // 1의 자리

        return sum;
    }

    public static int numMultiple(int num){
        int a,b,c, sum = 0;

        c = num % 10;       // 1의 자리
        if(num>=10)         // 10의 자리
            b = (num/10) % 10;
        else
            b = 1;
        if(num>=100)      // 100의 자리
            a = num/100;
        else
            a = 1;
        sum = a*b*c;    // 곱

        return sum;
    }
    public static int maxNumOfTwoMethod(Integer num){
        return Math.max(numPlus(num),numMultiple(num));
    }
//    public static void main(String[] args) {
//        System.out.println(maxNumOfTwoMethod(125));
//    }

}
