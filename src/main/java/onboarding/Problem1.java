package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (pobi.size() != 2 || crong.size() != 2) {
            return -1;
        }

        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);

        if(pobiRight-pobiLeft!=1||crongRight-crongLeft!=1) return -1;

        if(pobiLeft<1||pobiLeft>400) return -1;
        else if(pobiRight<1||pobiRight>400) return -1;
        else if(crongLeft<1||crongLeft>400) return -1;
        else if(crongRight<1||crongRight>400) return -1;


        int maxPobi = 0;
        int maxCrong = 0;
        for (int i = 0; i < pobi.size(); i++) {
            maxPobi=Math.max(maxPobi,getReturn(pobi.get(i)));

        }

        for (int i = 0; i < crong.size(); i++) {
            maxCrong=Math.max(maxCrong,getReturn(crong.get(i)));

        }

        if(maxPobi>maxCrong) return 1;
        else if(maxPobi<maxCrong) return 2;
        else return 0;



    }

    private static int getReturn(Integer num) {
        int sum = 0;
        int multiply = 1;
        List<Integer> list = new ArrayList<>();

        while (num!=0) {
            list.add(num % 10);
            num /= 10;
        }

        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
            multiply *= list.get(i);
        }

        if(sum>multiply)return sum;
        else return multiply;
    }
}