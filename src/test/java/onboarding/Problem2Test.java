package onboarding;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static onboarding.Problem2.getCharacterStack;

class Problem2Test {

    @Test
    void 연속되는_중복_문자를_삭제하고_문자_stack_얻는다_소멸() {
        //given
        String cryptogram = "aeiouuoiea";

        //when
        Stack<Character> characterStack = getCharacterStack(cryptogram);

        //then
        Assertions.assertThat(characterStack).isEqualTo(new Stack<Character>());
        Assertions.assertThat(characterStack.empty()).isTrue();
    }

    @Test
    void 연속되는_중복_문자를_삭제하고_문자_stack_얻는다_남아있음() {
        //given
        String cryptogram = "aeiouuoiae";

        //when
        Stack<Character> characterStack = getCharacterStack(cryptogram);

        //then
        Stack<Character> stack = new Stack<>();
        stack.add('a');
        stack.add('e');
        stack.add('a');
        stack.add('e');
        Assertions.assertThat(characterStack).isEqualTo(stack);
        Assertions.assertThat(characterStack.empty()).isFalse();
    }
}
