package service.problem1;

import java.util.List;

public class Problem1Service {
    // 승자 판별 메소드 -> player1 승리하면 1, player2 승리하면 2, 비기면 0, 예외상황인 경우 -1을 반환합니다.
    public Integer getWinner(List<Integer> player1Pages, List<Integer> player2pages){
        return null;
    }

    // Winner를 가립니다.
    public Integer isWinner(List<Integer> player1pages, List<Integer> player2pages){
        return null;
    }

    // 모든 제한사항을 판별하는 메소드
    public boolean isRestrict(List<Integer> player1pages, List<Integer> player2pages){
        return true;
    }

    // 나올수 없는 페이지 판별 메소드 -> [짝, 홀]인 경우, arr[0] + 1 == arr[1]이 아닌 경우 true를 반환합니다.
    public boolean isWrongPageInputNumber(List<Integer> player1pages, List<Integer> player2pages){
        return true;
    }

    // 제한된 페이지 판별 메소드 -> 음수 및 {1,2,399,400}페이지라면 true를 반환합니다.
    public boolean isRestrictPage(List<Integer> player1pages, List<Integer> player2pages){
        return false;
    }
}
