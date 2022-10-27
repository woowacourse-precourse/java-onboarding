package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!checkPagesInRange(pobi)||!checkPagesInRange(crong)){
            return -1;
        }
        if (!checkFirstPageAndSecPageContinued(pobi)||!checkFirstPageAndSecPageContinued(crong)){
            return -1;
        }
        if(!checkFirstPageOddAndSecPageEven(pobi)||!checkFirstPageOddAndSecPageEven(crong)){
            return -1;
        }
        int pobiMax=getMaxGameValue(pobi);
        int crongMax=getMaxGameValue(crong);
        if(pobiMax<crongMax){
            return 2;
        }else if(pobiMax>crongMax){
            return 1;
        }else{
            return 0;
        }
    }

    private static int getMaxGameValue(List<Integer> pageList) {
        int max=-1;
        for(int page:pageList){
            List<Integer> digitList=getDigitList(page);
            int sum = getDigitSum(digitList);
            int multiplicationResult = getDigitMultiplicationResult(digitList);
            int bigger=Math.max(sum,multiplicationResult);
            max=Math.max(max,bigger);
        }
        return max;
    }

    private static boolean checkFirstPageOddAndSecPageEven(List<Integer> pageList){
        return pageList.get(0) % 2 == 1 && pageList.get(1) % 2 == 0;
    }

    private static boolean checkFirstPageAndSecPageContinued(List<Integer> pageList){
        return pageList.get(0)+1==pageList.get(1);
    }

    private static boolean checkPagesInRange(List<Integer> pageList){
        int pageOne=pageList.get(0);
        int pageTwo=pageList.get(1);
        return checkPageInRange(pageOne)&&checkPageInRange(pageTwo);
    }

    private static boolean checkPageInRange(int page){
        return page>0 && page<=400;
    }
    private static List<Integer> getDigitList(int n){
        List<Integer> digitList = new ArrayList<>();
        while(n!=0){
            digitList.add(n%10);
            n=n/10;
        }
        return digitList;
    }

    private static int getDigitSum(List<Integer> digitList){
        Integer sum=0;
        for(Integer digit : digitList){
            sum+=digit;
        }
        return sum;
    }

    private static int getDigitMultiplicationResult(List<Integer> digitList){
        Integer result=1;
        for(Integer digit : digitList){
            result*=digit;
        }
        return result;
    }
}