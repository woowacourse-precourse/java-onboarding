package onboarding.problem5;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class ChangesTest {
    @Test
    void 잔돈_테스트(){
        var changes = new Changes(1);
        assertThat(changes.changes()).isEqualTo(List.of(0,0,0,0,0,0,0,0,1));
    }
    @Test
    void _60만원이_들어가면_5만원권_12장입니다(){
         var changes = new Changes(600000);
         assertThat(changes.changes()).isEqualTo(List.of(12,0,0,0,0,0,0,0,0));
    }
    @Test
    void _11만1111원이_들어가면(){
        var changes = new Changes(111111);
        assertThat(changes.changes()).isEqualTo(List.of(2,1,0,1,0,1,0,1,1));
    }
}