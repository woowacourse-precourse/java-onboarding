package problem4;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SentenceTranslatorTest {

    @Test
    void 알파벳_한개를_변환() {
        SentenceTranslator translator = new SentenceTranslator();
        char result1 = translator.translate('A');
        char result2 = translator.translate('I');
        char result3 = translator.translate('Z');

        assertThat(result1).isEqualTo('Z');
        assertThat(result2).isEqualTo('R');
        assertThat(result3).isEqualTo('A');
    }
}
