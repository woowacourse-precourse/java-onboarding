package onboarding;

import java.util.List;

class Problem1 {

    static int get_multiplication_score(int page){ // 페이지 번호의 각 자리 숫자를 모두 더한 값 구하기
        int answer=1;
        String page_str=Integer.toString(page);
        for(int i=0; i<page_str.length(); i++){
            answer*=page_str.charAt(i)-'0';
        }
        return answer;
    }

    static int get_addition_score(int page){ // 페이지 번호의 각 자리 숫자를 모두 곱한 값 구하기
        int answer=0;
        String page_str=Integer.toString(page);
        for(int i=0; i<page_str.length(); i++){
            answer+=page_str.charAt(i)-'0';
        }
        return answer;
    }

    static int get_final_score(List<Integer> pages){ // 최종 점수 구하기
        int left_score=get_addition_score(pages.get(0))>get_multiplication_score(pages.get(0))?get_addition_score(pages.get(0)):get_multiplication_score(pages.get(0));
        int right_score=get_addition_score(pages.get(1))>get_multiplication_score(pages.get(1))?get_addition_score(pages.get(1)):get_multiplication_score(pages.get(1));
        return left_score>right_score?left_score:right_score;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!(pobi.get(0)+1== pobi.get(1) && crong.get(0)+1==crong.get(1))) // 예외사항
            return -1;
        int pobi_score=get_final_score(pobi); // pobi의 최종 점수
        int crong_score=get_final_score(crong); // crong의 최종 점수
        if(pobi_score>crong_score) return 1; // pobi가 이긴 경우
        else if (pobi_score<crong_score) return 2; //crong이 이긴 경우
        return 0; // 무승부인 경우
    }
}