package onboarding;

import java.util.List;
class Problem1 {
    static int max_score(int num)
    {
        int page_sum = 0;
        int page_mult = 1;
        int max;

        while (num > 0) {
            page_sum += num % 10;
            page_mult *= num % 10;
            num /= 10;
        }
        max = Math.max(page_sum, page_mult);
        return max;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobi_score = max_score(pobi.get(0));
        int crong_score = max_score(crong.get(0));

        if (pobi_score > crong_score)
            answer = 1;
        else if (crong_score > pobi_score)
            answer = 2;
        else
            answer = 0;

        return answer;
    }

    public static void main(String[] args) {

        List<Integer> pobi = List.of(97, 98);
        List<Integer> crong = List.of(197, 198);
        List<Integer> pobi2 = List.of(131, 132);
        List<Integer> crong2 = List.of(211, 212);
        List<Integer> pobi3 = List.of(99, 102);
        List<Integer> crong3 = List.of(211, 212);


        System.out.println(solution(pobi, crong));
        System.out.println(solution(pobi2, crong3));
        System.out.println(solution(crong2, pobi2));
        System.out.println(solution(pobi3, crong3));
    }


}

