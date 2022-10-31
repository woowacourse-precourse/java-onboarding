package onboarding.problem5.dto;

/**
 * 돈의 액수를 담고 있는 DTO 클래스입니다.
 * DTO 클래스이므로 setter 를 사용해 값을 수정할 수 있습니다.
 * @author BackFoxx
 */
public class MoneyDto {
    public static final String INVALID_MONEY_VALUE_MESSAGE = "money 값은 0보다 작아질 수 없습니다.";

    private Integer money;

    private MoneyDto(Integer money) {
        this.money = money;
    }

    /**
     * 인자로 들어온 값을 value 로 하는 MoneyDto 객체를 만드는 정적 팩토리 메소드입니다.
     */
    public static MoneyDto of(Integer money) {
        return new MoneyDto(money);
    }

    public Integer getMoney() {
        return money;
    }

    /**
     * 인자로 주어진 값으로 금액을 돈의 액수를 수정합니다.
     */
    public void changeMoney(Integer money) {
        if (money < 0) {
            throw new IllegalArgumentException(INVALID_MONEY_VALUE_MESSAGE);
        }
        this.money = money;
    }
}
