/*
[기능 목록]
1. 은행 클래스 구현
    1) 프로퍼티 : 화폐 종류가 담긴 자료구조
    2) 메서드
        - constructor
        - 화폐 종류 추가
        - 화폐 종류 삭제
        - 유효한 화폐 여부 확인
        - 출금
 */

package onboarding;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        return answer;
    }
}

class Bank {
    HashSet<Integer> cashList;

    public Bank(List<Integer> cashList) {
        this.cashList = new HashSet<>(cashList);
    }

    public boolean isCashExisted (int cash) {
        return cashList.contains(cash);
    }
}
