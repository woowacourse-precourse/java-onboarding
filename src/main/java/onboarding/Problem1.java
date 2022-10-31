package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!(checkInput(pobi) && checkInput(crong))){
            return -1;
        }
        int pobiLeftMax = getMaxNumInPage(pobi, 0);
        int pobiRightMax = getMaxNumInPage(pobi, 1);
        int pobiMax = Math.max(pobiLeftMax, pobiRightMax);

        int crongLeftMax = getMaxNumInPage(crong, 0);
        int crongRightMax = getMaxNumInPage(crong, 1);
        int crongMax = Math.max(crongLeftMax, crongRightMax);


        if(pobiMax > crongMax){
            return 1;
        }else if(pobiMax < crongMax){

            return 2;
        }else{
            return 0;
        }
    }

    private static boolean isValid(int pageNum){
        return pageNum > 1 && pageNum < 400;
    }

    private static boolean checkInput(List<Integer> pageList){


        if(pageList.size() != 2 || (pageList.get(0) + 1 != pageList.get(1))){
            return false;
        }

        return isValid(pageList.get(0)) && isValid(pageList.get(1));
    }

    private static int getSum(int pageNum){
        int result = 0;
        while(pageNum > 0){
            result += pageNum%10;
            pageNum /= 10;
        }
        return result;
    }

    private static int getMultiply(int pageNum){
        int result = 1;
        while(pageNum > 0){
            result *= pageNum%10;
            pageNum /= 10;
        }
        return result;
    }

    private static int getMaxNumInPage(List<Integer> pageList, int num){
        return Math.max(getSum(pageList.get(num)), getMultiply(pageList.get(num)));

    }
}