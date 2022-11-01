package onboarding.problem3.vo;

/**
 * 369게임 진행 중 3,6,9의 개수를 세야 하는 값을 보관하고 있는 VO 클래스입니다.
 * @author BackFoxx
 */
public class Number {
    private final Integer number;

    public Number(Integer number) {
        this.number = number;
    }

    /**
     * 인자로 들어온 값을 number 로 하는 Number 객체를 만드는 정적 팩토리 메소드입니다.
     */
    public static Number of(Integer number) {
        return new Number(number);
    }

    /**
     * 숫자 안에 있는 3, 6, 9의 개수를 계산해 반환합니다.
     * @return 숫자 안에 있는 3, 6, 9의 개수입니다.
     */
    public Integer getCountOfThreeSixNine() {
        return getNumberLength() - getCountWithoutThreeSixNine();
    }

    /**
     * 숫자의 총 길이를 반환합니다.
     * @return 숫자의 총 길이입니다.
     */
    private Integer getNumberLength() {
        String numberString = number.toString();
        return numberString.length();
    }

    /**
     * 숫자에서 '3', '6', '9'를 제외한 길이를 반환합니다.
     * @return '3', '6', '9'를 제외한 숫자의 길이입니다.
     */
    private Integer getCountWithoutThreeSixNine() {
        return number.toString()
                .replace("3", "")
                .replace("6", "")
                .replace("9", "")
                .length();
    }
}
