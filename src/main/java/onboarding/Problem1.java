package onboarding;

import java.util.List;

/*
 * 흠..
 */
class Problem1 {

    //예외
    private static boolean check_list(List<Integer> list){
        return (list.get(0) % 2 != 1) ||
                (list.get(1) % 2 != 0) ||
                (list.get(1) - list.get(0) != 1) ||
                (list.get(1) > 400 || list.get(0) < 1);
    }

    //결과값 반환해주는 메서드
    private static int print_number(int pobi, int crong){
        int answer = 0;
        if(pobi == crong) return answer;
        return answer = (pobi > crong) ? 1 : 2;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int except = -1;

        if(check_list(pobi) || check_list(crong)){
            return except;
        }

        int pobi_cal = Math.max(sum_or_mul(pobi.get(0)), sum_or_mul(pobi.get(1)));
        int crong_cal = Math.max(sum_or_mul(crong.get(0)), sum_or_mul(crong.get(1)));
//        System.out.println("포비승 : " + pobi_cal);
//        System.out.println("크롱승 : " + crong_cal);
        return print_number(pobi_cal,crong_cal);
    }

    /*
    계산 해주는 함수
     */
    private static int sum_or_mul(int page){
        int cal;
        int sum = 0;
        int mul = 1;
        while(page != 0){
            sum += page % 10;
            mul  *= page % 10;
            page /= 10;
        }
        System.out.print(sum);
        System.out.print(mul);
        cal = Math.max(sum, mul);
        return cal;
    }
}