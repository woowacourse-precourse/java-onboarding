package onboarding;

import java.util.List;

class Problem1 {

    private final int LEFT_IDX = 0;
    private final int RIGHT_IDX = 1;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private Integer calculateScore(List<Integer> bothPageNums) throws Exception {

        Integer leftPageNum = bothPageNums.get(LEFT_IDX);
        Integer rightPageNum = bothPageNums.get(RIGHT_IDX);

        validatePageOddIfLeftElseEven(leftPageNum,rightPageNum);
        validatePageNumScope(leftPageNum);
        validatePageNumScope(rightPageNum);
        validateIsContinuousPage(leftPageNum,rightPageNum);

        Integer  leftScore = Math.max(calculateSumOfPlaceValue(leftPageNum),
                calculateProductOfPlaceValue(leftPageNum));

        Integer rightScore = Math.max(calculateSumOfPlaceValue(rightPageNum),
                calculateProductOfPlaceValue(rightPageNum));

        return Math.max(leftScore,rightScore);
    }

    private  Integer calculateProductOfPlaceValue(Integer num){
        String[] placeValuesOfNum = String.valueOf(num).split("");
        Integer product = 1;

        for(String placeValue : placeValuesOfNum){
            product*=Integer.parseInt(placeValue);
        }

        return product;
    }

    private  Integer calculateSumOfPlaceValue(Integer num){
        String[] placeValuesOfNum = String.valueOf(num).split("");
        Integer sum = 0;

        for(String placeValue : placeValuesOfNum){
            sum+=Integer.parseInt(placeValue);
        }

        return sum;
    }

    private  void validateIsContinuousPage(Integer leftPageNum, Integer rightPageNum) throws Exception {
        if(rightPageNum-leftPageNum!=1) throw new Exception();
    }

    private  void validatePageNumScope(Integer pageNum) throws Exception {
        if(pageNum<1||pageNum>400) throw new Exception();
    }

    private void validatePageOddIfLeftElseEven(Integer leftPageNum, Integer rightPageNum) throws Exception{
        if((leftPageNum%2)==0||(rightPageNum%2)!=0) throw new Exception();
    }
}