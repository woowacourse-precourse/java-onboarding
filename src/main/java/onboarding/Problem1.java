package onboarding;

import java.util.List;
class Problem1 {
    static int MaxScore(int num)
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
    static int CompareMaxScore(List<Integer> user) {
        int score = 0;

        for (int i = 0; i < 2; i++) {
            if (score < MaxScore(user.get(i)))
                score = MaxScore(user.get(i));
        }
        return score;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobi_score = CompareMaxScore(pobi);
        int crong_score = CompareMaxScore(crong);

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

