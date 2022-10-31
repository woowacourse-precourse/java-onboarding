package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiLeft = pobi.get(0);
        int pobiRight = pobi.get(1);
        int crongLeft = crong.get(0);
        int crongRight = crong.get(1);
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

    // 4-두 수를 비교하는 기능
    public static boolean compare(int a, int b){
        return a > b;
}