package onboarding.problem6.finder;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class DuplicateWarningCrewFinderTest {

    @Test
    public void nicknameSubsetTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        CrewFinder validator = new DuplicateWarningCrewFinder();

        Method method = validator.getClass().getDeclaredMethod("getNickNameSubset", String.class);
        method.setAccessible(true);

        @SuppressWarnings("unchecked")
        Set<String> ret1 = (Set<String>) method.invoke(validator, "닉네임");
        Set<String> exp1 = new HashSet<>(List.of("닉네", "네임"));
        assertThat(ret1.equals(exp1)).isEqualTo(true);

        @SuppressWarnings("unchecked")
        Set<String> ret2 = (Set<String>) method.invoke(validator, "닉네임");
        Set<String> exp2 = new HashSet<>(List.of("네임", "닉네"));
        assertThat(ret2.equals(exp2)).isEqualTo(true);

        @SuppressWarnings("unchecked")
        Set<String> ret3 = (Set<String>) method.invoke(validator, "닉");
        Set<String> exp3 = new HashSet<>(List.of("닉"));
        assertThat(ret3.equals(exp3)).isEqualTo(true);
    }

}