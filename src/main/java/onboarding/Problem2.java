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
        int searchIndex = 0;

        while (searchIndex < alphabets.length &&
                searchIndex + linkers[searchIndex].next < alphabets.length) {
            searchIndex = checkDuplicate(alphabets,searchIndex);
        }
    }

    private static int checkDuplicate(String[] alphabets, int searchIndex){

        int indexDelta = linkers[searchIndex].next;

        while (searchIndex + indexDelta < alphabets.length &&
                alphabets[searchIndex]
                        .equals(alphabets[searchIndex + indexDelta])) {
            indexDelta += linkers[searchIndex + indexDelta].next;
        }

        //연속되는 알파벳이 없을 때
        if (indexDelta == linkers[searchIndex].next) {
            return searchIndex + indexDelta;
        }

        //인덱스 연결
        if (searchIndex + indexDelta < linkers.length) {
            linkers[searchIndex + indexDelta].before =
                    (linkers[searchIndex].before - indexDelta);
        }
        if (searchIndex + linkers[searchIndex].before >= 0) {
            linkers[searchIndex + linkers[searchIndex].before].next += indexDelta;
        }


        //연속되는 알파벳이 있고 특수하지 않을 때
        if (searchIndex + linkers[searchIndex].before >= 0 &&
                searchIndex + indexDelta < linkers.length) {
            return searchIndex + linkers[searchIndex].before;
        }

        //연속된 알파벳이 제일 첫번째 알파벳일 때
        if (searchIndex + linkers[searchIndex].before < 0) {
            startIndex = searchIndex + indexDelta;
        }

        return searchIndex + indexDelta;
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