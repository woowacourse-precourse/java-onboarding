package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public boolean data_require(List<Integer> score_list){
        int left = score_list.get(0);
        int right = score_list.get(1);

        return left + 1 == right;
    }

    public int winner(int pobi_score, int crong_score){
        if(pobi_score > crong_score) return 1;
        else if(pobi_score < crong_score) return 2;
        else return 0;
    }

    public int compare_score(List<Integer> score_list){
        int max = 0;
        for(int i = 0; i < score_list.size(); i++){
            int score = make_score(score_list.get(i));
            if(score > max){
                max = score;
            }
        }
        return max;
    }

    public int make_score(int page_num){
        int sum = 0;
        int mul = 1;
        for(; page_num > 0; page_num /= 10){
            int num = page_num % 10;
            sum += num;
            mul *= num;
        }
        if (sum > mul){
            return sum;
        }
        else{
            return mul;
        }
    }
}