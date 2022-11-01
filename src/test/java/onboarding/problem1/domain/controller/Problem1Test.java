package onboarding.problem1.domain.controller;

import onboarding.problem1.domain.Players;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Problem1Test {
    @Test
    void case1() {
        List<Integer> pobi = List.of(97, 98);
        List<Integer> crong = List.of(197, 198);
        int result = 0;
        assertThat(new Players(pobi, crong).playResult()).isEqualTo(result);
    }
    
    @Test
    void case2() {
        List<Integer> pobi = List.of(131, 132);
        List<Integer> crong = List.of(211, 212);
        int result = 1;
        assertThat(new Players(pobi, crong).playResult()).isEqualTo(result);
    }
    
    @Test
    void case3() {
        List<Integer> pobi = List.of(99, 102);
        List<Integer> crong = List.of(211, 212);
        int result = -1;
        assertThat(new Players(pobi, crong).playResult()).isEqualTo(result);
    }
    
    @Test
    void case4() {
        List<Integer> pobi = List.of(99, 98);
        List<Integer> crong = List.of(211, 212);
        int result = -1;
        assertThat(new Players(pobi, crong).playResult()).isEqualTo(result);
    }
    
    @Test
    void case5() {
        List<Integer> pobi = List.of(98, 99);
        List<Integer> crong = List.of(211, 212);
        int result = -1;
        assertThat(new Players(pobi, crong).playResult()).isEqualTo(result);
    }
    
    @Test
    void case6() {
        List<Integer> pobi = List.of(211, 212);
        List<Integer> crong = List.of(99, 102);
        int result = -1;
        assertThat(new Players(pobi, crong).playResult()).isEqualTo(result);
    }
    
    @Test
    void case7() {
        List<Integer> pobi = List.of(211, 212);
        List<Integer> crong = List.of(99, 98);
        int result = -1;
        assertThat(new Players(pobi, crong).playResult()).isEqualTo(result);
    }
    
    @Test
    void case8() {
        List<Integer> pobi = List.of(211, 212);
        List<Integer> crong = List.of(98, 99);
        int result = -1;
        assertThat(new Players(pobi, crong).playResult()).isEqualTo(result);
    }
    
    @Test
    void case9() {
        List<Integer> pobi = List.of(3, 4);
        List<Integer> crong = List.of(11, 12);
        int result = 1;
        assertThat(new Players(pobi, crong).playResult()).isEqualTo(result);
    }
    
    @Test
    void case10() {
        List<Integer> pobi = List.of(11, 12);
        List<Integer> crong = List.of(11, 12);
        int result = 0;
        assertThat(new Players(pobi, crong).playResult()).isEqualTo(result);
    }
    
    @Test
    void case11() {
        List<Integer> pobi = List.of(1, 2);
        List<Integer> crong = List.of(397, 398);
        int result = -1;
        assertThat(new Players(pobi, crong).playResult()).isEqualTo(result);
    }
    
    @Test
    void case12() {
        List<Integer> pobi = List.of(3, 4);
        List<Integer> crong = List.of(399, 400);
        int result = -1;
        assertThat(new Players(pobi, crong).playResult()).isEqualTo(result);
    }
    
    @Test
    void case13() {
        List<Integer> pobi = List.of(3, 4);
        List<Integer> crong = List.of(397, 398);
        int result = 2;
        assertThat(new Players(pobi, crong).playResult()).isEqualTo(result);
    }
    
    @Test
    void case14() {
        List<Integer> pobi = List.of(401, 402);
        List<Integer> crong = List.of(211, 212);
        int result = -1;
        assertThat(new Players(pobi, crong).playResult()).isEqualTo(result);
    }
    
    @Test
    void case15() {
        List<Integer> pobi = List.of(99, 100);
        List<Integer> crong = List.of(-1, 0);
        int result = -1;
        assertThat(new Players(pobi, crong).playResult()).isEqualTo(result);
    }
}
