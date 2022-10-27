package onboarding;

import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE; // 정수의 최대값.
        int pobiSum=0, pobiMulti=1;
        int crongSum=0, crongMulti =1;

        if(pobi.get(0) != pobi.get(1)-1 || crong.get(0) != crong.get(1)-1) return -1;

        for(int i =0;i<2;i++){
            int pobiNow = pobi.get(i);
            int crongNow = crong.get(i);

            while(pobiNow !=0 && crongNow !=0) {
                if (pobiNow != 0) {
                    pobiSum += pobiNow % 10;
                    pobiMulti *= pobiNow % 10;
                    pobiNow = pobiNow / 10;
                }

                if (crongNow != 0) {
                    crongSum += crongNow % 10;
                    crongMulti *= crongNow % 10;
                    crongNow = crongNow / 10;
                }
            }
        }
        if(Math.max(pobiSum,pobiMulti) > Math.max(crongSum,crongMulti)) answer = 1;
        else if(Math.max(pobiSum,pobiMulti) < Math.max(crongSum,crongMulti)) answer = 2;
        else answer = 0;

        return answer;
        // 제발 올라가줘요 ㅠㅠ 선생님 제발요 ㅠㅠ
        // 파일변경// 파일변경// 파일변경// 파일변경// 파일변경// 파일변경
    }
}
