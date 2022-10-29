package onboarding;

import java.util.Collections;
import java.util.List;

//페이지의 각 자리 숫자를 모두 더하는 함수를 만든다.
//페이지의 각 자리 숫자를 모두 곱하는 숫자를 만든다.
//그중 가장 큰 수를 본인의 점수로 만든다.
//포비와 크롱의 점수를 비교해서, 무승부라면 0, 포비의 승리는 1, 크롱의 승리는 2 예외는 -1로 처리한다.
//예외에는 페이지의 맨처음이 펼처지거나, 마지막이 펼처지는 경우를 포함한다.
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        return 0;
    }
    //책의 각 자리 수를 곱하는 함수 구현
    public static int multyplyResult(int num){
        int result = 1;
        while ((num)%10>0){
            result *=(num%10);
            if(num>10){
            num = num / 10;
            }else {
                num = 0;
            }
        }

        return result;
    }
//책의 각 자리 수를 더하는 함수 구현
    public static  int plusResult(int num){
        int result = 0;
        while ((num/10)>0){
            result += (num%10);
            num = num/10;
        }
        return result;
    }
//곱하고 더한 결과값들을 비교해서 제일 큰 수를 리턴한다.
    public static int CheckBiggerOne(List<Integer> numList){

        System.out.println(numList);
        int num1 =multyplyResult(numList.get(0));
        int num2 =multyplyResult(numList.get(1));
        int num3 =plusResult(numList.get(0));
        int num4 =plusResult(numList.get(1));

        List<Integer> resultArray = List.of(num1,num2,num3,num4);
        System.out.println(resultArray);
        int result = Collections.max(resultArray);

        return result;
    }
}