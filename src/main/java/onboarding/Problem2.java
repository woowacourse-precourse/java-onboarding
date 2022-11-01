package onboarding;

import java.util.HashSet;
import java.util.regex.Pattern;

public class Problem2 {

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    private static Pattern createConsecutiveDuplicatePattern(String cryptogram) {
        String createConsecutiveDuplicateRegex = createConsecutiveDuplicateRegex(cryptogram);
        return Pattern.compile(createConsecutiveDuplicateRegex);
    }

    private static String createConsecutiveDuplicateRegex(String cryptogram) {
        HashSet<Alphabet> useAlphabets = getUseAlphabets(cryptogram);

        StringBuilder consecutiveDuplicateRegex = new StringBuilder();
        useAlphabets.forEach((alphabet) ->
            consecutiveDuplicateRegex
                .append(alphabet.getConsecutiveDuplicateRegex())
                .append("|")
        );
        return consecutiveDuplicateRegex.toString();
    }

    private static HashSet<Alphabet> getUseAlphabets(String cryptogram) {
        HashSet<Alphabet> useAlphabets = new HashSet<>();
        for (int i = 0; i < cryptogram.length(); i++) {
            String useAlphabetName = cryptogram.substring(i, i + 1).toUpperCase();
            Alphabet useAlphabet = Alphabet.valueOf(useAlphabetName);
            useAlphabets.add(useAlphabet);
        }
        return useAlphabets;
    }

    private enum Alphabet {
        A("a"),
        B("b"),
        C("c"),
        D("d"),
        E("e"),
        F("f"),
        G("g"),
        H("h"),
        I("i"),
        J("j"),
        K("k"),
        L("l"),
        M("m"),
        N("n"),
        O("o"),
        P("p"),
        Q("q"),
        R("r"),
        S("s"),
        T("t"),
        U("u"),
        V("v"),
        W("w"),
        X("x"),
        Y("y"),
        Z("z");

        private final String lowerCase;

        Alphabet(String lowerCase) {
            this.lowerCase = lowerCase;
        }

        public String getConsecutiveDuplicateRegex() {
            return this.lowerCase + "{2,}";
        }
    }
}
