package onboarding.problem5.utils;

public enum KoreaMoneyUnit {
    SINSAIMDANG(50000),
    SEJONG(10000),
    YULGOK(5000),
    YIHWANG(1000),
    HAK(500),
    SUNSHIN(100),
    BYEO(50),
    DABOTOP(10),
    ILWON(1);
    private final int unit;
    KoreaMoneyUnit(int unit){
        this.unit = unit;
    }

    public int getUnit(){
        return this.unit;
    }
}
