package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;


        int pobiLeftPage = pobi.get(0);
        int pobiRightPage = pobi.get(1);
        int crongLeftPage = crong.get(0);
        int crongRightPage = crong.get(1);
        //예외처리 : 좌측 페이지가 홀수이고, 우측 페이지가 좌측 페이지의 다음 페이지인 경우가 아니면 예외
        if      (pobiLeftPage%2 != 1 |
                 pobiRightPage - pobiLeftPage != 1 |
                 crongLeftPage%2 != 1 |
                 crongRightPage - crongLeftPage != 1) answer = -1;
        else {
            //페이지 자릿수별 숫자 분리
            int[] pobiLeftSeperatePage = getSeperatePage(pobiLeftPage);
            int[] pobiRightSeperatePage = getSeperatePage(pobiRightPage);
            int[] crongLeftSeperatePage = getSeperatePage(crongLeftPage);
            int[] crongRightSeperatePage = getSeperatePage(crongRightPage);

            ////페이지별 최댓값 비교
            //포비, 크롱 최댓값
            int pobiMax = Math.max(getBigNumber(pobiLeftSeperatePage),getBigNumber(pobiRightSeperatePage));
            int crongMax = Math.max(getBigNumber(crongLeftSeperatePage),getBigNumber(crongRightSeperatePage));

            ////승부내기
            //포비 승 크롱 패
            if(pobiMax > crongMax)  answer = 1;
            //무승부
            if(pobiMax == crongMax) answer = 0;
            //포비 패 크롱 승
            if(pobiMax < crongMax) answer = 2;
        }

        return answer;
    }

    //페이지 자릿수별 숫자 분리 메소드
    public static int[] getSeperatePage(int page){
        return Stream.of(String.valueOf(page).split("")).mapToInt(Integer::parseInt).toArray();
    }

    //합곱 중 큰 수 비교
    public static int getBigNumber(int[] seperatePage){
        return Math.max(Arrays.stream(seperatePage).sum(),Arrays.stream(seperatePage).reduce(1,(x,y) -> x*y));
    }

}