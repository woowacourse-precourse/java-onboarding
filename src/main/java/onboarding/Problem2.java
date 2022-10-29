package onboarding;

import java.util.ArrayList;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
    // 중복 문자열 있는 지 확인
    public static int isDuplicated(ArrayList<String> word){
        for(int i = 0; i<word.size()-1; i++){
            if(word.get(i).equals(word.get(i+1))){
                return i;
            }
        }
        return -1;
    }
    // 중복 문자열 삭제
    public static ArrayList<String> removeLetter(ArrayList<String> word, int index){
        word.remove(index);
        word.remove(index);

        return word;
    }
}
