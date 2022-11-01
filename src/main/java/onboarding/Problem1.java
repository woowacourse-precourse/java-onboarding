package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isValid(pobi) && isValid(crong)){
            return referee(getPlayerScore(pobi), getPlayerScore(crong));
        }
        return -1;
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

        int leftPageScore = getPageScore(leftPage);
        int rightPageScore = getPageScore(rightPage);

        return Integer.max(leftPageScore, rightPageScore);
    }

    private static boolean isValid(List<Integer> pageArray){
        Integer leftPage = pageArray.get(0);
        Integer rightPage = pageArray.get(1);

        if (leftPage % 2 == 0) return false;
        else if (rightPage % 2 != 0) return false;
        else if (leftPage >= rightPage) return false;
        else if (rightPage - leftPage != 1) return false;

        return true;
    }

    private static int referee(int player1Score, int player2Score){
        if (player1Score > player2Score) return 1;
        else if (player1Score < player2Score) return 2;
        return 0;
    }

}