package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        //시작 페이지가 나올 시 -1 리턴
        if(pobi.get(0) == 1) return -1;
        if(crong.get(0) == 1) return -1;

        //마지막 페이지가 나올 시 -1 리턴
        if(pobi.get(1) == 400) return -1;
        if(crong.get(1) == 400) return -1;

        //왼쪽 페이지가 짝수일 경우 -1 리턴
        if(pobi.get(0)%2 != 1) return -1;
        if(crong.get(0)%2 != 1) return -1;

        //오른쪽 페이지가 홀수일 경우 -1 리턴
        if(pobi.get(1)%2 != 0) return -1;
        if(crong.get(1)%2 != 0) return -1;

        //페이지 사이가 비어있을 경우 -1 리턴
        if(pobi.get(0)+1 != pobi.get(1)) return -1;
        if(crong.get(0)+1 != crong.get(1)) return -1;

        int pobiScore = 0;
        int crongScore = 0;

        for (int i = 0; i < pobi.size(); i++) {
            //pobi의 점수 구하기
            String pobiPage = String.valueOf(pobi.get(i));
            pobiScore = Math.max(pobiScore,getMaxNum(pobiPage));

            //crong의 점수 구하기
            String crongPage = String.valueOf(crong.get(i));
            crongScore = Math.max(crongScore,getMaxNum(crongPage));
        }

        //pobi의 점수가 큰 경우 리턴 1
        if(pobiScore>crongScore) return 1;

        //crong의 점수가 큰 경우 리턴 2
        if(crongScore>pobiScore) return 2;

        //같을 경우 리턴 0
        return 0;
    }

    // 더하기와 곱하기 중 큰 값을 출력하는 메소드
    private static int getMaxNum(String page) {
        int plusNum = page.charAt(0)-'0';
        int multipleNum = page.charAt(0)-'0';

        for (int i = 1; i < page.length(); i++) {
            plusNum += page.charAt(i) - '0';
            multipleNum *= page.charAt(i) - '0';
        }

        return Math.max(plusNum, multipleNum);
    }

}