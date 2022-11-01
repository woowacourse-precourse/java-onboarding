package onboarding.problem5;

public enum Cash {
    FIFTY_THOUSAND(50000),
    TEN_THOUSAND(10000),
    FIVE_THOUSAND(5000),
    THOUSAND(1000),
    FIVE_HUNDRED(500),
    HUNDRED(100),
    FIFTY(50),
    TEN(10),
    ONE(1);

    private int price;

    Cash(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
