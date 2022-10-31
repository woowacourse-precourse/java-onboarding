package onboarding.domain.problem4;

import java.util.ArrayList;
import java.util.List;


public class Frog {
    private Word word;
    public Frog() {
        this("noInput");
    }
    public Frog(String word) {
        this.word = new Word(word);
    }

    public char change(char alphabet) {
        if (Character.isUpperCase(alphabet))
            return (char)(155 - alphabet);
        return (char)(219 - alphabet);
    }

    public String say() {
        List<Character> outWord = new ArrayList<>();
        char chr;
        for (int i=0; i<word.length();i++) {
            chr = word.get(i);
            if (Character.isAlphabetic(chr))
                chr = change(chr);
            outWord.add(chr);
        }
        return join(outWord);
    }

    private String join(List<Character> outWord) {
        String outString = "";
        for (int i=0; i<outWord.size();i++) {
            outString += outWord.get(i);
        }
        return outString;
    }
}
