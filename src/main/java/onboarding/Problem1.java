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
}