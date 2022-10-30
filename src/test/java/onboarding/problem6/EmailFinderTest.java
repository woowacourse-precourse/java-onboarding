package onboarding.problem6;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class EmailFinderTest {

    EmailFinder emailFinder = new DuplicatedNicknameUserEmailFinder();

    @Test
    void 중복되는_닉네임_없을시_빈배열_반환() throws Exception {
        List<List<String>> input = List.of(List.of("abc@email.com","닉네임"),List.of("def@email.com","다르다"));
        List<String> result = emailFinder.findDuplicatedNicknameUserEmail(
            input);

        assertThat(result).isEmpty();
    }

    @Test
    void 중복되는_문자가1개일때는_포함되지않는다() throws Exception {
        List<List<String>> input = List.of(List.of("abc@email.com","닉네임"),List.of("def@email.com","닉르다"));
        List<String> result = emailFinder.findDuplicatedNicknameUserEmail(
            input);

        assertThat(result).isEmpty();
    }

    @Test
    void 중복되는_문자2개가_연속으로_있지않다면_포함되지않는다() throws Exception {
        List<List<String>> input = List.of(List.of("abc@email.com","닉네임"),List.of("def@email.com","닉르임"));
        List<String> result = emailFinder.findDuplicatedNicknameUserEmail(
            input);

        assertThat(result).isEmpty();
    }

    @Test
    void 중복되는_문자가2개_연속으로_있다면_포함된다() throws Exception {
        List<List<String>> input = List.of(List.of("abc@email.com","닉네임"),List.of("def@email.com","닉네다"));
        List<String> result = emailFinder.findDuplicatedNicknameUserEmail(
            input);

        assertThat(result).contains("abc@email.com","def@email.com");
    }

    @Test
    void 두_닉네임의_길이가_달라도_문자2개_연속으로_있다면_포함된다() throws Exception {
        List<List<String>> input = List.of(List.of("abc@email.com","닉네임입니다"),List.of("def@email.com","임입"));
        List<String> result = emailFinder.findDuplicatedNicknameUserEmail(
            input);

        assertThat(result).contains("abc@email.com","def@email.com");
    }

    @Test
    void 닉네임이_한_글자일_때_포함하지_않는다() throws Exception {
        List<List<String>> input = List.of(List.of("abc@email.com","닉"),List.of("def@email.com","닉네임"));
        List<String> result = emailFinder.findDuplicatedNicknameUserEmail(
            input);

        assertThat(result).isEmpty();
    }
}