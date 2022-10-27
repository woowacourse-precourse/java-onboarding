package onboarding.problem5;

import java.util.List;

public interface CurrencyExchanger {
    /**
     * 구현체 별 환전 정책에 따라 저장한 금액을 환전 했을 때 화폐 수를 계산하고 반환
     * @param money 를 객체에 저장하지 않은 이유는
     * 환전 이후 CurrencyExchanger money가 변동되어 exchange() 호출마다 값이 달라 질 것을 고려함.
     */
    List<Integer> exchange(int money);
}
