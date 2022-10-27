package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        my_score pobi_score = new my_score(pobi.get(0), pobi.get(1));
        my_score crong_score = new my_score(crong.get(0), crong.get(1));

        if(!pobi_score.is_valid_input() || !crong_score.is_valid_input())
            return -1;
        if(pobi_score.final_score == crong_score.final_score)
            answer = 0;
        if(pobi_score.final_score > crong_score.final_score)
            answer = 1;
        if(pobi_score.final_score < crong_score.final_score)
            answer = 2;

        return answer;
    }

    public static class my_score
    {
        int final_score;
        int left_page;
        int right_page;

        my_score(int page1, int page2)
        {
            left_page = page1;
            right_page = page2;
            final_score = get_final_score(page1, page2);
        }
        int get_final_score(int page1, int page2)
        {
            int score = -1;
            if(get_score(page1) >= get_score(page2))
                score = get_score(page1);
            if(get_score(page1) < get_score(page2))
                score = get_score(page2);
            return score;
        }
        int get_score(int page)
        {
            int score = -1;
            int add_score = 0;
            int multiply_score = 1;
            int temp_page = page;

            while(true)
            {
                if(temp_page == 0)
                    break;
                add_score = add_score + (temp_page % 10);
                temp_page = temp_page / 10;
            }
            temp_page = page;

            while(true)
            {
                if(temp_page == 0)
                    break;
                multiply_score = multiply_score * (temp_page % 10);
                temp_page = temp_page / 10;
            }
            if(add_score >= multiply_score)
                score = add_score;
            if(add_score < multiply_score)
                score = multiply_score;
            return score;
        }
        public boolean is_valid_input()
        {
            if(left_page < 3 || left_page > 397)
                return false;
            if(right_page < 4 || right_page > 398)
                return false;
            if(left_page % 2 == 0 || right_page % 2 != 0)
                return false;
            if(left_page + 1 != right_page)
                return false;
            return true;
        }
    }
}

