package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiScore = getPlayerScore(pobi);
        int crongScore = getPlayerScore(crong);

        if (pobiScore == -1 || crongScore == -1) answer = -1;
        else if (pobiScore > crongScore) answer = 1;
        else if (pobiScore < crongScore) answer = 2;
        else if (pobiScore == crongScore) answer = 0;

        return answer;
    }

    private static int getPageScore(Integer pageNumber){
        String pageNumberString = Integer.toString(pageNumber);
        int sumScore = 0, productScore = 1;
        for (int i = 0; i < pageNumberString.length(); i++){
            sumScore += pageNumberString.charAt(i) - '0';
            productScore *= pageNumberString.charAt(i) - '0';
        }

        return Integer.max(sumScore, productScore);
    }

    private static int getPlayerScore(List<Integer> pageArray){
        Integer leftPage = pageArray.get(0);
        Integer rightPage = pageArray.get(1);

        if (leftPage % 2 == 0) return -1;
        else if (rightPage % 2 != 0) return -1;
        else if (leftPage >= rightPage) return -1;
        else if (rightPage - leftPage != 1) return -1;

        int leftPageScore = getPageScore(leftPage);
        int rightPageScore = getPageScore(rightPage);

        return Integer.max(leftPageScore, rightPageScore);
    }

}