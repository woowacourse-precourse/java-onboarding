package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        return Integer.compare(maxValue(pobi.get(0), pobi.get(1)), maxValue(crong.get(0), crong.get(1)));
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