package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MIN_VALUE;

        if(validation(pobi) || validation(crong)){
            return -1;
        }

        int pobiMaxValue = getMax(pobi);
        int crongMaxValue = getMax(crong);

        if(pobiMaxValue == crongMaxValue) {
            return 0;
        }

        return pobiMaxValue > crongMaxValue ? 1 : 2;
    }

    public static int getMax(List<Integer> pages) {
        int maxValue = Integer.MIN_VALUE;

        for(int page : pages){
            int sumValue = getSum(page);
            int multiValue = getMulti(page);

            maxValue = Math.max(maxValue, Math.max(sumValue, multiValue));
        }

        return maxValue;
    }

    private static int getMulti(int page) {
        int multiValue = 1;

        while(page > 0){
            multiValue *= page % 10;
            page /= 10;
        }

        return multiValue;
    }

    private static int getSum(int page) {
        int sumValue = 0;

        while(page > 0){
            sumValue += page % 10;
            page /= 10;
        }

        return sumValue;
    }

    public static boolean validation(List<Integer> list){
        if(list.size() != 2 || list.get(0) <= 1 || list.get(1) >= 400
                || list.get(0) % 2 != 1 || list.get(1) % 2 != 0) {
            return true;
        }

        return list.get(1) - list.get(0) != 1;
    }
}