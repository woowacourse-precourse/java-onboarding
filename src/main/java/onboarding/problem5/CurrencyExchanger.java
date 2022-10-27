package onboarding.problem5;

import java.util.List;

public interface CurrencyExchanger {
    /**
     * 구현체 별 환전 정책에 따라 저장한 금액을 환전 했을 때 화폐 수를 계산하고 반환
     */
    List<Integer> exchange();
}
