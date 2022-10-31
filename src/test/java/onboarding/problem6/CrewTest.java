package onboarding.problem6;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CrewTest {

    @Test
    void 크루와_다른_크루들을_비교했을때_나와_유사한_이름을_사용하는_크루들을_찾는다(){
        var crew = new Crew("sample1@mail.com", "제이");

        var actual = crew.existsCrewsWithSimilarNamesExceptMe(Arrays.asList(
                crew,
                new Crew("sample2@email.com","제이엠"),
                new Crew("sample3@emai.com","제이제이"),
                new Crew("sample4@email.com","킬제이"),
                new Crew("sample5@email.com","이제이")
        ));

        Assertions.assertThat(actual).isTrue();
    }

    @Test
    void 크루와_다른_크루들을_비교했을때_나와_유사한_이름을_사용하는_크루가_없으면_거짓을_반환합니다(){
        var me = new Crew("sample1@email.com","가나다");

        var actual = me.existsCrewsWithSimilarNamesExceptMe(Arrays.asList(
                me,
                new Crew("sample4","다라마"),
                new Crew("sample3", "바사아"),
                new Crew("sample5","자차카")
        ));
        Assertions.assertThat(actual).isFalse();
    }


}