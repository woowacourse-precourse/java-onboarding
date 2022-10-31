package onboarding;

import java.util.List;
import java.util.Stack;

public class Problem2 {
    /**
     * 중복 문자 제거 (한 turn)
     * 중복 제거 반복
     * List 문자 합치기
     */
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    /**
     * 중복 문자 제거 (한 turn)
     */
    static List<String> remove(List<String> word) {
        for (int i = 0; i < word.size(); i++) {
            for (int j = i + 1; j < word.size(); j++) {
                String c1 = word.get(i);
                String c2 = word.get(j);
                if (c1.equals(c2)) {
                    if(j == word.size()-1){
                        for(int k=i;k<=j;k++){
                            word.remove(i);
                        }
                    }
                }else{
                    if(i != j-1){
                        for(int k=i;k<j;k++){
                            word.remove(i);
                        }
                    }
                    break;
                }
            }
        }
        return word;
    }

    /**
     * List 문자 합치기
     */
    static String dump(List<String> word) {
        return String.join("",word);
    }

}

