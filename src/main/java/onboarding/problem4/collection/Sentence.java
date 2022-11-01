package onboarding.problem4.collection;

import onboarding.problem4.vo.Spell;

import java.util.ArrayList;
import java.util.List;

/**
 * 청개구리가 거꾸로 읽을 문장의 철자 리스트를 보관하고 있는 일급 컬렉션입니다.
 * @author BackFoxx
 */
public class Sentence {
    private final List<Spell> spells;

    private Sentence(List<Spell> spells) {
        this.spells = spells;
    }

    /**
     * 인자로 들어온 문자열을 Spell 리스트로 바꾸어
     * Sentence 객체를 만드는 정적 팩토리 메소드입니다.
     */
    public static Sentence of(String sentence) {
        ArrayList<Spell> tmpSpellList = new ArrayList<>();
        for (char spell : sentence.toCharArray()) {
            tmpSpellList.add(Spell.of(spell));
        }
        return new Sentence(tmpSpellList);
    }

    /**
     * Sentence 객체가 갖고 있는 문장 전체를 거꾸로 읽어 반환하는 메소드입니다.
     * @return 문장을 거꾸로 읽은 결과가 적힌 문자열입니다.
     */
    public String reverse() {
        StringBuilder resultBuilder = new StringBuilder();
        spells.forEach(spell ->
                resultBuilder.append(spell.reverseSpell())
        );
        return resultBuilder.toString();
    }
}
