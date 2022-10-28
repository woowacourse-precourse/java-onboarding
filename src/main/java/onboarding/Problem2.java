package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        BrownCiphertext Ciphertext = new BrownCiphertext(cryptogram);
        answer = BrownCiphertextDecoder.decode(Ciphertext);
        return answer;
    }
}

class BrownCiphertext {
    private final String ciphertext;

    BrownCiphertext(String ciphertext) {
        this.ciphertext = ciphertext;
    }

    public String[] divideCiphertext() {
        return ciphertext.split("");
    }

}

class IndexLinker {
    public int before = -1;
    public int next = 1;

}

class BrownCiphertextDecoder {
    private static IndexLinker[] linkers;
    private static int startIndex;

    public static String decode(BrownCiphertext ciphertext) {
        String[] arrayChar = ciphertext.divideCiphertext();
        linkers = new IndexLinker[arrayChar.length];
        for (int i = 0; i < arrayChar.length; i++) {
            linkers[i] = new IndexLinker();
        }

        startIndex = 0;

        excludeDuplicate(arrayChar);
        return makeCode(arrayChar);
    }

    private static void excludeDuplicate(String[] alphabets){
        int progressIndex = 0;

        while (progressIndex + linkers[progressIndex].next < alphabets.length) {
            progressIndex = checkDuplicate(alphabets,progressIndex);
        }
    }

    private static int checkDuplicate(String[] alphabets, int progressIndex){

        int indexDelta = linkers[progressIndex].next;

        while (progressIndex + indexDelta < alphabets.length &&
                alphabets[progressIndex]
                        .equals(alphabets[progressIndex + indexDelta])) {
            indexDelta++;
        }

        if (indexDelta == linkers[progressIndex].next) {
            return progressIndex + indexDelta;
        }

        if (progressIndex > 0 &&
                progressIndex + indexDelta < linkers.length) {
            linkers[progressIndex + linkers[progressIndex].before].next += indexDelta;
            linkers[progressIndex + indexDelta].before -= indexDelta;

            return progressIndex + linkers[progressIndex].before;
        }

        if (progressIndex + linkers[progressIndex].before < 0) {
            progressIndex = indexDelta;
            startIndex = progressIndex;
        }

        if (progressIndex + indexDelta >= linkers.length) {
            linkers[progressIndex + linkers[progressIndex].before].next += indexDelta;
            progressIndex++;
        }

        return progressIndex;
    }

    private static String makeCode(String[] alphabets) {
        String decodedCode = "";

        while (startIndex < alphabets.length) {
            decodedCode += alphabets[startIndex];
            startIndex += linkers[startIndex].next;
        }

        return decodedCode;
    }
}