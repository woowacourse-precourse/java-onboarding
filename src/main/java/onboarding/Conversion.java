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

    String convert() {
        String convertWord = "";

        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                convertWord = convertWord.concat(String.valueOf((char)(capital - word.charAt(i))));
            } else if(word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                convertWord = convertWord.concat(String.valueOf((char)(small - word.charAt(i))));
            } else {
                convertWord = convertWord.concat(String.valueOf(word.charAt(i)));
            }
        }

        return convertWord;
    }
}
