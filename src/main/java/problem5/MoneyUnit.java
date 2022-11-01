package problem5;

public enum MoneyUnit {
    _50000WON(50000), _10000WON(10000), _5000WON(5000),
    _1000WON(1000), _500WON(500), _100WON(100),
    _50WON(50), _10WON(10), _1WON(1);

    private int price;

    MoneyUnit(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
