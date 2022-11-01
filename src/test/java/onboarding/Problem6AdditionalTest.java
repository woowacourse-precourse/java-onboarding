package onboarding;

import onboarding.problem6.exception.CrewFormOutOfSizeException;
import onboarding.problem6.exception.FieldLengthOutOfSizeException;
import onboarding.problem6.exception.NotAllowDomainException;
import onboarding.problem6.exception.NotEmailFormException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class Problem6AdditionalTest {
    @Test
    @DisplayName("메일 오름차순으로 정렬되는지")
    void orderByMailAsc() {
        //given
        List<List<String>> forms = List.of(
                List.of("ccc@email.com", "가가"),
                List.of("eee@email.com", "가가나나"),
                List.of("aaa@email.com", "다가가다"),
                List.of("ddd@email.com", "라라가가"),
                List.of("bbb@email.com", "가가마마")
        );
        List<String> expect = List.of("aaa@email.com", "bbb@email.com", "ccc@email.com", "ddd@email.com", "eee@email.com");
        //when
        List<String> result = Problem6.solution(forms);
        //then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("닉네임 중복 없는 경우")
    void notOverlap() {
        //given
        List<List<String>> forms = List.of(
                List.of("ccc@email.com", "가가"),
                List.of("eee@email.com", "나나"),
                List.of("aaa@email.com", "다다"),
                List.of("ddd@email.com", "라라"),
                List.of("bbb@email.com", "마마")
        );
        List<String> expect = List.of();
        //when
        List<String> result = Problem6.solution(forms);
        //then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("닉네임 중복 케이스가 2개")
    void twoOverlapCase() {
        //given
        List<List<String>> forms = List.of(
                List.of("ccc@email.com", "가가"),
                List.of("eee@email.com", "가가나"),
                List.of("aaa@email.com", "마마"),
                List.of("ddd@email.com", "마마바"),
                List.of("bbb@email.com", "아아")
        );
        List<String> expect = List.of("aaa@email.com", "ccc@email.com", "ddd@email.com", "eee@email.com");
        //when
        List<String> result = Problem6.solution(forms);
        //then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("닉네임 이증 증복")
    void duplicateNicknameVerification() {
        //given
        List<List<String>> forms = List.of(
                List.of("ccc@email.com", "가가"),
                List.of("eee@email.com", "가가나"),
                List.of("aaa@email.com", "마마"),
                List.of("ddd@email.com", "마마바"),
                List.of("bbb@email.com", "아아가가마마")
        );
        List<String> expect = List.of("aaa@email.com","bbb@email.com", "ccc@email.com", "ddd@email.com", "eee@email.com");
        //when
        List<String> result = Problem6.solution(forms);
        //then
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("이메일 형식 부합하지 않음")
    void notSatisfiedEmailFormat() {
        //given
        List<List<String>> forms = List.of(
                List.of("ccc*email.com", "가가"),
                List.of("eee@email.com", "가가나"),
                List.of("aaa@email.com", "마마"),
                List.of("ddd@email.com", "마마바"),
                List.of("bbb@email.com", "아아가가마마")
        );
        //when
        //then
        assertThatThrownBy(() -> Problem6.solution(forms))
                .isInstanceOf(NotEmailFormException.class);
    }

    @Test
    @DisplayName("허용되지 않은 도메인")
    void notAllowDomain() {
        //given
        List<List<String>> forms = List.of(
                List.of("ccc@asdf.com", "가가"),
                List.of("eee@email.com", "가가나"),
                List.of("aaa@email.com", "마마"),
                List.of("ddd@email.com", "마마바"),
                List.of("bbb@email.com", "아아가가마마")
        );
        //when
        //then
        assertThatThrownBy(() -> Problem6.solution(forms))
                .isInstanceOf(NotAllowDomainException.class);
    }

    @Test
    @DisplayName("form element 형식 부합하지 않음")
    void notSatisfiedFormElement() {
        //given
        List<List<String>> forms = List.of(
                List.of("ccc@email.com", "가가", "추가적인 요소"),
                List.of("eee@email.com", "가가나"),
                List.of("aaa@email.com", "마마"),
                List.of("ddd@email.com", "마마바"),
                List.of("bbb@email.com", "아아가가마마")
        );
        //when
        //then
        assertThatThrownBy(() -> Problem6.solution(forms))
                .isInstanceOf(CrewFormOutOfSizeException.class);
    }

    @Test
    @DisplayName("닉네임 길이 초과")
    void OutOfSizeNicknameLength() {
        //given
        List<List<String>> forms = List.of(
                List.of("ccc@email.com", "가가가가가가가가가가가가가가가가가가가가가"),
                //21자
                List.of("eee@email.com", "가가나"),
                List.of("aaa@email.com", "마마"),
                List.of("ddd@email.com", "마마바"),
                List.of("bbb@email.com", "아아가가마마")
        );
        //when
        //then
        assertThatThrownBy(() -> Problem6.solution(forms))
                .isInstanceOf(FieldLengthOutOfSizeException.class);
    }

}
