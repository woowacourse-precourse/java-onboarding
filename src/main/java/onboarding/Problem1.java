package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        System.out.println("pobi: "+ Arrays.toString(pobi.toArray()));
        System.out.println("crong: "+Arrays.toString(crong.toArray()));
        //예외 사항이 나오면 -1 리턴
        int exceptionCase = -1;
        if(pobi.get(0) <= 1 || crong.get(0) <= 1) return exceptionCase;
        if(pobi.get(1) >= 400 || crong.get(1) >= 400) return exceptionCase;
        if(pobi.get(0)+1 != pobi.get(1) || crong.get(0)+1 != crong.get(1)) return exceptionCase;

        //왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
        //오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
        ArrayList<Integer> tmpPobi = new ArrayList<>();
        ArrayList<Integer> tmpCrong = new ArrayList<>();

        int pobiPage = pobi.get(0);
        int crongPage = crong.get(0);

        setTmpList(tmpPobi, pobiPage);
        setTmpList(tmpCrong, crongPage);

        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static void setTmpList(ArrayList<Integer> tmp, int page) {
        // 페이지 각 번호가 들어있는 임시 페이지 리스트 만들기
        while(page!=0) {
            tmp.add(page%10);
            page/=10;
        }
    }
}