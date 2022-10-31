package onboarding;

class Withdraw {
    int money;

    public Withdraw(int money) {
        this.money = money;
    }

    int exception() {
        if((money < 1) || (money > 1000000)) {
            return -1;
        }

        return 0;
    }
}
