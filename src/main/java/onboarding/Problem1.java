package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(!check_input(pobi) || !check_input(crong)) return -1;

        int pobi_sumMax = Integer.max(sum_digit(pobi.get(0)), sum_digit(pobi.get(1)));
        int pobi_multMax = Integer.max(mult_digit(pobi.get(0)), mult_digit(pobi.get(1)));
        int pobi_max = Integer.max(pobi_sumMax, pobi_multMax);

        int crong_sumMax = Integer.max(sum_digit(crong.get(0)), sum_digit(crong.get(1)));
        int crong_multMax = Integer.max(mult_digit(crong.get(0)), mult_digit(crong.get(1)));
        int crong_max = Integer.max(crong_sumMax, crong_multMax);

        answer = pobi_max == crong_max ? 0 : pobi_max > crong_max ? 1 : 2;

        return answer;
    }
    // 주어진 입력이 올바른 지를 검사
    private static boolean check_input(List<Integer> list){
        boolean result = false;
        // 두 페이지의 홀수, 짝수 검사
        if(list.get(0) % 2 == 1 && list.get(1) % 2 == 0){
            // 두 페이지가 홀수, 짝수이고 left page = right page + 1 인 것까지 만족해야 한다.
            result = (list.get(0) + 1) == list.get(1);
        }

        return result;
    }

    // 주어진 숫자의 각 자리 수를 더하여 반환
    private static int sum_digit(int value){
        int temp, sum = 0;

        do{
            temp = value % 10;
            sum += temp;
            value /= 10;
        } while(value != 0);

        return sum;
    }

    // 주어진 숫자의 각 자리 수를 곱하여 반환
    private static int mult_digit(int value){
        int temp, mult = 1;

        do{
            temp = value % 10;
            mult *= temp;
            value /= 10;
        } while(value != 0);

        return mult;
    }


    public static void main(String[] args) {
        List<Integer> pobi = List.of(99, 102);
        List<Integer> crong = List.of(131, 132);

        System.out.println(solution(pobi, crong));
    }
}