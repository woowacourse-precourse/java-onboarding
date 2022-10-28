package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;
//      시작면이나 마지막 면이 나오면 예외사항
        if (pobi.get(0) == 1 || pobi.get(0) == 399 || crong.get(0) == 1 || crong.get(0) == 399) {
            answer = -1;
        } else {
            if ((pobi.get(0) + 1 == pobi.get(1)) && (crong.get(0) + 1 == crong.get(1))) {
                someone(pobi);
                someone(crong);
//      5.점수를 비교해 가장 높은사람을 정하는 메서드
                if (someone(pobi) > someone(crong)) {
                    answer = 1;
                } else if (someone(pobi) < someone(crong)) {
                    answer = 2;
                } else {
                    answer = 0;
                }
            } else {
                answer = -1;
            }
        }
//      페이지 수가 맞지 않으면 예외사항
        return answer;
    }



}