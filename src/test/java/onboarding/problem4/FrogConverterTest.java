package onboarding.problem4;

import onboarding.problem4.AlphabetConverter;
import onboarding.problem4.FrogConverter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class FrogConverterTest {
    AlphabetConverter converter = new FrogConverter();

    @Test
    public void 알파벳인지판단() throws Exception {
        //given
        char alphabet = 'A';
        
        //when
        boolean result = converter.isAlphabet(alphabet);

        //then
        Assertions.assertThat(result).isEqualTo(true);
    }
    
    @Test
    public void 리스트를합쳐String() throws Exception {
        //given
        List<Character> chars = new ArrayList<>(List.of('a', 'b', 'c', 'd'));
        
        //when
        String result = converter.listToString(chars);
        
        //then
        Assertions.assertThat(result).isEqualTo("abcd");
    }

    @Test
    public void 알파벳변환() throws Exception {
        //given
        char alphabet = 'z';

        //when
        char result = converter.convert(alphabet);

        //then
        Assertions.assertThat(result).isEqualTo('a');
    }

    @Test
    public void 단어변환() throws Exception {
        //given
        String word = "ABC123";

        //when
        String result = converter.convertWord(word);

        //then
        Assertions.assertThat(result).isEqualTo("ZYX123");
    }
}