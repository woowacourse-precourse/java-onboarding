package onboarding.problem4.vo;

/**
 * 청개구리가 거꾸로 읽을 철자를 보관하고 있는 VO 클래스입니다.
 * @author BackFoxx
 */
public class Spell {
    private final char spell;

    private Spell(char spell) {
        this.spell = spell;
    }

    /**
     * 인자로 들어온 값을 spell 로 하는 Spell 객체를 만드는 정적 팩토리 메소드입니다.
     */
    public static Spell of(char spell) {
        return new Spell(spell);
    }

    /**
     * Spell 의 값을 거꾸로 읽어 반환하는 메소드입니다.
     * 소문자는 소문자로, 대문자는 대문자로 바꾸어 반환합니다.
     * @return 거꾸로 읽은 Spell 의 결과값입니다.
     */
    public char reverseSpell() {
        if (Character.isLowerCase(spell)) {
            return reverseLowerCase();
        } else if (Character.isUpperCase(spell)) {
            return reverseUpperCase();
        }
        return spell;
    }

    /**
     * 대문자인 Spell 의 값을 거꾸로 읽어 반환하는 메소드입니다.
     * @return 거꾸로 읽은 Spell 의 결과값입니다.
     */
    private char reverseUpperCase() {
        return (char)('Z' - (spell - 'A'));
    }

    /**
     * 소문자인 Spell 의 값을 거꾸로 읽어 반환하는 메소드입니다.
     * @return 거꾸로 읽은 Spell 의 결과값입니다.
     */
    private char reverseLowerCase() {
        return (char)('z' - (spell - 'a'));
    }
}
