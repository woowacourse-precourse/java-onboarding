package onboarding.Problem6Test;

import onboarding.Problem6;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
public class P6InputErrorTest {
    @Test
    void When_CrewNumError_Except_Fail(){
        List<List<String>> crewNumShortErrorForms = Collections.emptyList();
        assertThat(Problem6.solution(crewNumShortErrorForms)).isEqualTo(Collections.emptyList());

        List<List<String>> crewNumOverErrorForms = IntStream.rangeClosed(1, 10000)
                                                    .mapToObj(x -> List.of("email@email.com", "닉네임"))
                                                    .collect(Collectors.toList());
        assertThat(Problem6.solution(crewNumOverErrorForms)).isEqualTo(Collections.emptyList());
    }
    @Test
    void When_EmailError_Except_Fail(){
        List<List<String>> emailDomainErrorForms1 = List.of(List.of("test@a.com","닉네임"));
        assertThat(Problem6.solution(emailDomainErrorForms1)).isEqualTo(Collections.emptyList());
        List<List<String>> emailDomainErrorForms2 = List.of(List.of("test@email.c","닉네임"));
        assertThat(Problem6.solution(emailDomainErrorForms2)).isEqualTo(Collections.emptyList());
        List<List<String>> emailDomainErrorForms3 = List.of(List.of("test@acom","닉네임"));
        assertThat(Problem6.solution(emailDomainErrorForms3)).isEqualTo(Collections.emptyList());

        List<List<String>> emailLengthShortErrorForms = List.of(List.of("@email.com","닉네임"));
        assertThat(Problem6.solution(emailLengthShortErrorForms)).isEqualTo(Collections.emptyList());

        List<List<String>> emailLengthLongErrorForms = List.of(List.of("testtest20@email.com","닉네임"));
        assertThat(Problem6.solution(emailLengthLongErrorForms)).isEqualTo(Collections.emptyList());

        List<List<String>> nameLengthShortErrorForms = List.of(List.of("test@email.com",""));
        assertThat(Problem6.solution(nameLengthShortErrorForms)).isEqualTo(Collections.emptyList());

        List<List<String>> nameLengthLongErrorForms = List.of(List.of("test@email.com","가나다라마바사아자차카타파하가나다라마바"));
        assertThat(Problem6.solution(nameLengthLongErrorForms)).isEqualTo(Collections.emptyList());

        List<List<String>> nameNotKoreanErrorForms = List.of(List.of("test@email.com","abcd가나다123"));
        assertThat(Problem6.solution(nameNotKoreanErrorForms)).isEqualTo(Collections.emptyList());

        List<List<String>> noErrorForms = List.of(List.of("test@email.com","닉네임"));
        assertThat(Problem6.solution(noErrorForms)).isEqualTo(List.of("success@email.com"));

    }
}
