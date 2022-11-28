package onboarding;

import java.util.*;

class Problem1 {
    public static int get_sum(int num){
        return get_digitList(num).stream().mapToInt(Integer::intValue).sum();
    }
    public static int get_prod(int num) {
        return get_digitList(num).stream().reduce(1,(a,b) -> a*b);
    }
 
    public static int compare_max(List<Integer> digit_ls) {
        int num;
        int max=0;
        for(int i=0; i<2; i++){
            num=Math.max(get_sum(digit_ls.get(i)),get_prod(digit_ls.get(i)));
            if(num>max){
                max=num;
            }
        }

        return max;
    }
    public static List<Integer> get_digitList(int num){
        List<Integer> digitList=new ArrayList<>();

        int hund_d=num/100;
        int ten_d=(num%100)/10;
        int one_d=num%10;


        return Arrays.asList(hund_d,ten_d,one_d);



    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int Max_p,Max_c;
        if(1!=(pobi.get(1)-pobi.get(0))) return -1; if(1!=(crong.get(1))-crong.get(0)) return -1;
        Max_p=compare_max(pobi);
        Max_c = compare_max(crong);
        if (Max_p > Max_c) return 1;
        return  0;
       // return answer;
    }
}
