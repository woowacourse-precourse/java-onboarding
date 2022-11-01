package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
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
