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
        //자리수 곱 점수
        Integer pobiLeftProScore = PageProScore(pobi.get(0));
        //더 높은 점수
        Integer pobiLeftScore = PageScore(pobiLeftSumScore, pobiLeftProScore);

        //우측 페이지 체크
        //자리수 합 점수
        Integer pobiRightSumScore = PageSumScore(pobi.get(1));
        //자리수 곱 점수
        Integer pobiRightProScore = PageProScore(pobi.get(1));
        //더 높은 점수
        Integer pobiRightScore = PageScore(pobiRightSumScore, pobiRightProScore);
        //포비 최종 점수 구하기
        Integer pobiScore = PageScore(pobiLeftScore, pobiRightScore);

        //크롱
        //왼쪽 페이지
        //자리수 합 점수
        Integer crongLeftSumScore = PageSumScore(crong.get(0));
        //자리수 곱 점수
        Integer crongLeftProScore = PageProScore(crong.get(0));
        //더 높은 점수
        Integer crongLeftScore = PageScore(crongLeftSumScore, crongLeftProScore);

        //우측 페이지 체크
        //자리수 합 점수
        Integer crongRightSumScore = PageSumScore(crong.get(1));
        //자리수 곱 점수
        Integer crongRightProScore = PageProScore(crong.get(1));
        //더 높은 점수
        Integer crongRightScore = PageScore(crongRightSumScore, crongRightProScore);
        //포비 최종 점수 구하기
        Integer crongScore = PageScore(crongLeftScore, crongRightScore);

        //정답 출력
        if (crongScore > pobiScore) {
            return 2;
        }
        if (crongScore < pobiScore) {
            return 1;
        }
        if (crongScore == pobiScore) {
            return 0;
        }

        return answer;
    }

    public static Boolean CheckException(List<Integer> Page){
        if (Page.get(0) + 1 != Page.get(1)) {
            return true;
        }
        if (Page.get(0) == 399 || Page.get(0) == 1) {
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

    public static Integer PageProScore(Integer score) {
        //페이지 체크
        int pro = 1;
        String Page = score.toString();
        for(int i = 0; i < Page.length(); i++){
            pro *= Integer.parseInt(Page.substring(i, i+1));
        }
        return pro;
    }

    public static Integer PageScore(Integer score1, Integer score2) {
        if (score1 >= score2) {
            return score1;
        }
        if (score2 > score1) {
            return score2;
        }
        return 0;
    }
}