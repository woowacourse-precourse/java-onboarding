package onboarding.problem4;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DictionaryTest {

    private final Character[] characterMappingTable = {'Z','Y','X','W','V','U'
        ,'T','S','R','Q','P','O','N','M','L','K','J','I','H','G','F','E','D','C'
        ,'B','A',null,null,null,null,null,null,'z','y','x','w','v','u','t','s'
        ,'r','q','p','o','n','m','l','k','j','i','h', 'g','f','e','d','c','b','a'};
    Dictionary dictionary = new AlphabetDictionary(characterMappingTable);

    @Test
    void 알파벳을_청개구리의_알파벳으로_변환_성공() throws Exception {
        Character result = dictionary.change('A');

        assertThat(result).isEqualTo('Z');
    }

    @Test
    void 대문자_알파벳을_넣으면_청개구리의_대문자_알파벳으로_변환_성공() throws Exception {
        Character result = dictionary.change('Z');

        assertThat(result).isEqualTo('A');
    }

    @Test
    void 소문자_알파벳을_넣으면_청개구리의_소문자_알파벳으로_변환_성공() throws Exception {
        Character result = dictionary.change('c');

        assertThat(result).isEqualTo('x');
    }

    @Test
    void 빈칸이_주어질_경우_빈칸_반환() throws Exception {
        Character result = dictionary.change(' ');

        assertThat(result).isEqualTo(' ');
    }
}