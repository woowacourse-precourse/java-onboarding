package onboarding.problem4.service;

import onboarding.problem4.collection.Sentence;
import onboarding.problem4.validation.BlueFrogValidator;

/**
 * 청개구리의 엄마말 거꾸로 읽기와 관련된 비즈니스 로직을 진행하는 서비스 레이어 클래스입니다.
 * @author BackFoxx
 */
public class BlueFrogService {
    /**
     * 인자로 들어온 엄마의 문자열을 알고리즘에 따라 거꾸로 읽어 반환하는 메소드입니다.
     * @param speech 거꾸로 읽을 문자열입니다.
     * @return 거꾸로 읽힌 결과물입니다.
     */
    public static String reverseMotherSpeech(String speech) {
        BlueFrogValidator.validate(speech);
        Sentence sentence = Sentence.of(speech);
        return sentence.reverse();
    }
}
