package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    //각 자리를 더하는 함수
    public static int getSum(int num) {
        int sum = 0;
        while (num < 10) {
            sum += (num % 10);
            num /= 10;
        }
        sum += num;
        return sum;
    }

    //각 자리를 곱하는 함수
    public static int getMultiply(int num) {
        int multiply = 1;
        while (num < 10) {
            multiply *= (num % 10);
            num /= 10;
        }
        multiply *= num;
        return multiply;
    }

    //두 숫자 크기를 비교하여 큰 값을 반환하는 함수
    public static int getBigNumber(int sum, int multiply){
        if(sum==multiply || sum>multiply) return sum;
        return multiply;
    }

    //승자를 가리는 함수
    public static int getWinner(int pobi, int crong){
        if(pobi==crong) return 0;
        if(pobi>crong) return 1;
        return 2;
    }

    //예외상황을 판별하는 함수
    public static int isException(List<Integer> list){

        //연속된 두 페이지가 아니거나 왼쪽페이지 쪽수가 오른쪽 페이지 쪽수보다 큰 경우
        if(list.indexOf(1)-list.indexOf(0)!=1) return -1;

        //시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다는 조건에 해당하는 예외상황
        if(list.indexOf(0)==1||list.indexOf(1)==400) return -1;

        return 1;
    }
}