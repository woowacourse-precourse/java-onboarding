package onboarding;


import java.util.ArrayList;
import java.util.List;



class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(except(pobi)|except(crong)){
            return -1;
        }
        int test = pobi.get(0);
        int pobi_choose = max(makeNum(makeList(pobi.get(0))),makeNum(makeList(pobi.get(1))));
        int crong_choose = max(makeNum(makeList(crong.get(0))),makeNum(makeList(crong.get(1))));
        if(pobi_choose>crong_choose){
            return 1;
        }else if(pobi_choose<crong_choose){
            return 2;
        }
        return 0;
    }
    private static boolean except(List<Integer> li){
        if((li.get(0)%2 != 1) | li.get(1)%2 != 0){
            return true;
        }
        if((li.get(0)<2)|(398<li.get(0))|(li.get(1)<3)|(399<li.get(1))){
            return true;
        }
        if((li.get(1) - li.get(0))!=1){
            return true;
        }
        return false;
    }
    private static List<Integer> makeList(Integer num){
        List<Integer> li = new ArrayList<Integer>();
        List<Integer> digit = new ArrayList<Integer>();
        digit.add(0,100);
        digit.add(1,10);
        Integer number = 0;
        int i = 0;
        boolean check = false;
        for(int n = 0; n<2; n ++) {
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

    private static Integer max(Integer num1, Integer num2){
        if(num1>num2){
            return num1;
        }
        return num2;
    }
    private static Integer makeNum(List<Integer> li){
        Integer multi = 1;
        Integer sum = 0;
        for(int i: li){
            sum += i;
            multi *= i;
        }
        if(multi>sum){
            return multi;
        }
        return sum;
    }
}