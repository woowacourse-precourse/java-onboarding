package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        //예외처리
        if (checkException(pobi)) {
            return -1;
        }
        if (checkException(crong)) {
            return -1;
        }

        //포비
        //왼쪽 페이지
        //자리수 합 점수
        Integer pobiLeftSumScore = pageSumScore(pobi.get(0));
        //자리수 곱 점수
        Integer pobiLeftProScore = pageProScore(pobi.get(0));
        //더 높은 점수
        Integer pobiLeftScore = pageScore(pobiLeftSumScore, pobiLeftProScore);

        //우측 페이지 체크
        //자리수 합 점수
        Integer pobiRightSumScore = pageSumScore(pobi.get(1));
        //자리수 곱 점수
        Integer pobiRightProScore = pageProScore(pobi.get(1));
        //더 높은 점수
        Integer pobiRightScore = pageScore(pobiRightSumScore, pobiRightProScore);
        //포비 최종 점수 구하기
        Integer pobiScore = pageScore(pobiLeftScore, pobiRightScore);

        //크롱
        //왼쪽 페이지
        //자리수 합 점수
        Integer crongLeftSumScore = pageSumScore(crong.get(0));
        //자리수 곱 점수
        Integer crongLeftProScore = pageProScore(crong.get(0));
        //더 높은 점수
        Integer crongLeftScore = pageScore(crongLeftSumScore, crongLeftProScore);

        //우측 페이지 체크
        //자리수 합 점수
        Integer crongRightSumScore = pageSumScore(crong.get(1));
        //자리수 곱 점수
        Integer crongRightProScore = pageProScore(crong.get(1));
        //더 높은 점수
        Integer crongRightScore = pageScore(crongRightSumScore, crongRightProScore);
        //크롱 최종 점수 구하기
        Integer crongScore = pageScore(crongLeftScore, crongRightScore);

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

    public static Boolean checkException(List<Integer> Page){
        if (Page.get(0) + 1 != Page.get(1)) {
            return true;
        }
        if (Page.get(0) == 399 || Page.get(0) == 1) {
            return true;
        }
        return false;
    }

    public static Integer pageSumScore(Integer score) {
        //페이지 체크
        int sum = 0;
        String Page = score.toString();
        for(int i = 0; i < Page.length(); i++){
            sum += Integer.parseInt(Page.substring(i, i+1));
        }
        return sum;
    }

    public static Integer pageProScore(Integer score) {
        //페이지 체크
        int pro = 1;
        String Page = score.toString();
        for(int i = 0; i < Page.length(); i++){
            pro *= Integer.parseInt(Page.substring(i, i+1));
        }
        return pro;
    }

    public static Integer pageScore(Integer score1, Integer score2) {
        if (score1 >= score2) {
            return score1;
        }
        if (score2 > score1) {
            return score2;
        }
        return 0;
    }
}