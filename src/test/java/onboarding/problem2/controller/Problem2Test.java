package onboarding.problem2.controller;

import onboarding.problem2.domain.Decryptor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Problem2Test {
    @Test
    void case1() {
        String cryptogram = "browoanoommnaon";
        String result = "brown";
        final Decryptor decryptor = new Decryptor(cryptogram);
        decryptor.decrypt();
        
        assertThat(decryptor.getCryptogram()).isEqualTo(result);
    }
    
    @Test
    void case2() {
        String cryptogram = "zyelleyz";
        String result = "";
        final Decryptor decryptor = new Decryptor(cryptogram);
        decryptor.decrypt();
    
        assertThat(decryptor.getCryptogram()).isEqualTo(result);
    }
    
    @Test
    void case3() {
        String cryptogram = "a";
        String result = "a";
        final Decryptor decryptor = new Decryptor(cryptogram);
        decryptor.decrypt();
    
        assertThat(decryptor.getCryptogram()).isEqualTo(result);
    }
    
    @Test
    void case4() {
        String cryptogram = "aa";
        String result = "";
        final Decryptor decryptor = new Decryptor(cryptogram);
        decryptor.decrypt();
    
        assertThat(decryptor.getCryptogram()).isEqualTo(result);
    }
    
    @Test
    void case5() {
        String cryptogram = "abababab";
        String result = "abababab";
        final Decryptor decryptor = new Decryptor(cryptogram);
        decryptor.decrypt();
    
        assertThat(decryptor.getCryptogram()).isEqualTo(result);
    }
    
    @Test
    void case6() {
        String cryptogram = "aaaabbbb";
        String result = "";
        final Decryptor decryptor = new Decryptor(cryptogram);
        decryptor.decrypt();
    
        assertThat(decryptor.getCryptogram()).isEqualTo(result);
    }
    
    @Test
    void case7() {
        String cryptogram = "aaaacbbbb";
        String result = "c";
        final Decryptor decryptor = new Decryptor(cryptogram);
        decryptor.decrypt();
    
        assertThat(decryptor.getCryptogram()).isEqualTo(result);
    }
    
    @Test
    void case8() {
        String cryptogram = "aaaabcbbb";
        String result = "bcb";
        final Decryptor decryptor = new Decryptor(cryptogram);
        decryptor.decrypt();
    
        assertThat(decryptor.getCryptogram()).isEqualTo(result);
    }
    
    @Test
    void case9() {
        String cryptogram = "aaa";
        String result = "a";
        final Decryptor decryptor = new Decryptor(cryptogram);
        decryptor.decrypt();
    
        assertThat(decryptor.getCryptogram()).isEqualTo(result);
    }
    
    @Test
    void case10() {
        String cryptogram = "zyellleyz";
        String result = "";
        final Decryptor decryptor = new Decryptor(cryptogram);
        decryptor.decrypt();
    
        assertThat(decryptor.getCryptogram()).isEqualTo(result);
    }
    
    @Test
    void case11() {
        String cryptogram = "saddaas";
        String result = "sas";
        final Decryptor decryptor = new Decryptor(cryptogram);
        decryptor.decrypt();
    
        assertThat(decryptor.getCryptogram()).isEqualTo(result);
    }
    
    @Test
    void case12() {
        String cryptogram = "zyalllelyz";
        String result = "zyaelyz";
        final Decryptor decryptor = new Decryptor(cryptogram);
        decryptor.decrypt();
    
        assertThat(decryptor.getCryptogram()).isEqualTo(result);
    }
    
    @Test
    void case13() {
        String cryptogram = "aabba";
        String result = "a";
        final Decryptor decryptor = new Decryptor(cryptogram);
        decryptor.decrypt();
    
        assertThat(decryptor.getCryptogram()).isEqualTo(result);
    }
    
    @Test
    void case14() {
        String cryptogram = "abbaa";
        String result = "a";
        final Decryptor decryptor = new Decryptor(cryptogram);
        decryptor.decrypt();
    
        assertThat(decryptor.getCryptogram()).isEqualTo(result);
    }
    
    @Test
    void case15() {
        String cryptogram = "sadddaaaas";
        String result = "sas";
        final Decryptor decryptor = new Decryptor(cryptogram);
        decryptor.decrypt();
    
        assertThat(decryptor.getCryptogram()).isEqualTo(result);
    }
    
    @Test
    void case16() {
        String cryptogram = "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab";
        String result = "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababab";
        final Decryptor decryptor = new Decryptor(cryptogram);
        decryptor.decrypt();
    
        assertThat(decryptor.getCryptogram()).isEqualTo(result);
    }
    
    @Test
    void case17() {
        String cryptogram = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        String result = "";
        final Decryptor decryptor = new Decryptor(cryptogram);
        decryptor.decrypt();
    
        assertThat(decryptor.getCryptogram()).isEqualTo(result);
    }
}
