package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if (isValid(pobi, crong)){
            return -1;
        }

        int pobiMax = Math.max(Math.max(addEachDigits(pobi.get(0)), addEachDigits(pobi.get(1))),
                Math.max(multiplyEachDigits(pobi.get(0)), multiplyEachDigits(pobi.get(1))));

        int crongMax = Math.max(Math.max(addEachDigits(crong.get(0)), addEachDigits(crong.get(1))),
                Math.max(multiplyEachDigits(crong.get(0)), multiplyEachDigits(crong.get(1))));

        return answerChoose(pobiMax, crongMax);

    }

    /**
     * 상태에 따라서 결과값을 출력하는 메소드
     * @param pobiMax
     * @param crongMax
     * @return
     */
    private static int answerChoose(int pobiMax, int crongMax) {
        int answer;
        if (pobiMax > crongMax){
            answer = 1;
        } else if(pobiMax < crongMax){
            answer = 2;
        } else {
            answer = 0;
        }
        return answer;
    }


    /**
     * 페이지의 범위가 옳바른지 체크
     * @param pobi
     * @param crong
     * @return
     */
    private static boolean isValid(List<Integer> pobi, List<Integer> crong) {
        return pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1);
    }

    /**
     *
     * 각각의 자릿수를 더하는 메소드
     * @param num
     * @return
     */
    public static int addEachDigits(int num){
        String strNum = Integer.toString(num);
        int result = 0;
        for(int i = 0 ; i < strNum.length(); i++){
            result += Integer.parseInt(strNum.substring(i, i + 1));
        }

        return result;
    }

    /**
     * 각각의 자릿수를 곱하는 메소드
     * @param num
     * @return
     */
    public static int multiplyEachDigits(int num){
        String strNum = Integer.toString(num);
        int result = 1;
        for(int i = 0 ; i < strNum.length(); i++){
            result *= Integer.parseInt(strNum.substring(i, i + 1));
        }

        return result;
    }

}