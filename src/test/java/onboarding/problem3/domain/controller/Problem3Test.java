package onboarding.problem3.domain.controller;

import onboarding.problem3.domain.Numbers;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem3Test {
    @Test
    void case1() {
        int number = 13;
        int result = 4;
        assertThat(new Numbers(number).sumCountOfMultipleOfThree()).isEqualTo(result);
    }
    
    @Test
    void case2() {
        int number = 33;
        int result = 14;
        assertThat(new Numbers(number).sumCountOfMultipleOfThree()).isEqualTo(result);
    }
    
    @Test
    void case3() {
        int number = 1;
        int result = 0;
        assertThat(new Numbers(number).sumCountOfMultipleOfThree()).isEqualTo(result);
    }
    
    @Test
    void case4() {
        int number = 10;
        int result = 3;
        assertThat(new Numbers(number).sumCountOfMultipleOfThree()).isEqualTo(result);
    }
    
    @Test
    void case5() {
        int number = 40;
        int result = 22;
        assertThat(new Numbers(number).sumCountOfMultipleOfThree()).isEqualTo(result);
    }
    
    @Test
    void case6() {
        int number = 2;
        int result = 0;
        assertThat(new Numbers(number).sumCountOfMultipleOfThree()).isEqualTo(result);
    }
    
    @Test
    void case7() {
        int number = 3;
        int result = 1;
        assertThat(new Numbers(number).sumCountOfMultipleOfThree()).isEqualTo(result);
    }
    
    @Test
    void case8() {
        int number = 4;
        int result = 1;
        assertThat(new Numbers(number).sumCountOfMultipleOfThree()).isEqualTo(result);
    }
    
    @Test
    void case9() {
        int number = 5;
        int result = 1;
        assertThat(new Numbers(number).sumCountOfMultipleOfThree()).isEqualTo(result);
    }
    
    @Test
    void case10() {
        int number = 6;
        int result = 2;
        assertThat(new Numbers(number).sumCountOfMultipleOfThree()).isEqualTo(result);
    }
    
    @Test
    void case11() {
        int number = 7;
        int result = 2;
        assertThat(new Numbers(number).sumCountOfMultipleOfThree()).isEqualTo(result);
    }
    
    @Test
    void case12() {
        int number = 8;
        int result = 2;
        assertThat(new Numbers(number).sumCountOfMultipleOfThree()).isEqualTo(result);
    }
    
    @Test
    void case13() {
        int number = 9;
        int result = 3;
        assertThat(new Numbers(number).sumCountOfMultipleOfThree()).isEqualTo(result);
    }
    
    @Test
    void case14() {
        int number = 100;
        int result = 60;
        assertThat(new Numbers(number).sumCountOfMultipleOfThree()).isEqualTo(result);
    }
    
    @Test
    void case15() {
        int number = 1000;
        int result = 900;
        assertThat(new Numbers(number).sumCountOfMultipleOfThree()).isEqualTo(result);
    }
    
    @Test
    void case16() {
        int number = 10000;
        int result = 12000;
        assertThat(new Numbers(number).sumCountOfMultipleOfThree()).isEqualTo(result);
    }
    
    @Test
    void case17() {
        int number = 333;
        int result = 228;
        assertThat(new Numbers(number).sumCountOfMultipleOfThree()).isEqualTo(result);
    }
}
