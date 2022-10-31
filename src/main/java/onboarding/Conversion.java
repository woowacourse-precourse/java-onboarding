package onboarding;

class Conversion {
    String word;
    int capital, small;

    public Conversion(String word) {
        this.word = word;
        this.capital = 'A' + 'Z';
        this.small = 'a' + 'z';
    }

    int exception() {
        if((word.length() < 1) || (word.length() > 1000)) {
            return -1;
        }

        return 0;
    }


}
