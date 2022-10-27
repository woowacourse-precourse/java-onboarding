package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    /**
     * 참여자 두 명의 페이지 번호 리스트들을 받아 게임 결과를 반환
     * @param pages1 : 첫 번째 참여자의 page list
     * @param pages2 : 두 번째 참여자의 page list
     * @return 첫 번째 참여자가 이긴다면 1, 두 번째 참여자가 이긴다면 2, 무승부라면 0, 예외사항은 -1
     */
    private int getResult(List<Integer> pages1, List<Integer> pages2){
        try{
            //파라미터 유효성 검사
            checkParameterValidation(pages1, pages2);

            //각 페이지 리스트의 점수 측정
            int score1 = getScore(pages1);
            int score2 = getScore(pages2);

            return compareScore(score1, score2);
        } catch (RuntimeException e){
            return -1;
        }
    }

    /**
     * 두 개의 점수를 비교하여 결과를 리턴
     * @param score1 : 첫 번째 점수
     * @param score2 : 두 번째 점수
     * @return 첫 번째 점수가 더 높다면 1, 두 번째 점수가 더 높다면 2, 점수가 같다면 0
     */
    private int compareScore(int score1, int score2){
        if(score1 > score2){
            return 1;
        } else if (score2 < score1) {
            return 2;
        } else {
            return 0;
        }
    }

    /**
     * 게임 입력값의 유효성을 검사
     * @param pages1 : 첫 번째 참여자의 page list
     * @param pages2 : 두 번째 참여자의 page list
     */
    private void checkParameterValidation(List<Integer> pages1, List<Integer> pages2){

    }

    /**
     * 숫자 리스트를 받아 각 자리의 한 자리 숫자 리스트를 반환하는 함수
     * @param numList
     * @return 숫자 리스트의 각 자리 수 리스트
     */
    private List<Integer> getDigitList(List<Integer> numList){

    }

    /**
     * 두 개의 페이지 번호를 받아 게임 점수를 반환
     * @param pages : 책을 펼쳤을 때 나온 두 개의 페이지 번호
     * @return 페이지 번호를 더한 값과 페이지 번호를 곱한 값 중 더 큰 값
     */
    private int getScore(List<Integer> pages){

    }

    /**
     * 두 개의 숫자 중 더 큰 수를 반환
     * @param num1 : 첫 번째 숫자
     * @param num2 : 두 번째 숫자
     * @return 두 숫자 중 더 큰 수
     */
    private int getLargerNumber(int num1, int num2){

    }

    /**
     * 숫자 리스트를 받아 곱을 반환하는 함수
     * @param numList : 숫자 리스트
     * @return 숫자 리스트의 곱
     */
    private int getMultiplicationOfList(List<Integer> numList){

    }

    /**
     * 숫자 리스트를 받아 합을 반환하는 함수
     * @param numList : 숫자 리스트
     * @return 숫자 리스트의 합
     */
    private int getSumOfList(List<Integer> numList) {

    }
}