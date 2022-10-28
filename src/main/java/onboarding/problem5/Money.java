package onboarding.problem5;

public enum Money {
    오만원(50000),
    만원(10000),
    오천원(5000),
    천원(1000),
    오백원(500),
    백원(100),
    오십원(50),
    십원(10),
    일원(1);

    private final int value;

    Money(int value){
        this.value =value;
    }

    public int countIn(int bill) {
        return bill / this.value;
    }
    public int usedBill(int bill) {
        return this.value * countIn(bill);
    }
}
