package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int i = 0; i < word.length(); i++){
            Character s = changeWord(word.charAt(i));
            answer += s;
        }

        return answer;
    }
    public static Character changeWord(Character c){ // 글자 변환 하는 함수
        int ret = 0;
        Character ret_c = null;
        if(c >= 'A' && c <= 'Z'){

            ret = 'Z' - (c-'A');
            ret_c = (char) ret;
        }
        else if(c >= 'a' && c <= 'z'){
            ret = 'z' - (c-'a');
            ret_c = (char) ret;
        }
        if(ret_c == null){
            ret_c = ' ';
        }
        return ret_c;
    }
}
