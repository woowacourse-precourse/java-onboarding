package onboarding;

import javax.naming.LinkException;
import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobi_sum = 0;
        int crong_sum = 0;
        int pobi_mul = 1;
        int crong_mul = 1;
        int pobi_max = 0;
        int crong_max = 0;


        List<Integer> scoreArr;
        scoreArr = new ArrayList<>();

        // pobi와 crong의 왼쪽과 오른쪽 페이지의 차이가 1이상이면 -1
        if((Math.abs(pobi.get(0) - pobi.get(1))>1 ||(Math.abs(crong.get(0) - crong.get(1)) > 1))) {
            answer = -1;
        } else {
            for (Integer score1 :pobi) {
                while (score1 != 0) {
                    pobi_sum += score1 % 10;
                    pobi_mul *= score1 % 10;
                    pobi_sum /= 10;
                    pobi_mul /= 10;
                }
                pobi_max = Math.max(pobi_sum, pobi_mul);
                scoreArr.add(pobi_max);
            }
            for (Integer score2:crong) {
                while (score2 != 0) {
                    crong_sum += score2 % 10;
                    crong_mul *= score2 % 10;
                    crong_sum /= 10;
                    crong_mul /= 10;
                }
                crong_max = Math.max(crong_sum, crong_mul);
                scoreArr.add(crong_max);
            }

            if (scoreArr.get(0) > scoreArr.get(1)) {
                answer = 1;
            } else if (scoreArr.get(0) < scoreArr.get(1)) {
                answer = 2;
            } else {
                answer = 0;
            }

        }


        return answer;
    }
}