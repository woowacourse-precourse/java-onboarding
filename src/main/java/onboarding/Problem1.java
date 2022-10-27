package onboarding;


import java.util.List;

class Problem1 {

    // 예외 처리 메소드
    public static void exceptions(List<Integer> pobi, List<Integer> crong) throws RuntimeException {
        if(pobi.get(0)%2 != 1 || crong.get(0)%2 != 1) {
            throw new RuntimeException("왼쪽 페이지는 홀수만 입력 가능합니다.");
        }

        if(pobi.get(1)%2 != 0 || crong.get(1)%2 != 0) {
            throw new RuntimeException("오른쪽 페이지는 짝수만 입력 가능합니다.");
        }

        if(pobi.get(0)+1 != pobi.get(1) || crong.get(0)+1 != crong.get(1)){
            throw new RuntimeException("페이지 사이가 비어있습니다.");
        }
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


    public static int solution(List<Integer> pobi, List<Integer> crong) {

        //예외 발생시 -1 리턴
        try {
            exceptions(pobi,crong);
        }catch (RuntimeException e){
            return -1;
        }

        int pobiScore = 0;
        int crongScore = 0;

        for (int i = 0; i < 2; i++) {
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

}