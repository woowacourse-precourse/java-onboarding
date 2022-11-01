package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Problem1 {

    private static List<Integer> splitNum(int num){
        List<Integer> numList = new ArrayList<Integer>();
        while(num>0){
            numList.add(num%10);
            num/=10;
        }
        return numList;
    }

    private static int sumNum(List<Integer> number){
        int sum = 0;
        for(int n: number) sum+=n;
        return sum;
    }

    private static int mulNum(List<Integer> number){
        int mul = 1;
        for(int n: number) mul*=n;
        return mul;
    }

    private static int calMaxNum(List<Integer> numbers){
        List<Integer> numList1 = splitNum(numbers.get(0));
        List<Integer> numList2 = splitNum(numbers.get(1));

        List<Integer> calculated = new ArrayList<Integer>();
        calculated.add(sumNum(numList1));
        calculated.add(mulNum(numList1));
        calculated.add(sumNum(numList2));
        calculated.add(mulNum(numList2));

        return Collections.max(calculated);
    }

    private static boolean checkException(List<Integer> numbers){
        if(numbers.size() != 2) return false;
        if(numbers.get(0)<1) return false;
        if(numbers.get(0)%2 != 1) return false;
        if(numbers.get(1) != numbers.get(0)+1) return false;
        if(numbers.get(1)>400) return false;

        return true;
    }


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(checkException(pobi) && checkException(crong)){
            int dis = calMaxNum(pobi) - calMaxNum(crong);

            if(dis > 0) answer = 1;
            else if(dis == 0) answer = 0;
            else if(dis < 0) answer = 2;
        }
        else answer = -1;

        return answer;
    }
}