package problem2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CipherTextDecoderTest {

    private CipherTextDecoder decoder;

    @BeforeEach
    void setUp() {
        decoder = new CipherTextDecoder();
    }

    @Test
    void 문자열의_각알파벳_list에_파싱() {
        String word = "abcde";
        List<Character> alphabets = decoder.parseToAlphabetList(word);

        assertThat(alphabets.get(0)).isEqualTo('a');
        assertThat(alphabets.get(word.length() - 1)).isEqualTo('e');
    }

    @Test
    void 암호문_한번_해독() {
        String word = "abbccd";
        String result = decoder.decode(word);

        assertThat(result).isEqualTo("ad");
    }
}
