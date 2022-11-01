package onboarding;

import java.util.List;

class Problem1 {
    private static boolean isErrorPages(List<Integer> pages){

        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        boolean isLeftPage = (leftPage <= 1) || (leftPage >=400) || (leftPage % 2 == 0);
        boolean isRightPage = (rightPage <= 1) || (rightPage >= 400) || (rightPage % 2 == 1);
        boolean isCorrectPages = (rightPage - leftPage != 1) || (leftPage >= rightPage);

        if(isLeftPage || isRightPage || isCorrectPages){
            return true;
        }else{
            return false;
        }
    }

    private static boolean isErrorPages(int[] pages){

        int leftPage = pages[0];
        int rightPage = pages[1];

        boolean isLeftPage = (leftPage <= 1) || (leftPage >=400) || (leftPage % 2 == 0);
        boolean isRightPage = (rightPage <= 1) || (rightPage >= 400) || (rightPage % 2 == 1);
        boolean isCorrectPages = (rightPage - leftPage != 1) || (leftPage >= rightPage);

        if(isLeftPage || isRightPage || isCorrectPages){
            return true;
        }else{
            return false;
        }
    }
    private static int getMaxScore(int page){
        int result;

        int add = 0;
        int mul = 1;

        while (page != 0){
            add += page % 10;
            mul *= page % 10;
            page /= 10;
        }

        result = Math.max(add, mul);

        return result;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (isErrorPages(pobi) || isErrorPages(crong)){
            return -1;
        }else{

            int pobiScore = Math.max(getMaxScore((pobi.get(0))), getMaxScore(pobi.get(1)));
            int crongScore = Math.max(getMaxScore((crong.get(0))), getMaxScore(crong.get(1)));

            if (pobiScore > crongScore){
                return 1;
            } else if (pobiScore < crongScore) {
                return 2;
            } else if (pobiScore == crongScore) {
                return 0;
            }

            return -1;
        }
    }

    public static int solution(int[] pobi, int[] crong){

        if (isErrorPages(pobi) || isErrorPages(crong)){
            return -1;
        }else{

            int pobiScore = Math.max(getMaxScore((pobi[0])), getMaxScore(pobi[1]));
            int crongScore = Math.max(getMaxScore((crong[0])), getMaxScore(crong[1]));

            if (pobiScore > crongScore){
                return 1;
            } else if (pobiScore < crongScore) {
                return 2;
            } else if (pobiScore == crongScore) {
                return 0;
            }

            return -1;
        }
    }

}