package onboarding;

import java.util.List;


class Problem1 {

    public static int user_max(int left, int right){

        int left_val;
        int left_plus;
        int left_multi;
        int left_max;

        int right_val;
        int right_plus;
        int right_multi;
        int right_max;

        left_val = left;
        left_plus = 0;
        left_multi = 1;
        left_max = 0;

        right_val = right;
        right_plus = 0;
        right_multi = 1;
        right_max = 0;
        while(left_val > 0){
            left_plus += left_val % 10;
            left_multi *= left_val % 10;
            left_val = left_val/10;
        }
        if (left_plus > left_multi)
            left_max = left_plus;
        else
            left_max = left_multi;

        while(right_val > 0){
            right_plus += right_val % 10;
            right_multi *= right_val % 10;
            right_val = right_val/10;
        }
        if (right_plus > right_multi)
            right_max = right_plus;
        else
            right_max = right_multi;

        if (left_max > right_max)
            return left_max;
        else
            return right_max;
    }


    public static int is_true(int left, int right){

        if(left < 1 || left > 399)
            return -1;
        else if(right < 2 || right > 400)
            return -1;
        else if(left % 2 == 0)
            return -1;
        else if(left+1 != right)
            return -1;
        else
            return 0;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobi_max;
        int crong_max;

        int pobi_left;
        int pobi_right;
        int crong_left;
        int crong_right;

        pobi_left = pobi.get(0);
        pobi_right = pobi.get(1);

        crong_left = crong.get(0);
        crong_right = crong.get(1);

        answer = is_true(pobi_left, pobi_right);
        if(answer == -1)
            return answer;

        answer = is_true(crong_left, crong_right);
        if(answer == -1)
            return answer;

        pobi_max = user_max(pobi_left,pobi_right);
        crong_max = user_max(crong_left, crong_right);

        if (pobi_max > crong_max)
            answer = 1;
        else if(pobi_max < crong_max)
            answer = 2;
        else
            answer = 0;

        return answer;
    }
}