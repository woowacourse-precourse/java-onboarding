package onboarding;

import java.util.ArrayList;

class ListifyCryptogram {
    private ArrayList<Character> listCrypto = new ArrayList<>();
    private String finalCrypto = "";

    ListifyCryptogram(String cryptogram) throws RestrictException {
        if (cryptogram.length() > 1000 || cryptogram.length() < 1) {
            throw new RestrictException("OutOfRange");
        }
        for (int i = 0; i < cryptogram.length(); i++) {
            if ((int) cryptogram.charAt(i) > 122 || (int) cryptogram.charAt(i) < 97) {
                throw new RestrictException("NotSmallLetter");
            }
            listCrypto.add(cryptogram.charAt(i));
        }
    }

    public String decodeCrypto() {
        int initialSize = this.listCrypto.size();
        int i = 0;
        while (i++ <= initialSize / 2) {
            for (int j = 0; j < this.listCrypto.size() - 1; j++) {
                int howMany = 1;
                boolean isDuplicated = false;
                if (this.listCrypto.size() <= 2) {
                    if (this.listCrypto.get(0) == this.listCrypto.get(1)) {
                        this.listCrypto.remove(0);
                        this.listCrypto.remove(0);
                    }
                } else {
                    while ((j + howMany) < this.listCrypto.size() && this.listCrypto.get(j) == this.listCrypto.get(j + howMany)) {
                        howMany++;
                        isDuplicated = true;
                    }
                }
                if (isDuplicated) {
                    for (int k = 0; k < howMany; k++) {
                        this.listCrypto.remove(j);
                    }
                    j -= 1;
                }
            }
        }
        for (Character element : listCrypto) {
            finalCrypto += element;
        }
        return finalCrypto;
    }
}

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        try {
            ListifyCryptogram listedCryptogram = new ListifyCryptogram(cryptogram);
            answer = listedCryptogram.decodeCrypto();
        } catch (RestrictException e) {
            answer = e.exMsg;
        }
        return answer;
    }
}
