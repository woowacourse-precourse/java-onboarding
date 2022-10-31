package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i<=number;i++){
            for(int n:makeList(i)){
                if((n==3)|(n==6)|(n==9)){
                    answer += 1;
                }
            }
        }


        return answer;
    }

    private static List<Integer> makeList(Integer num){
        List<Integer> li = new ArrayList<Integer>();
        List<Integer> digit = new ArrayList<Integer>();
        digit.add(0,10000);
        digit.add(1,1000);
        digit.add(2,100);
        digit.add(3,10);
        Integer number = 0;
        int i = 0;
        boolean check = false;
        for(int n = 0; n<4; n ++) {
            number = num / digit.get(n);
            if(number != 0 ){
                check = true;
            }
            if (check) {
                li.add(i, number);
                num = num - number * digit.get(n);
                i++;
            }
        }
        li.add(i,num);
        return li;
    }
}
