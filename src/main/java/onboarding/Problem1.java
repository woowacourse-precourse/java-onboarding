package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        // 0. 전달받은 페이지 정보에 대한 유효성을 검증함 (연속적으로 주어진 페이지 인가?)
        if(!validation(pobi) || !validation(crong)) {
            answer = -1;
            return answer;
        }

        // 1. 포비와 그롱의 점수를 구함
        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        // 2. 두 사람의 점수를 비교하여 승자를 가림
        if(pobiScore > crongScore) answer = 1;
        else if(pobiScore < crongScore) answer = 2;
        else answer = 0;

        return answer;
    }

    // 페이지 정보에 대한 유효성을 검증 (연속적으로 주어진 페이지인가?)
    private static boolean validation(List<Integer> pages) {
        return (pages.get(0)+1 == pages.get(1));
    }

    // 주어진 수의 각 자리수의 합을 구함
    private static int allSum(int pageNum) {
        int sum = 0;
        while(pageNum > 0) {
            sum += pageNum%10;
            pageNum /= 10;
        }
        return sum;
    }

    // 주어진 수의 각 자리수의 곱을 구함
    private static int allMult(int pageNum) {
        int mult = 1;
        while(pageNum > 0) {
            mult *= pageNum%10;
            pageNum /= 10;
        }
        return mult;
    }

    // 주어진 페이지 정보를 바탕으로 해당 사람의 점수를 구함
    private static int getScore(List<Integer> pages) {
        int left = Math.max(allSum(pages.get(0)), allMult(pages.get(1)));  // 왼쪽 페이지의 점수
        int right = Math.max(allSum(pages.get(0)), allMult(pages.get(1))); // 오른쪽 페이지의 점수
        return Math.max(left, right);
    }
}