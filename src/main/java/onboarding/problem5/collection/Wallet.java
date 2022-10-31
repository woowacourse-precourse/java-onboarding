package onboarding.problem5.collection;

import onboarding.problem5.dto.MoneyDto;
import onboarding.problem5.validation.WalletValidator;
import onboarding.problem5.vo.Change;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 단위별 잔돈 수를 int 배열로 가지고 있는 일급 컬렉션입니다.
 * @author BackFoxx
 */
public class Wallet {
    private final int[] changes;

    private Wallet() {
        this.changes = new int[9];
    }

    /**
     * 기본값 0인 길이 9의 int 배열을 초기화하여 Wallet 객체를 반환하는 정적 팩토리 메소드입니다.
     */
    public static Wallet makeNewWallet() {
        return new Wallet();
    }

    /**
     * 단위별 잔돈 수를 List<Integer> 형태로 반환하는 메소드입니다.
     */
    public List<Integer> getChanges() {
        return Arrays.stream(changes).boxed().collect(Collectors.toList());
    }

    /**
     * 인자로 들어온 돈을 분석해 가장 적은 숫자의 잔돈 수로 바꾸고,
     * 단위별 잔돈 수를 List<Integer> 형태로 반환하는 메소드입니다.
     * @param money 잔돈으로 바꾸려는 돈 액수입니다.
     * @return 단위별 잔돈 수가 담긴 List 입니다.
     */
    public List<Integer> saveMoney(int money) {
        WalletValidator.validate(money);
        MoneyDto moneyDto = MoneyDto.of(money);

        Stream.of(Change.values())
                .forEach(change -> saveAsChange(moneyDto, change));

        return getChanges();
    }

    /**
     * 인자로 들어온 돈과 잔돈 단위를 분석해
     * 해당 단위로 돈을 바꾸어 Wallet 에 저장하고,
     * 남은 액수를 MoneyDto 의 값에 저장하는 메소드입니다.
     * @param money 잔돈으로 바꿀 액수입니다.
     * @param change 바꿀 잔돈 단위입니다.
     */
    private void saveAsChange(MoneyDto money, Change change) {
        changes[change.getIndex()] = money.getMoney() / change.getValue();
        money.changeMoney(money.getMoney() % change.getValue());
    }
}
