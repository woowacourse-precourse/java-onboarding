package onboarding;

class Count369 {
    int number;

    public Count369(int number) {
        this.number = number;
    }

    int exception() {
        if((number < 1) || (number > 10000)) {
            return -1;
        } else {
            return 0;
        }
    }
}
