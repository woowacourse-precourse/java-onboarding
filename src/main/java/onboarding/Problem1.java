package onboarding;

import java.util.List;

/*
 * 흠..
 */
class Problem1 {

    public static boolean check_list(List<Integer> list){
        return (list.get(0) % 2 != 1) ||
                (list.get(1) - list.get(0) != 1) ||
                (list.get(1) > 400 || list.get(0) < 1) ||
                (list.size() != 2);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobi_win = 1;
        int crong_win = 2;
        int draw = 0;
        int except = -1;

        int answer;

        if(check_list(pobi) || check_list(crong)){
            return answer = except;
        }

        int pobi_cal = Math.max(sum_or_mul(pobi.get(0)), sum_or_mul(pobi.get(1)));
        int crong_cal = Math.max(sum_or_mul(crong.get(0)), sum_or_mul(crong.get(1)));

        System.out.println("포비승" + pobi_cal);
        System.out.println("크롱승" + crong_cal);

        if (pobi_cal == crong_cal){
            answer = draw;
        }else{
            answer = (pobi_cal > crong_cal) ? pobi_win : crong_win;
        }
        return answer;
    }

    /*
    계산 해주는 함수
     */
    static int sum_or_mul(int n){
        int cal;
        int sum = 0;
        int mul = 1;
        while(n != 0){
            sum += n % 10;
            mul  *= n % 10;
            n /= 10;
        }
        System.out.print(sum);
        System.out.print(mul);
        cal = Math.max(sum, mul);
        return cal;
    }
}