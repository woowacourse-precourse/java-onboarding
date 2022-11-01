package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int sum = 0;
        int pobi_left = pobi.get(0), pobi_right = pobi.get(1), crong_left = crong.get(0), crong_right = crong.get(1);

        int[] pobi_scores = new int[4];
        int[] crong_scores = new int[4];

        pobi_scores[0] = sum(pobi_left);
        pobi_scores[1] = sum(pobi_right);
        pobi_scores[2] = multiple(pobi_left);
        pobi_scores[3] = multiple(pobi_right);

        crong_scores[0] = sum(crong_left);
        crong_scores[1] = sum(crong_right);
        crong_scores[2] = multiple(crong_left);
        crong_scores[3] = multiple(crong_right);

        int crong_max = crong_scores[0];
        int pobi_max = pobi_scores[0];

        for(int i = 1; i <= 3; i++){
            if(crong_max < crong_scores[i]){
                crong_max = crong_scores[i];
            }
        }

        for(int i = 1; i <= 3; i++){
            if(pobi_max < pobi_scores[i]){
                pobi_max = pobi_scores[i];
            }
        }

        if(crong_max > pobi_max) {
            answer = 2;
        } else if (crong_max < pobi_max) {
            answer = 1;
        } else {
            answer = 0;
        }

        if(crong_right - crong_left != 1 || pobi_right - pobi_left != 1)
            answer = -1;

        return answer;
    }

    public static int sum(int page){
        int total_sum = 0;

        while(page > 0){
            total_sum += page % 10;
            page /= 10;
        }
        return total_sum;
    }

    public static int multiple(int page){
        int total_multiple = 1;

        while(page > 0){
            total_multiple *= page%10;
            page /= 10;
        }
        return total_multiple;
    }
}