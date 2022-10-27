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

    static int GameResult(int pobi_score, int crong_score) {
        int result = 0;

        if (pobi_score > crong_score)
            result = 1;
        else if (crong_score > pobi_score)
            result = 2;
        else if (crong_score == pobi_score)
            result = 0;
        return result;
    }
    static boolean exception(List<Integer> page) {
        int left_page = page.get(0);
        int right_page = page.get(1);

        if (page.size() != 2)
            return true;
        if (left_page != right_page - 1)
            return true;
        else if (left_page < 1 && 399 < right_page)
            return true;

        return false;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobi_score;
        int crong_score;

        if(exception(pobi) || exception(crong))
            return -1;

        pobi_score = CompareMaxScore(pobi);
        crong_score = CompareMaxScore(crong);
        answer = GameResult(pobi_score, crong_score);

        return answer;
    }
}

