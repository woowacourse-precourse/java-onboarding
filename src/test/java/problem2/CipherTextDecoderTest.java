package problem2;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CipherTextDecoderTest {

    @Test
    void 문자열의_각알파벳_list에_파싱() {
        String word = "abcde";
        CipherTextDecoder decoder = new CipherTextDecoder();
        List<Character> result=  decoder.parseToAlphabetList(word);

        assertThat(result.get(0)).isEqualTo('a');
        assertThat(result.get(word.length() - 1)).isEqualTo('e');
    }
}
