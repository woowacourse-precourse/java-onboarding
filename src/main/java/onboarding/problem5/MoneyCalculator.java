package onboarding.problem5;

import static onboarding.problem5.consts.MoneyConst.FIFTY_THOUSAND_WON;
import static onboarding.problem5.consts.MoneyConst.FIFTY_WON;
import static onboarding.problem5.consts.MoneyConst.FIVE_HUNDRED_WON;
import static onboarding.problem5.consts.MoneyConst.FIVE_THOUSAND_WON;
import static onboarding.problem5.consts.MoneyConst.ONE_HUNDRED_WON;
import static onboarding.problem5.consts.MoneyConst.ONE_THOUSAND_WON;
import static onboarding.problem5.consts.MoneyConst.ONE_WON;
import static onboarding.problem5.consts.MoneyConst.TEN_THOUSAND_WON;
import static onboarding.problem5.consts.MoneyConst.TEN_WON;

import java.util.ArrayList;
import java.util.List;

/**
 * 금액권을 몇 개 사용했는지 계산하는 클래스
 */
public class MoneyCalculator {

    /**
     * 사용할 모든 금액권의 종류를 가진 array
     */
    private static int[] moneyTypes = {FIFTY_THOUSAND_WON, TEN_THOUSAND_WON, FIVE_THOUSAND_WON,
        ONE_THOUSAND_WON, FIVE_HUNDRED_WON, ONE_HUNDRED_WON, FIFTY_WON, TEN_WON, ONE_WON};

    /**
     * new 연산자를 통한 생성을 방지하기 위한 private 기본 생성자
     */
    private MoneyCalculator() {
    }

    /**
     * 금액권을 몇 개 사용했는지 계산하는 메소드
     *
     * @param money 계산할 금액
     * @return 사용한 금액권의 개수 목록
     */
    public static List<Integer> calculateMoneyCount(int money) {
        List<Integer> moneyTypesCount = new ArrayList<>();

        for (int moneyType : moneyTypes) {
            moneyTypesCount.add(money / moneyType);
            money %= moneyType;
        }
        return moneyTypesCount;
    }
}