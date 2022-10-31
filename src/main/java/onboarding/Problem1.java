package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    public static int[] eachPageNum(int num) {
        int[] arrNum = Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
        return arrNum;
    }
    public static int plus(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    public static int multiple(int[] arr) {
        int multiple = 1;
        for (int i = 0; i < arr.length; i++) {
            multiple *= arr[i];
        }
        return multiple;
    }
    public static int max(int[] arr) {
        Arrays.sort(arr);
        return Arrays.stream(arr).max().getAsInt();
    }
    public static int myMaxNum(List<Integer> list) {
        int[] leftPageNum = eachPageNum(list.get(0));
        int[] rightPageNum = eachPageNum(list.get(1));
        int[] getNumberArr = new int[4];
        getNumberArr[0] = plus(leftPageNum);
        getNumberArr[1] = multiple(leftPageNum);
        getNumberArr[2] = plus(rightPageNum);
        getNumberArr[3] = multiple(rightPageNum);
        return max(getNumberArr);
    }

}