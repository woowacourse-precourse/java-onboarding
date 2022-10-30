package onboarding;

import java.util.List;

class Problem1 {

    private static boolean exception(List<Integer> user){
        if(user.get(0) >= user.get(1)) return false; // 왼쪽 페이지가 오른쪽 페이지 보다 큰 경우
        if(user.get(0) % 2 != 1) return false; // 왼쪽 페이지가 홀수가 아닌 경우
        if(user.get(1) % 2 != 0) return false; // 오른쪽 페이지가 짝수가 아닌 경우
        if(user.get(0) + 1 != user.get(1)) return false; // 연속된 페이지가 아닌 경우

        return true;
    }

    private static Integer score(Integer page){
        Integer plus = 0, mul = 1;

        while(page > 0){
            plus += page % 10;
            mul *= page %10;
            page /= 10;
        }

        if(plus > mul) return plus;
        else return mul;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        // 예외사항
        if(!exception(pobi)) return -1;
        if(!exception(crong)) return -1;

        Integer score_pobi_L, score_pobi_R, score_pobi;
        score_pobi_L = score(pobi.get(0));
        score_pobi_R = score(pobi.get(1));

        if(score_pobi_L < score_pobi_R) score_pobi = score_pobi_R;
        else score_pobi = score_pobi_L;

        Integer score_crong_L, score_crong_R, score_crong;
        score_crong_L = score(crong.get(0));
        score_crong_R = score(crong.get(1));

        if(score_crong_L < score_crong_R) score_crong = score_crong_R;
        else score_crong = score_crong_L;

        if(score_pobi > score_crong) return 1; // 포비가 이긴 경우
        else if(score_pobi < score_crong) return 2; // 크롱이 이긴 경우
        else return 0; // 무승부인 경우
    }
}