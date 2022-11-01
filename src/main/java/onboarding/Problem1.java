package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
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