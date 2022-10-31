package onboarding.problem2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringMainStackTest {

    StringMainStack stringMainStack;

    @BeforeEach
    public void init() {
        stringMainStack = new StringMainStack();
    }

    @Test
    void 문자열을_스택에_넣을_수_있다() throws Exception {
        stringMainStack.pushString("hello");
        int result = stringMainStack.getStack().size();

        assertThat(result).isEqualTo(5);
    }

    @Test
    void 스택에_담긴_문자를_꺼낼_수_있다() throws Exception {
        stringMainStack.pushString("hello");
        Character character = stringMainStack.popCharacter();

        assertThat(character).isEqualTo('o');
    }

    @Test
    void 스택의_최상위_문자를_반환할_수_있다() throws Exception {
        stringMainStack.pushString("hello");
        Character result = stringMainStack.getPeek();

        assertThat(result).isEqualTo('o');
    }

    @Test
    void 스택이_비어있음_여부를_알_수_있다() throws Exception {
        boolean result = stringMainStack.isEmpty();

        assertThat(result).isTrue();
    }
}