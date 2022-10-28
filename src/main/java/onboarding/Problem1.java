package onboarding;

import java.util.List;

class Problem1 {

    /*
    두 게임 참여자의 pages를 List<Integer>로 받아 승자를 return하는 메서드
    - 예외 사항
        1. pages List의 요소 수는 2개
        2. pages List의 Integer item은 연속된 두 수
        3. pages의 두 수 중 왼쪽의 수는 항상 홀수, 오른쪽의 수는 항상 짝수
        4. pages 경우의 수에 시작 면(1, 2)과 마지막 면(399, 400)은 포함X
        5. 따라서 pages List item의 범위는 3~398
     */
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 예외 사항 체크. boolean isVaild(List<Integer> pages)

        // pobi의 점수 구하기. int getScore(List<Integer> pages)
        // crong의 점수 구하기. int getScore(List<Integer> pages)

        // pobi와 crong의 점수 비교
         // pobi win
         // crong win
         // 무승부 발생

        return answer;
    }

    /*
    게임 참여자의 점수를 계산하는 메서드
    List<Integer> 객체를 매개변수로 받음.
    두 요소(숫자)의 각 자리 합과 각 자리 곱을 계산하여 리스트에 저장
    해당 리스트의 요소 중 가장 큰 숫자를 반환
     */
    private static int getScore(List<Integer> pages) {
        int score = null;

        // 각 페이지 숫자의 자리 합과 곱(4개)을 저장할 배열 scores 선언
        // pageList 순회하며 배열 scores에 요소의 합과 곱을 저장. List<Integer> pageNumToList(int page)
        // 배열 scores 요소 중 가장 큰 값을 score에 저장

        return score
    }
    
    /*
    특정 페이지 번호의 각 자리 숫자를 리스트에 저장하여 반환하는 메서드
    각 숫자를 더하거나 곱하므로 리스트 배치 순서를 고려하지 않아도 됨
     */
    private static List<Integer> pageNumToList(int page) {
        List<Integer> pageNum = List<Integer>();
        while(page > 0) {
            pageNum.add(page % 10);
            page = (int)(page / 10);
        }
        return pageNum;
    }

    /*
    매개변수로 받은 List<Integer>가 유효한지 체크하는 메서드
    유효할 시 true, 유효하지 않을 시 false
     */
    private static boolean isVaild(List<Integer> pages) {
        leftPage = pages.get(0);
        rightPage = pages.get(1);
            // 왼쪽 페이지가 홀수이고, 오른페이지가 짝수이고, 페이지 수가 2이고, 첫 장(1, 2)이나 마지막 장(399, 400)이 아니면 true
        return leftPage % 2 == 1 && rightPage % 2 == 0 && pages.size() == 2 && leftPage != 1 && rightPage != 400;
    }
}