package onboarding.problem2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackCalculatorTest {
    
    StackCalculator stackCalculator = new StringStackCalculator();
    
    StringMainStack stringMainStack;
    StringSubStack stringSubStack;
    
    @BeforeEach
    public void init() {
        stringMainStack = new StringMainStack();
        stringSubStack = new StringSubStack();
    }

    @Test
    void 메인_스택과_보조_스택의_최상위_문자가_같다면_제거_성공() throws Exception {
        stringMainStack.pushString("hello");
        stackCalculator.deleteDuplicatedCharacter(stringMainStack, stringSubStack);
        String result = stringSubStack.makeString();

        assertThat(result).isEqualTo("heo");
    }

    @Test
    void 메인_스택과_보조_스택의_문자를_삭제했다면_true를_반환() throws Exception {
        stringMainStack.pushString("hello");
        boolean result = stackCalculator.deleteDuplicatedCharacter(stringMainStack, stringSubStack);

        assertThat(result).isTrue();
    }



}