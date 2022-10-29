package onboarding.billcounter;

public enum BillUnit {
	OH_MAN_WON(50_000),
	MAN_WON(10_000),
	OH_CHAN_WON(5_000),
	CHAN_WON(1_000),
	OH_BAK_WON(500),
	BAK_WON(100),
	SHEEP_WON(10),
	ILL_ONE(1);

	private final int money;

	BillUnit(int money) {
		this.money = money;
	}

	public int getMoney() {
		return money;
	}
}
