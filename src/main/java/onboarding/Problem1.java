package onboarding;

import java.util.*;


class Problem1 {
    public static int get_sum(int num){
        int hund_d=0; int ten_d=0; int units=0;
        hund_d=num/100;
        ten_d=(num%100)/10;
        units=num%10;
        return hund_d+ten_d+units;
    }
    public static int get_prod(int num) {
        int hund_d = 0;
        int ten_d = 0;
        int units = 0;
        hund_d = num / 100;
        ten_d = (num % 100) / 10;
        units = num % 10;
        return hund_d* ten_d * units;
    }

    public static int get_max(int num1, int num2) {
        return num1 > num2 ? num1 : num2;
    }
    public static int compare_max(List<Integer> ls) {
        int num=0,max=0;
        for(int i=0; i<2; i++){
            num=get_max(get_sum(ls.get(i)),get_prod(ls.get(i)));
            if(num>max){
                max=num;
            }
        }
        return max;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int Max_p=0,Max_c = 0;// hund_d= 백의자리, ten_d 십의자리, units 일의 자리
        if(1!=(pobi.get(1)-pobi.get(0))) return -1; if(1!=(crong.get(1))-crong.get(0)) return -1;
        Max_p=compare_max(pobi);
        Max_c = compare_max(crong);
        int answer = (Max_p > Max_c) ? 1 : 0;
        return answer;
    }
}