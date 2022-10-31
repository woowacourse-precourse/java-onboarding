package onboarding;

class Conversion {
    String word;
    int capital, small;

    public Conversion(String word) {
        this.word = word;
        this.capital = 'A' + 'Z';
        this.small = 'a' + 'z';
    }
}
