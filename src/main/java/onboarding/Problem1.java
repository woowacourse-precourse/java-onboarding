package onboarding;

import java.util.List;
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if(pobi.get(1) != pobi.get(0)+1 || crong.get(1) != crong.get(0) +1 ) {
            answer = -1;
        }else if (getScroe(pobi.get(0), pobi.get(1)) > getScroe(crong.get(0),crong.get(1))){
            answer = 1;
        }else if(getScroe(pobi.get(0), pobi.get(1)) == getScroe(crong.get(0),crong.get(1))){
           answer = 0;
        }else answer = 2;
        return answer;
    }
    private static int maxOfPage(int page) {
        int[] arr = new int[3];
        int sum = 0;
        int multiple = 1;
        for (int i : arr) {
            arr[i] = page % 10;
            sum += arr[i];
            multiple *= arr[i];
            if(page/10 == 0) break;
            else page /= 10;
        }
        if (sum > multiple)
            return sum;
        else
            return multiple;
    }

    private static int getScroe(int page_1, int page_2){
        if(maxOfPage(page_1) > maxOfPage(page_2)) return maxOfPage(page_1);
        else return maxOfPage(page_2);
    }
}