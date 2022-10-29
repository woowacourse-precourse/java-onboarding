package onboarding.problem5.dto;

/**
 * 돈의 액수를 담고 있는 DTO 클래스입니다.
 * DTO 클래스이므로 setter 를 사용해 값을 수정할 수 있습니다.
 * @author BackFoxx
 */
public class MoneyDto {
    private Integer value;

    private MoneyDto(Integer money) {
        this.value = money;
    }

    /**
     * 인자로 들어온 값을 value 로 하는 MoneyDto 객체를 만드는 정적 팩토리 메소드입니다.
     */
    public static MoneyDto of(Integer money) {
        return new MoneyDto(money);
    }

    public Integer getMoney() {
        return value;
    }

    public void setMoney(Integer money) {
        this.value = money;
    }
}
