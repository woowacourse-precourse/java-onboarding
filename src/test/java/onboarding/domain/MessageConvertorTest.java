package onboarding.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageConvertorTest {

    @Test
    @DisplayName("알파벳을 제외한 문자는 변환하지 않는다.")
    void 알파벳_제외_변환_x() {
        String beforeConvert = "&*()&*()";
        MessageConvertor messageConvertor = new MessageConvertor(beforeConvert);
        assertEquals(beforeConvert, messageConvertor.getConvertResult());
    }

    @Test
    @DisplayName("알파벳을 포함한 문자는 알파벳만 변환한다.")
    void 알파벳_변환_o() {
        String beforeConvert = "hi wooteco!";
        MessageConvertor messageConvertor = new MessageConvertor(beforeConvert);
        String afterConvert =  "sr dllgvxl!";
        assertEquals(afterConvert, messageConvertor.getConvertResult());
    }

}