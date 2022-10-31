package onboarding.problem2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringSubStackTest {

    StringSubStack stringSubStack;

    @BeforeEach
    public void init() {
        stringSubStack = new StringSubStack();
    }

    @Test
    void 문자를_받아_스택에_넣기_성공() throws Exception {
        stringSubStack.pushCharacter('a');
        Character result = stringSubStack.getStack().peek();

        assertThat(result).isEqualTo('a');
    }

    @Test
    void 스택에서_문자_꺼내기_성공() throws Exception {
        stringSubStack.pushCharacter('a');
        Character result = stringSubStack.popCharacter();

        assertThat(result).isEqualTo('a');
    }

    @Test
    void 스택에있는_문자를_모두_꺼내_문자열_만들기_성공() throws Exception {
        Character[] charArray = {'o','l','l','e','h'};
        for (Character c :charArray){
            stringSubStack.pushCharacter(c);
        }

        String result = stringSubStack.makeString();
        assertThat(result).isEqualTo("hello");
    }

    @Test
    void 스택의_최상위_문자를_반환할_수_있다() throws Exception {
        stringSubStack.pushCharacter('a');
        stringSubStack.pushCharacter('b');

        Character result = stringSubStack.getPeek();
        assertThat(result).isEqualTo('b');
    }

    @Test
    void 스택의_비어있음_여부를_알_수_있다() throws Exception {
        boolean result = stringSubStack.isEmpty();

        assertThat(result).isTrue();
    }
}