package onboarding;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Stack;

class Problem2Test {
    @Test
    void StringToCharStackTest() {
        Stack<Character> chars = Problem2.StringToCharStack("hello");
        for(Character c : chars){
            System.out.print(c);
        }
    }

    @Test
    void CharsToStringTest() {
        List<Character> chars = Problem2.StringToCharStack("hello");
        String string = Problem2.CharsToString(chars);
        System.out.println("string = " + string);
    }

    @Test
    void solutionTest(){
        System.out.println(Problem2.solution("browoanoommnaon"));
    }
}