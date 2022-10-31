package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(checkException(pobi) || checkException(crong)){
            return -1;
        }
        int pobiNumber  =  calculator(pobi);
        int crongNumber =  calculator(crong);

        return getPoint(pobiNumber,crongNumber);
    }
    public static int getPoint(int pobiNumber,int crongNumber){
        return pobiNumber == crongNumber ? 0 : (pobiNumber > crongNumber ? 1 : 2);
    }
    public static int calculator(List<Integer> numList){
        int[] leftArray = getNumArray(numList,0);
        int[] rightArray = getNumArray(numList,1);
        int leftPlusNum= getPlusNumber(leftArray);
        int rightPlusNum = getPlusNumber(rightArray);
        int leftMultiplyNum=getMultiplyNumber(leftArray);
        int rightMultiplyNum=getMultiplyNumber(rightArray);
        return getMax(leftPlusNum,rightPlusNum,leftMultiplyNum,rightMultiplyNum);
    }
    public static int[] getNumArray(List<Integer> numList,int index){
        return Stream.of(String.valueOf(numList.get(index)).split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
    public static int getPlusNumber(int[] arr){
        return Arrays.stream(arr).sum();
    }
    public static int getMultiplyNumber(int[] arr){
        return Arrays.stream(arr).reduce(1,(a,b) -> a*b);
    }
    public static int getMax(int num1,int num2,int num3, int num4){
        return Arrays.stream(new int[]{num1,num2,num3,num4})
                .max()
                .getAsInt();
    }
    public static boolean checkException(List<Integer> checkList){
        Integer leftNum = checkList.get(0)+1;
        Integer rightNum = checkList.get(1);
        return checkSniffling(leftNum, rightNum)
                || checkRange(leftNum,rightNum)
                || checkContinueNum(leftNum,rightNum);
    }
    public static boolean checkSniffling(Integer num1, Integer num2){
        return num1 % 2 != 0 || num2 % 2 != 0;
    }
    public static boolean checkRange(Integer num1, Integer num2){
        return num1 <=2 || num2 >=400;
    }
    public static boolean checkContinueNum(Integer num1,Integer num2){
        return !num1.equals(num2);
    }
}