package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <기능 목록>
 *     1. 메소드
 *          1) putInWallet
 *          : 은행에서 출금한 돈을 지갑에 넣는다. 단, 지갑이 최대한 가볍도록 큰 금액의 화폐 위주로 담는다. 동작 방식은 다음과 같다.
 *
 *          - 5만원부터 1원까지 화폐 단위를 담은 currency 리스트를 만든다.
 *          - 5만원부터 1원까지의 각 화폐 단위의 사용 횟수를 담을 result 리스트를 만든다.
 *          - currency 리스트를 돌면서, 현재 화폐 단위(now)보다 money가 크거나 같으면 now를 사용할 수 있으므로 result에 now의 사용횟수를 기록한다.
 *          - 만약 현재 화폐 단위 사용할 수 없다면 0을 기록한다.
 *          - 현재 화폐단위를 사용했다면 그만큼 money가 줄어들었을 것이므로 변환하고 남은 나머지로 money를 줄여준다.
 *          - 전체 화폐단위에 대해 위 과정을 반복한다.
 */

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = putInWallet(money);

        return answer;
    }

    public static List<Integer> putInWallet(int money){

        // 화폐단위
        List<Integer> currency = List.of(50000, 10000, 5000, 1000, 500, 100, 50, 10, 1);

        // 각 화폐단위 사용횟수 기록할 리스트
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < currency.size(); i++){

            int now = currency.get(i);

            if (money >= now){
                result.add(money/now);
                money %= now;
            } else {
                result.add(0);
            }
        }
        return result;
    }
}
