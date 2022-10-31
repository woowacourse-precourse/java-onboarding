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
}