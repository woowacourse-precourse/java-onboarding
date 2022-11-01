package onboarding;

import java.util.*;


class Problem1 {
    public static int get_sum(int num){
        return get_digitList(num).stream().mapToInt(Integer::intValue).sum();
    } //리스트의 모든원소들의 합을 반환하는 메서드
    public static int get_prod(int num) {
        return get_digitList(num).stream().reduce(1,(a,b) -> a*b);

    }//리스트의 모든원소들의 곱을 반환하는 메서드
    public static int get_max(int num1, int num2) {
        return num1 > num2 ? num1 : num2;
    }//두 개의 정수 원소를 받아 둘 중 큰값을 반환하는 메서드
    public static int compare_max(List<Integer> digit_ls) {
        int num=0,max=0;
        for(int i=0; i<2; i++){
            num=get_max(get_sum(digit_ls.get(i)),get_prod(digit_ls.get(i)));
            if(num>max){
                max=num;
            }
        }
        return max;
    }//각 자릿수가 담긴 리스트의 원소들의 합과 곱을 비교하여 큰 것을 반환하는 메서드
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
    }//각 자릿수들을 구하여 리스트에 담는 메서드.

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int Max_p=0,Max_c = 0;// hund_d= 백의자리, ten_d 십의자리, units 일의 자리
        if(1!=(pobi.get(1)-pobi.get(0))) return -1; if(1!=(crong.get(1))-crong.get(0)) return -1;
        Max_p=compare_max(pobi);
        Max_c = compare_max(crong);
        int answer = (Max_p > Max_c) ? 1 : 0;
        return answer;
    }
}