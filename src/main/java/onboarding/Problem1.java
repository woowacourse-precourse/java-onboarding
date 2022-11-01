package onboarding;

import java.util.List;
import java.util.Arrays;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        
        int answer = Integer.MAX_VALUE;
        //예외처리

        if (checkPageList(pobi) < 0 || checkPageList(crong)<0){
            answer = -1;
        } else {
            //변수 선언 후 할당
            int pobiScore = scoreFrom(pobi);
            int crongScore = scoreFrom(crong);
            //점수 비교 및 리턴 값 할당
            if (pobiScore == crongScore) {
                answer = 0;
            } else if (pobiScore > crongScore) {
                answer = 1;
            } else if (pobiScore < crongScore) {
                answer = 2;
            }
        }

        return answer;
    }

    private static int checkPageList(List<Integer> pageNumList) {//예외처리
        int leftPageNum = pageNumList.get(0);
        int rightPageNum = pageNumList.get(1);
        int result = 0;
        if (leftPageNum < 1 || rightPageNum > 400 || 1 > rightPageNum || 400 < leftPageNum || leftPageNum % 2 == 0 || rightPageNum % 2 == 1) {
            result = -1 ;
        } else if (rightPageNum - leftPageNum != 1) {
            result =  -1 ;
        }
        return  result;
    }

    private static int scoreFrom(List<Integer> pages) {
        return pages.stream()
                .map(Problem1::findMaxScore)
                .max(Integer::compareTo).orElse(-1);
    }
    
    private static int findMaxScore(Integer page) {
        Integer[] digit = pageToDigitNumbers(page);
        return Math.max(addNumbers(digit), multiplyNumbers(digit));
    }
    
    private static Integer[] pageToDigitNumbers(Integer page) {
        int digit = String.valueOf(page).length();//자릿수로 분할
        Integer[] digitNumbers = new Integer[digit];
        for (int i = 0; i < digit; i++) {
            digitNumbers[i] = page % 10;
            page /= 10;
        }
        return digitNumbers;
    }
    
    private static int multiplyNumbers(Integer[] digits) {
        return Arrays.stream(digits).reduce(1, (integer, integer2) -> integer * integer2);
    }
    
    private static int addNumbers(Integer[] digits) {
        return Arrays.stream(digits).reduce(0, Integer::sum);
    }    

}