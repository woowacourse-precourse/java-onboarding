package onboarding.problem5;

public enum Money {
    // 오만 원권, 만 원권, 오천 원권, 천 원권, 오백원 동전, 백원 동전, 오십원 동전, 십원 동전, 일원 동전
    COIN_50000(50000),
    COIN_10000(10000),
    COIN_5000(5000),
    COIN_1000(1000),
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10),
    COIN_1(1),
    ;

    private int price;

    Money(int price) {
        this.price = price;
    }

    public int unit() {
        return price;
    }
}
