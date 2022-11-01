package onboarding;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Problem1 {
    static boolean ecept(List<Integer>list){
        if(list.size() >2) {
            return false;
        }if(list.get(0) == null || list.get(1) == null) {
            return false;
        }if(list.get(1) - list.get(0) != 1 ){
            return false;
        }if(list.get(0) <= 1 || list.get(1) >= 400){
            return false;
        }if(list.get(0) % 2 == 0 || list.get(1) % 2 == 1 ){
            return false;
        }
        return true;
    }
    static int sum(int number){
        int sum = 0;
        while(number >0){
            sum += number%10;
            number = number/10;
        }
        return sum;
    }

    static int mul(int num){
        int mul = 1;
        while(num > 0){
            mul *= num%10;
            num = num/10;
        }
        return mul;
    }
    static int score(List<Integer> arr)
    {
        int First_SumPage = sum(arr.get(0));
        int First_MulPage = mul(arr.get(0));

        int First_max = Integer.max(First_SumPage,First_MulPage);

        int Second_SumPage = sum(arr.get(1));
        int Second_MulPage = mul(arr.get(1));

        int Second_max = Integer.max(Second_SumPage,Second_MulPage);

        int MaxScore= Integer.max(First_max,Second_max);
        return MaxScore;
    }

        public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;

        if(!ecept(pobi) || !ecept((crong)))
        {
            return -1;
        }
        if(score(pobi) == score(crong))
        {
            answer = 0;
        }
        else if (score(pobi) >score(crong))
        {
            answer =1;
        }
        else if (score(pobi) <score(crong))
        {
            answer =2;
        }
        return answer;
    }
}