package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        List<Integer> pobiLeftSlice = slice(pobi.get(0));
        List<Integer> pobiRightSlice = slice(pobi.get(1));
        List<Integer> crongLeftSlice = slice(crong.get(0));
        List<Integer> crongRightSlice = slice(crong.get(1));

        int [] pobiNumArray = {sum(pobiLeftSlice),sum(pobiRightSlice),multiply(pobiLeftSlice),multiply(pobiRightSlice)};
        int pobiNum = compare(pobiNumArray);
        int [] crongNumArray = {sum(crongLeftSlice),sum(crongRightSlice),multiply(crongLeftSlice),multiply(crongRightSlice)};
        int crongNum = compare(crongNumArray);

        int maxResult = compare(new int[]{pobiNum, crongNum});
        if (maxResult == pobiNum && maxResult == crongNum){
            answer = 0;
        } else if (maxResult == pobiNum) {
            answer = 1;
        }else {
            answer = 2;
        }
        return answer;
    }

    // 1-자릿수 별로 나누는 기능
    public static List<Integer> slice(int page){
        List<Integer> sliceList = new ArrayList<>();
        while(page>0){
            sliceList.add(page%10);
            page = page/10;
        }
        return sliceList;
    }

    // 2-주어진 수를 모두 더하는 기능
    public static int sum(List<Integer> page){
        int result = 0;
        for (int i=0; i<page.size(); i++){
            result+=page.get(i);
        }
        return result;
    }

    // 3-주어진 수를 모두 곱하는 기능
    public static int multiply(List<Integer> page){
        int result = 1;
        for (int i=0; i<page.size(); i++){
            result *=page.get(i);
        }
        return result;
    }

    // 4-주어진 수에서 가장 큰 수 구하는 기능
    public static int compare(int[] numArr) {
        int max = numArr[0];
        for (int i = 1; i < numArr.length; i++) {
            if (max < numArr[i]) {
                max = numArr[i];
            }
        }
        return max;
    }
}