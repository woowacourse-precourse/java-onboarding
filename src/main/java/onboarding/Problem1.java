package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiScore = maxScore(pobi.get(0), pobi.get(1));
        int crongScore = maxScore(crong.get(0), crong.get(1));

        if (pobiScore == -1 || crongScore == -1)
            answer = -1;
        else if (pobiScore == crongScore)
            answer = 0;
        else if (pobiScore > crongScore)
            answer = 1;
        else
            answer = 2;    // 점수 비교

        return answer;
    }
    static int maxScore(int leftPage, int rightPage) { //최고 점수구하기
        if (!validatePage(leftPage, rightPage))
            return -1;
        return Math.max(getScore(leftPage), getScore(rightPage));
    }
    static int getScore(int page) {
        int plusScore = 0; //더하기용
        int multipleScore = 1; //곱셉용

        while (page > 0) {
            plusScore += page % 10;
            multipleScore *= page % 10;
            page /= 10;
        }
        return Math.max(plusScore, multipleScore);
    }
    static boolean validatePage(int leftPage, int rightPage) {  //페이지 확인
        return leftPage % 2 == 1 && rightPage % 2 == 0 && leftPage + 1 == rightPage;
    }
}