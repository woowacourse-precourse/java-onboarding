package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static void main(String[] args) {
        getPlace(335);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static void getPlace(int pageNum)
    {
        int length = (int) Math.log10(pageNum);
        int arr[] = new int[length+1];
        for(int i = length; i > 0; i--){
            arr[length-i] = (int) (pageNum / Math.pow(10, i));
            arr[length-i+1] = pageNum = (int) (pageNum % Math.pow(10, i));
        }

        System.out.println(Arrays.toString(arr));
        //return arr;
    }
}