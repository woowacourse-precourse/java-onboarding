package onboarding;



public class Problem4 {

    private static final String SPECIAL_SYMBOL= "[^a-zA-Z\\d]";
    private static final String BLANK_SPACE= " ";

    public static String solution(String word) {
        StringBuilder result = new StringBuilder();
        for (Character c : word.toCharArray()) {
            result.append(mapCharByDictionary(c));
        }
        return result.toString();
    }

    private static Character mapCharByDictionary(Character c) {
        if (isAlpha(c)) {
            Dictionary mapped = Enum.valueOf(Dictionary.class, c.toString());
            return mapped.word();
        }
        return c;
    }

    private static boolean isAlpha(Character c) {
        String toStr = String.valueOf(c);
        return !toStr.matches(SPECIAL_SYMBOL) && !toStr.equals(BLANK_SPACE);
    }

    public enum Dictionary {
        A('Z'),
        B('Y'),
        C('X'),
        D('W'),
        E('V'),
        F('U'),
        G('T'),
        H('S'),
        I('R'),
        J('Q'),
        K('P'),
        L('O'),
        M('N'),
        N('M'),
        O('L'),
        P('K'),
        Q('J'),
        R('I'),
        S('H'),
        T('G'),
        U('F'),
        V('E'),
        W('D'),
        X('C'),
        Y('B'),
        Z('A'),
        a('z'),
        b('y'),
        c('x'),
        d('w'),
        e('v'),
        f('u'),
        g('t'),
        h('s'),
        i('r'),
        j('q'),
        k('p'),
        l('o'),
        m('n'),
        n('m'),
        o('l'),
        p('k'),
        q('j'),
        r('i'),
        s('h'),
        t('g'),
        u('f'),
        v('e'),
        w('d'),
        x('c'),
        y('b'),
        z('a');

        public Character word() { return word;}

        private final Character word;

        Dictionary(Character word) {
            this.word = word;
        }
    }
}
