package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        try{
            if(!(isValidPage(pobi) && isValidPage(crong))){
                return -1;
            }
            int pobiValue = maxOpenBookValue(pobi);
            int crongValue = maxOpenBookValue(crong);

            if(pobiValue == crongValue){
                return 0;
            }else{
                return (pobiValue > crongValue) ? 1 : 2;
            }
        }catch(Exception e){
            return -1;
        }
    }
    static int maxOpenBookValue(List<Integer> person){
        int[] leftValue = getIntArray(Integer.toString(person.get(0)).split(""));
        int[] rightValue = getIntArray(Integer.toString(person.get(1)).split(""));

        return Math.max(getMaxValue(leftValue),getMaxValue(rightValue));
    }
    static int[] getIntArray(String[] array){
        int[] output = new int[array.length];
        for(int i = 0; i < output.length; i++){
            output[i] = Integer.parseInt(array[i]);
        }
        return output;
    }
    static int getMaxValue(int[] values){
        int plusValue = values[0];
        int multiplyValue = values[0];

        for(int i = 1; i < values.length; i++){
            plusValue += values[i];
            multiplyValue *= values[i];
        }

        return Math.max(plusValue,multiplyValue);
    }
    static boolean isValidPage(List<Integer> person){

        boolean isValidPageScope = !(person.get(0) <= 1 || person.get(1) >= 400);
        boolean isConsecutivePage = (person.get(1) - person.get(0) == 1);
        boolean isPageExistOnlyTwo = person.size() == 2;
        boolean isLeftOddRightEven = (person.get(0) % 2 == 1) && (person.get(1) % 2 == 0);

        return  isValidPageScope && isConsecutivePage && isPageExistOnlyTwo && isLeftOddRightEven;
    }
}
