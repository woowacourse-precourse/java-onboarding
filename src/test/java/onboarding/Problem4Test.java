import static org.junit.jupiter.api.Assertions.*;
class Problem4Test {
  
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