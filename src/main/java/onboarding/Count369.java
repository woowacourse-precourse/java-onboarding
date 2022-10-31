package onboarding;

class Count369 {
    int number;

    public Count369(int number) {
        this.number = number;
    }

    int exception() {
        if((number < 1) || (number > 10000)) {
            return -1;
        }

        return 0;
    }

    int count() {
        int cnt = 0, cur;

        for(int i = 1; i <= number; i++) {
            cur = i;

            while(cur > 0) {
                if((cur % 10 == 3) || (cur % 10 == 6) || (cur % 10 == 9)) {
                    cnt++;
                }

                cur = cur / 10;
            }
        }

        return cnt;
    }
}
