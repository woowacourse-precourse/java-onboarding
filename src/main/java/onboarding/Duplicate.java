package onboarding;

class Duplicate {
    String cryptogram;

    public Duplicate(String cryptogram) {
        this.cryptogram = cryptogram;
    }

    int exception() {
        if((cryptogram.length() < 1) || (cryptogram.length() > 1000)) {
            return -1;
        }

        for(int i = 0; i < cryptogram.length(); i++) {
            if(!((cryptogram.charAt(i) >= 'a') && (cryptogram.charAt(i) >= 'z'))) {
                return -1;
            }
        }

        return 0;
    }
}
