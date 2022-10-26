package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //예외처리
        if (CheckException(pobi)) {
            return -1;
        }
        if (CheckException(crong)) {
            return -1;
        }

        //포비
        //왼쪽 페이지
        //자리수 합 점수
        Integer pobiLeftSumScore = PageSumScore(pobi.get(0));

        //우측 페이지 체크
        //자리수 합 점수
        Integer pobiRightSumScore = PageSumScore(pobi.get(1));

        //크롱
        //왼쪽 페이지
        //자리수 합 점수
        Integer crongLeftSumScore = PageSumScore(crong.get(0));

        //우측 페이지 체크
        //자리수 합 점수
        Integer crongRightSumScore = PageSumScore(crong.get(1));

        return answer;
    }

    public static Boolean CheckException(List<Integer> Page){
        if (Page.get(0) + 1 != Page.get(1)) {
            return true;
        }
        return false;
    }

    public static Integer PageSumScore(Integer score) {
        //페이지 체크
        int sum = 0;
        String Page = score.toString();
        for(int i = 0; i < Page.length(); i++){
            sum += Integer.parseInt(Page.substring(i, i+1));
        }
        return sum;
    }


}