package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static int getMaxScore(List<Integer> pages){
        return pages.stream()
                .mapToInt(i -> toScore(i))
                .max()
                .getAsInt();
    }

    private static int toScore(int page){
        int addedResult = 0;
        int multipliedResult = 1;

        for (int i=getMaxPlaceValue(page); i>0; i/=10){
            int score = page / i;
            page %= i;

            addedResult += score;
            multipliedResult *= score;
        }

        return Math.max(addedResult, multipliedResult);
    }

    private static int getMaxPlaceValue(int page){
        int placeValue = (int)(Math.log10(page));
        int result = 1;

        for (int i=0; i<placeValue; i++){
            result *= 10;
        }

        return result;
    }
}