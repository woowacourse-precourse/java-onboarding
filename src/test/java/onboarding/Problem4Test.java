package onboarding;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Problem4Test {

    @Test
    void 문자판별() {
        assertThat(check('a')).isEqualTo('z');
        assertThat(check('A')).isEqualTo('Z');
        assertThat(check(';')).isEqualTo(';');
        assertThat(check(' ')).isEqualTo(' ');
    }

    private char check(char c) {
        if (96<c && c<123) return lowercase(c);
        if (64<c && c<91) return uppercase(c);
        return c;
    }
    // 대소문자 판별

    @Test
    void 문자반환() {
        char a = 'a';
        char result = 'z';
        assertThat(lowercase(a)).isEqualTo(result);
        assertThat(uppercase('A')).isEqualTo('Z');
    }
    // 대문자 변환
    char uppercase(char a){
        char answer = (char)(155 - a);
        return answer;
    }
    // 소문자 변환
    char lowercase(char a){
        char answer = (char)(219 - a);
        return answer;
    }
}