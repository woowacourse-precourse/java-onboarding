package onboarding.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmailSenderTest {
    @Test
    @DisplayName("중복된 크루 x")
    void 중복된_크루가_없을_경우_빈리스트() {
        EmailSender emailSender = new EmailSender(List.of(
                List.of("abc@email.com", "미르"),
                List.of("def@email.com", "케이"),
                List.of("des@email.com", "살라"),
                List.of("bsf@email.com", "포비"),
                List.of("akv@email.com", "크롱")
        ));
        List<String> result = Collections.emptyList();
        assertEquals(result, emailSender.sendEmail());
    }

    @Test
    @DisplayName("중복된 크루 o")
    void 중복된_크루가_있을_경우_크루들의_이메일_반환() {
        EmailSender emailSender = new EmailSender(List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        ));
        List<String> result = List.of("jason@email.com", "jm@email.com", "mj@email.com");
        assertEquals(result, emailSender.sendEmail());
    }

    @Test
    @DisplayName("결과는 정렬되어 출력된다.")
    void 순서_보장_테스트() {
        EmailSender emailSender = new EmailSender(List.of(
                List.of("abc@email.com", "엠제이"),
                List.of("def@email.com", "엠제이"),
                List.of("des@email.com", "엠제이"),
                List.of("bsf@email.com", "엠제이"),
                List.of("akv@email.com", "엠제이")
        ));
        List<String> result = List.of("abc@email.com", "akv@email.com", "bsf@email.com", "def@email.com", "des@email.com");
        System.out.println(emailSender.sendEmail());
        assertEquals(result, emailSender.sendEmail());
    }
}