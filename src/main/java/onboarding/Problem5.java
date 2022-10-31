package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Problem5 {
    public static List<Integer> solution(int money) {
        // 액면가가 큰 화폐 순으로 최대한 많이 담기
        // 오만원권, 만원권, 오천원권, 천원권, 오백원동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전 순
        // 반복문 루프 생성, 화폐 종류는 9종
        // cash 메서드 생성, 반복문 내 i 값, 주어진 금액 money를 매개변수로 받음
        // i 값은 화폐의 액면가 결정 요소
        // money 를 화폐로 변환 하는 기능 수행 후 i 값에 따른 액면가 화폐 수량을 카운트 cnt 변수에 할당
        // 화폐 변환 후 bal 변수에 잔액 할당
        // 반복문 내부 arr 배열에 액면가 화폐 수량 cnt 와 잔액 bal 할당
        // 화폐 수량을 리스트 answer 에 추가, money 를 잔액으로 변경
        // 9 가지 권종 모두 변환 수행 완료 시 정답 리턴
        List<Integer> answer = new ArrayList<>(9);

        for(int i = 0; i < 9; i++) {
            int[] arr = cash(i, money);

            answer.add(arr[0]);
            money = arr[1];
        }

        return answer;
        // 테스트케이스 통과
    }
    private static int[] cash(int i, int money) {
        int[] rtn = new int[2]; // rtn[0] : 화폐 수량 cnt / rtn[1] : 잔액 bal
        switch (i) {
            case 0: // 오만원
                rtn[0] = money / 50000;
                rtn[1] = money % 50000;
                break;
            case 1: // 만원
                rtn[0] = money / 10000;
                rtn[1] = money % 10000;
                break;
            case 2: // 오천원
                rtn[0] = money / 5000;
                rtn[1] = money % 5000;
                break;
            case 3: // 천원
                rtn[0] = money / 1000;
                rtn[1] = money % 1000;
                break;
            case 4: // 오백원
                rtn[0] = money / 500;
                rtn[1] = money % 500;
                break;
            case 5: // 백원
                rtn[0] = money / 100;
                rtn[1] = money % 100;
                break;
            case 6: // 오십원
                rtn[0] = money / 50;
                rtn[1] = money % 50;
                break;
            case 7: // 십원
                rtn[0] = money / 10;
                rtn[1] = money % 10;
                break;
            case 8: // 일원
                rtn[0] = money / 1;
                rtn[1] = money % 1;
                break;
        }
        return rtn;
    }
}
