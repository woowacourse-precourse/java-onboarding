package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;

        // 예외 상황
        if(pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1
            || pobi.get(0) % 2 != 1 || crong.get(0) % 2 != 1
        ) return answer;

        int pobi_max = -1;
        int crong_max = -1;

        for(int i = 0; i < 2; i++){
            pobi_max = check(i, pobi, pobi_max);
            crong_max = check(i, crong, crong_max);
        }

        if(pobi_max > crong_max) answer = 1;
        else if (pobi_max == crong_max) answer = 0;
        else if (crong_max > pobi_max) answer = 2;

        return answer;
    }

    private static int check(int n, List<Integer> list, int now_max) {
        String[] num = Integer.toString(list.get(n)).split("");

        int sum = 0;
        int multi = 1;

        for(int i =0; i < num.length; i++){
            sum += Integer.parseInt(num[i]);
            multi *= Integer.parseInt(num[i]);
        }

        int cal_max = Math.max(sum, multi);

        return Math.max(cal_max, now_max);
    }


}