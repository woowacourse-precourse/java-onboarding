package onboarding.problem4.controller;

import onboarding.problem4.domain.Sentence;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem4Test {
    @Test
    void case1() {
        String word = "I love you";
        String result = "R olev blf";
        assertThat(new Sentence(word).convert()).isEqualTo(result);
    }
    
    @Test
    void case2() {
        String word = "abc de";
        String result = "zyx wv";
        assertThat(new Sentence(word).convert()).isEqualTo(result);
    }
    
    @Test
    void case3() {
        String word = "AB CDE";
        String result = "ZY XWV";
        assertThat(new Sentence(word).convert()).isEqualTo(result);
    }
    
    @Test
    void case4() {
        String word = "AB @CDE";
        String result = "ZY @XWV";
        assertThat(new Sentence(word).convert()).isEqualTo(result);
    }
    
    @Test
    void case5() {
        String word = "AB 3CDE";
        String result = "ZY 3XWV";
        assertThat(new Sentence(word).convert()).isEqualTo(result);
    }
    
    @Test
    void case6() {
        String word = "AB 가CDE";
        String result = "ZY 가XWV";
        assertThat(new Sentence(word).convert()).isEqualTo(result);
    }
    
    @Test
    void case7() {
        String word = "A";
        String result = "Z";
        assertThat(new Sentence(word).convert()).isEqualTo(result);
    }
    
    @Test
    void case8() {
        String word = "a";
        String result = "z";
        assertThat(new Sentence(word).convert()).isEqualTo(result);
    }
    
    @Test
    void case9() {
        String word = "Z";
        String result = "A";
        assertThat(new Sentence(word).convert()).isEqualTo(result);
    }
    
    @Test
    void case10() {
        String word = "z";
        String result = "a";
        assertThat(new Sentence(word).convert()).isEqualTo(result);
    }
    
    @Test
    void case11() {
        String word = "n";
        String result = "m";
        assertThat(new Sentence(word).convert()).isEqualTo(result);
    }
    
    @Test
    void case12() {
        String word = "m";
        String result = "n";
        assertThat(new Sentence(word).convert()).isEqualTo(result);
    }
    
    @Test
    void case13() {
        String word = "N";
        String result = "M";
        assertThat(new Sentence(word).convert()).isEqualTo(result);
    }
    
    @Test
    void case14() {
        String word = "M";
        String result = "N";
        assertThat(new Sentence(word).convert()).isEqualTo(result);
    }
    
    @Test
    void case15() {
        String word = "    I     loVe     you    ";
        String result = "    R     olEv     blf    ";
        assertThat(new Sentence(word).convert()).isEqualTo(result);
    }
    
    @Test
    void case16() {
        String word = " ";
        String result = " ";
        assertThat(new Sentence(word).convert()).isEqualTo(result);
    }
    
    @Test
    void case17() {
        String word = "  ";
        String result = "  ";
        assertThat(new Sentence(word).convert()).isEqualTo(result);
    }
    
    @Test
    void case18() {
        String word = "zyx wv";
        String result = "abc de";
        assertThat(new Sentence(word).convert()).isEqualTo(result);
    }
    
    @Test
    void case19() {
        String word = "ZY XWV";
        String result = "AB CDE";
        assertThat(new Sentence(word).convert()).isEqualTo(result);
    }
    
    @Test
    void case20() {
        String word = "Hello  Everyone!";
        String result = "Svool  Veviblmv!";
        assertThat(new Sentence(word).convert()).isEqualTo(result);
    }
    
    @Test
    void case21() {
        String word = "    I     !loVe가.     \n''\"\"/@you10\\    ";
        String result = "    R     !olEv가.     \n''\"\"/@blf10\\    ";
        assertThat(new Sentence(word).convert()).isEqualTo(result);
    }
    
    @Test
    void case22() {
        String word = "abcdefghijklmnopqrstuvwxyz";
        String result = "zyxwvutsrqponmlkjihgfedcba";
        assertThat(new Sentence(word).convert()).isEqualTo(result);
    }
    
    @Test
    void case23() {
        String word = "abcdefghijklmnopqrstuvwxyz !@#!#  ";
        String result = "zyxwvutsrqponmlkjihgfedcba !@#!#  ";
        assertThat(new Sentence(word).convert()).isEqualTo(result);
    }
    
    @Test
    void case24() {
        String word = "Svool, Dliow! 123";
        String result = "Hello, World! 123";
        assertThat(new Sentence(word).convert()).isEqualTo(result);
    }
}
