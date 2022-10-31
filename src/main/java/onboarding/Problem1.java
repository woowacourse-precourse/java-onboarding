package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!exception(pobi, crong)) {
            return -1;
        } return compare(maxValue(pobi.get(0), pobi.get(1)), maxValue(crong.get(0), crong.get(1)));
    }
    public static boolean exception(List<Integer> pageList, List<Integer> pageList2) {
        return (pageList.get(1) - pageList.get(0)) == 1 && (pageList2.get(1) - pageList2.get(0)) == 1;
    }
    public static int compare(int pobiNum, int crongNum) {
        if(pobiNum > crongNum) {
            return 1;
        }else if(pobiNum < crongNum) {
            return 2;
        }else return 0;
    }
    public static int higherValue(int num) {
        String number = String.valueOf(num);
        int sum = 0;
        int multiple = 1;
        for (int i = 0; i < number.length(); i++) {
            sum += number.charAt(i) - '0';
            multiple *= number.charAt(i) - '0';
        }
        return Math.max(sum, multiple);
    }
    public static int maxValue(int leftNum, int rightNum) {
        return Math.max(higherValue(leftNum), higherValue(rightNum));
    }
}