import static org.junit.jupiter.api.Assertions.*;
class Problem4Test {
  
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