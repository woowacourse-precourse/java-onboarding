package onboarding.problem6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class EmailTest {

    @Test
    void 이메일을_호출하면_email_com_이_붙혀서_출력된니다(){
        var email = new Email("println@email.com");

        assertThat(email.email()).isEqualTo("println@email.com");
    }


    @Test
    void 이메일을_비교할경우_사전순으로_비교됩니다(){
        var a = new Email("a@email.com");
        var b = new Email("a0@email.com");

        assertThat(a).isLessThan(b);

    }

}