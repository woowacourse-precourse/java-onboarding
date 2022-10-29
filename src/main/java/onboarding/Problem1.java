package onboarding;

import java.util.List;

class Problem1 {
    // 1. 페이지 번호 유효성 체크 => 예외 사항 시 false return => false시 예외처리
    // 조건 : 1~400페이지 사이이며 시작페이지 또는 마지막페이지가 아닌지 / 왼쪽페이지가 홀수 번호이며 오른쪽페이지 보다 1작은지
    public static boolean isExecption(List<Integer> pageNumbers){
        // 들어온 페이지 리스트의 왼쪽 페이지, 오른쪽 페이지
        int left_page = pageNumbers.get(0);
        int right_page = pageNumbers.get(1);

        if(left_page % 2 == 0 || !(left_page + 1 == right_page)) { // 조건 : 왼쪽 페이지가 짝수거나 두 페이지가 1차이가 아닌 경우 false return
            return false;
        } else if(left_page > 397 || left_page < 3){ // 조건 : 1~400페이지 사이가 아니거나 첫 페이지 또는 마지막 페이지인 경우 false return
            return false;
        } // 예외 처리 통과 시 true return
        return true;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        // 2. 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구하는 함수 만들기.

        // 3. pobi와 crong의 점수 구하기

        // 4. 점수를 비교해서 승자를 구하기

        // 5. 승자에 따라 결과 값 return => pobi : 1 / crong : 2 / 무승부 : 0
        return answer;
    }
}