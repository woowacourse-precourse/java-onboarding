package onboarding;

import java.util.List;

class Problem1 {

    //해당 페이지에서 최댓값 구하는 메서드
    public static int findPageMax(int x) {
        int result = 0;
        if (x / 100 == 0) { //두자리수일 때
            result = Math.max(x%100/10 + x%10, (x%100/10) * (x%10));
        }
        else {
            result = Math.max(x/100 + x%100/10 + x%10, (x/100) * (x%100/10) * (x%10));
        }
        return result;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //예외사항인지 아닌지 판단
        //예외사항인 경우
        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) {
            answer = -1;
        }
        //예외사항이 아닌 경우
        else {
            int pobi_final_max = Math.max(findPageMax(pobi.get(0)), findPageMax(pobi.get(1)));
            int crong_final_max = Math.max(findPageMax(crong.get(0)), findPageMax(crong.get(1)));

            //pobi와 crong 최종 값 비교
            if (pobi_final_max > crong_final_max) {
                answer = 1;
            }
            if (crong_final_max > pobi_final_max) {
                answer = 2;
            }
            if (pobi_final_max == crong_final_max) {
                answer = 0;
            }
        }

        return answer;
    }
}