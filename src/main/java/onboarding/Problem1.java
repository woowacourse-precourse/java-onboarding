package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {

    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int DRAW = 0;
    private static final int EXCEPTION = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;

        try{
            validCheck(pobi);
            validCheck(crong);

            int pobiScore = Math.max(maxScore(pobi.get(0)),maxScore(pobi.get(1)));
            int crongScore = Math.max(maxScore(crong.get(0)),maxScore(crong.get(1)));

            if (pobiScore==crongScore){
                answer = DRAW;
            }else {
                answer = (pobiScore>crongScore) ? POBI_WIN:CRONG_WIN;
            }
        }catch (Exception e){
            answer = EXCEPTION;
        }finally {
            return answer;
        }
    }

    // 번호(int)를 받아 합,곱점수 중 최대점수를 반환
    private static int maxScore(int pageNum){

        int [] arrayNumber = intToArray(pageNum);
        return Math.max(add(arrayNumber), multiply(arrayNumber));
    }

    // 페이지 번호(int)를 받아 배열(int[])로 반환
    private static int[] intToArray(int num){

        return Stream
                .of(String.valueOf(num).split(""))
                .mapToInt(Integer::parseInt).
                toArray();
    }

    // 번호 배열을 받아 합 점수를 반환
    private static int add(int [] arrNum){

        int result = 0;
        for(int i = 0; i < arrNum.length; i++) {
            result += arrNum[i];
        }
        return result;
    }

    // 번호 배열을 받아 곱 점수를 반환
    private static int multiply(int [] arrNum){

        int result = 1;
        for(int i = 0; i < arrNum.length; i++){
            result *= arrNum[i];
        }
        return result;
    }

    // 예외 처리
    private static void validCheck(List<Integer> pages) throws Exception{
        if (pages.get(0)==1 || pages.get(1)==400){
            throw new Exception("시작 페이지나 마지막 페이지를 펼칠 수 없습니다.");
        }
        if (pages.get(0)>399 || pages.get(1)>400){
            throw new Exception("책 페이지 범위는 1~400 입니다.");
        }
        if (pages.get(0)<1 || pages.get(1)<1){
            throw new Exception("책 페이지는 양수입니다.");
        }
        if (pages.get(0)>399 || pages.get(1)>400){
            throw new Exception("책 페이지 범위는 1~400 입니다.");
        }

        if (pages.get(1)-pages.get(0) != 1){
            throw new Exception("페이지 값 차이는 반드시 1 입니다.");
        }
        if (pages.get(0)%2 == 0){
            throw new Exception("왼쪽 페이지가 짝수일 수 없습니다.");
        }
        if (pages.get(1)%2 == 1){
            throw new Exception("오른쪽 페이지가 홀수일 수 없습니다.");
        }

    }
}