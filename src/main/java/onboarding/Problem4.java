package onboarding;

public class Problem4 {
    // 단어 거꾸로 하는 함수
    static String changeWord(String word){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); i++){
            char alpha = word.charAt(i);
            if ((alpha >= 'a' && alpha <= 'z')){// 소문자 일때
                char changeAlpha = (char)('z' - (alpha - 'a'));
                result.append(changeAlpha);
            }else if( (alpha >= 'A' && alpha <= 'Z')){// 대문자 일때
                char changeAlpha = (char)('Z' - (alpha - 'A'));
                result.append(changeAlpha);
            }else{// 그 밖의 문자일 때
                result.append(alpha);
            }
        }
        return result.toString();
    }
    public static String solution(String word) {
        return changeWord(word);
    }
}
