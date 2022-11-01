package onboarding;

import java.util.*;


class Problem1 {
    public static int get_sum(int num){
        return get_digitList(num).stream().mapToInt(Integer::intValue).sum();
    }
    public static int get_prod(int num) {
        return get_digitList(num).stream().reduce(1,(a,b) -> a*b);
    }
    public static int get_max(int num1, int num2) {
        return num1 > num2 ? num1 : num2;
    }
    public static int compare_max(List<Integer> digit_ls) {

        int num=0,max=0;
        for(int i=0; i<2; i++){
            num=get_max(get_sum(digit_ls.get(i)),get_prod(digit_ls.get(i)));
            if(num>max){
                max=num;
            }
        }

        return max;
    }
    public static List<Integer> get_digitList(int num){
        List<Integer> digitList=new ArrayList<>();
        int hund_d=0;
        int ten_d=0;
        int one_d=0;
        hund_d=num/100;
        ten_d=(num%100)/10;
        one_d=num%10;


        digitList=Arrays.asList(hund_d,ten_d,one_d);

        return digitList;



    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        return answer;
    }
}