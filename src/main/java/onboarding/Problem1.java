package onboarding;

import java.util.List;

class Problem1 {
    public static int addEachDigitOfPageNum(int pageNum){
        int sumOfEachDigit=0;
        while(pageNum>0){
            sumOfEachDigit+=pageNum%10;
            pageNum/=10;
        }
        return sumOfEachDigit;
    }
    public static int multiplyEachDigitOfPageNum(int pageNum){
        int productOfEachDigit=1;
        while(pageNum>0){
            productOfEachDigit*=pageNum%10;
            pageNum/=10;
        }
        return productOfEachDigit;
    }
    public static int getMaxValue(int pageNum){
        int maxValue=0;
        int sumOfEachDigit=addEachDigitOfPageNum(pageNum);
        int productOfEachDigit=multiplyEachDigitOfPageNum(pageNum);
        if(sumOfEachDigit >= productOfEachDigit){
            maxValue=sumOfEachDigit;
        } else {
            maxValue=productOfEachDigit;
        }
        return maxValue;
    }

    public static int getScoreByMaxValue(List<Integer> pages){
        int scoreByMaxValue=0;
        int leftPage=pages.get(0);
        int rightPage=pages.get(1);

        int leftMaxValue=getMaxValue(leftPage);
        int rightMaxValue=getMaxValue(rightPage);

        if(leftMaxValue >= rightMaxValue){
            scoreByMaxValue=leftMaxValue;
        } else{
            scoreByMaxValue=rightMaxValue;
        }
        return scoreByMaxValue;
    }
    public static boolean isInValidRange(List<Integer> pages){
        boolean isInValidRange=true;
        if(pages.get(0)==1 || pages.get(1)==400){
            isInValidRange=false;
        }
        return isInValidRange;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(isInValidRange(pobi)==true && isInValidRange(crong)==true){
            int pobiScore=getScoreByMaxValue(pobi);
            int crongScore=getScoreByMaxValue(crong);
        } else {
            answer=-1;
        }
        return answer;
    }
}