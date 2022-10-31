package onboarding.problem4;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TreeFrogTest {

    private final Character[] characterMappingTable = {'Z','Y','X','W','V','U'
        ,'T','S','R','Q','P','O','N','M','L','K','J','I','H','G','F','E','D','C'
        ,'B','A',null,null,null,null,null,null,'z','y','x','w','v','u','t','s'
        ,'r','q','p','o','n','m','l','k','j','i','h', 'g','f','e','d','c','b','a'};

    Dictionary dictionary = new AlphabetDictionary(characterMappingTable);
    TreeFrog frog = new TreeFrog(dictionary);

    @Test
    void 대문자로만_이루어진_문자열_변환_성공() throws Exception {
        String result = frog.makeTreeFrogWord("TREEFROG");

        assertThat(result).isEqualTo("GIVVUILT");
    }

    @Test
    void 소문자로만_이루어진_문자열_변환_성공() throws Exception {
        String result = frog.makeTreeFrogWord("wootecho");

        assertThat(result).isEqualTo("dllgvxsl");
    }

    @Test
    void 대문자와_소문자가_섞인_문자열_변환_성공() throws Exception {
        String result = frog.makeTreeFrogWord("WooTeCho TreeFrog Problem Solving");

        assertThat(result).isEqualTo("DllGvXsl GivvUilt Kilyovn Hloermt");
    }
}