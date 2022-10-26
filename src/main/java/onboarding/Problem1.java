package onboarding;

import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(pobi.get(1)!=pobi.get(0)+1||crong.get(1)!=crong.get(0)+1){

            return -1;
        }
        System.out.println(CheckBiggerOne(pobi));
        System.out.println(CheckBiggerOne(crong));
        if(CheckBiggerOne(pobi)==CheckBiggerOne(crong)){
            return 0;
        }
        int result =Math.max(CheckBiggerOne(pobi),CheckBiggerOne(crong));
        if(result == CheckBiggerOne(pobi)){
            return 1;
        }else {
            return 2;
        }
    }

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
    public static  int plusResult(int num){
        int result = 0;
        while ((num/10)>0){
            result += (num%10);
            num = num/10;
        }
        return result;
    }

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