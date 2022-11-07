package onboarding;

import java.util.List;

class Problem1 {

    public static class Pages{
        private static final int MIN_PAGE=1;
        private static final int MAX_PAGE=400;
        private static boolean isRangeValid(int page){
            if(page>= MIN_PAGE && page<= MAX_PAGE){
                return true;
            }
            return false;
        }
        private static boolean isLeftValid(int leftPage){
            if(leftPage%2!=0){
                return true;
            }
            return false;
        }
        private static boolean isPairValid(int leftPage,int rightPage){
            if(leftPage+1==rightPage){
                return true;
            }
            return false;
        }
        public static void validate(List<Integer> pages) throws InvalidInputException {
             int leftPage=pages.get(0);
             int rightPage=pages.get(1);
             // 1. 1<=페이지번호<=400
             // 2. 왼쪽 페이지 번호, 오른쪽 페이지 번호는 연속된 수
             // 3. 왼쪽: 홀수, 오른쪽: 짝수
             if(!(isRangeValid(leftPage) && isRangeValid(rightPage)
                     &&isLeftValid(leftPage) && isPairValid(leftPage,rightPage))){
                 throw new InvalidInputException();
             }
         }
    }
    public static class Digit{

        public static int addAll(String number){
            int result=0;
            for(int i=0;i<number.length();i++){
                result+=Character.getNumericValue(number.charAt(i));
            }
            return result;
        }
        public static int multiplyAll(String number){
            int result=Character.getNumericValue(number.charAt(0));
            for(int i=1;i<number.length();i++){
                result*=Character.getNumericValue(number.charAt(i));
            }
            return result;
        }
    }
    public static class InvalidInputException extends Throwable {
    }
    private static int computeScore(List<Integer> pages){
        String leftPage=Integer.toString(pages.get(0));
        String rightPage=Integer.toString(pages.get(1));
        int leftScore=Math.max(Digit.addAll(leftPage),Digit.multiplyAll(leftPage));
        int rightScore=Math.max(Digit.addAll(rightPage),Digit.multiplyAll(rightPage));
        return Math.max(leftScore,rightScore);
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        //TODO : input 예외 처리
        try{
            Pages.validate(pobi);
            Pages.validate(crong);
        }catch (InvalidInputException e){
            answer=-1;
            return answer;
        }

        //TODO : pobi, crong 점수 계산하기
        int pobiScore=computeScore(pobi);
        int crongScore=computeScore(crong);

        //TODO : 승부 결과 판단 및 리턴(answer)
        if(pobiScore>crongScore){
            answer=1;
        }else if(pobiScore<crongScore){
            answer=2;
        }else{
            answer=0;
        }
        return answer;
    }
}