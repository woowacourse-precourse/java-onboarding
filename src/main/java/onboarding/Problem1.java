package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static List<Integer> numList (int number){
        List<Integer> numberList = new ArrayList<>();
        while(number!=0) {
            numberList.add(number%10);
            number/=10;
        }
        return numberList;
    }

    public static int sum(List<Integer> numberlist){
        int result = 0;
        for(int num : numberlist) {
            result += num;
        }
        return result;
    }

    public static int product(List<Integer> numberlist){
        int result = 1;
        for(int num : numberlist) {
            result *= num;
        }
        return result;
    }

    public static int findMax(int left,int right){
        List<Integer> scores = new ArrayList<>();
        scores.add(sum(numList(left)));
        scores.add(product(numList(left)));
        scores.add(sum(numList(right)));
        scores.add(product(numList(right)));
        int max = Collections.max(scores);
        return max;
    }

    public static int judge(int pobi,int crong){
        if(pobi>crong){
            return 1;
        }else if (pobi<crong){
            return 2;
        }
        return 0;
    }

    public static int validate(List<Integer> pobi, List<Integer> crong){
        if(pobi.get(1)-pobi.get(0)!=1 || crong.get(1)-crong.get(0)!=1)
            return -1;
        else if(pobi.get(1)==400||pobi.get(0)==1||crong.get(1)==400||crong.get(0)==1)
            return -1;
        return 0;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(validate(pobi,crong)==-1)
            return -1;
        int pobiMax = findMax(pobi.get(0),pobi.get(1));
        int crongMax = findMax(crong.get(0),crong.get(1));
        int answer = judge(pobiMax,crongMax);
        return answer;
    }
}