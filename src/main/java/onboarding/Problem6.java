package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * 기능목록
 * 1. 두 글자로 된 중복된 글자 모음을 생성
 * 2. 중복된 글자가 포함된 닉네임을 갖는 크루의 이메일 리스트 생성
 * 3. 오름차순으로 정리
 * */
public class Problem6 {
    private static HashSet<String> temp;
    private static HashSet<String> overlabWords;


    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        temp = new HashSet<String>();
        overlabWords = new HashSet<String>();

        setOverlabList(forms);
        return answer;
    }

    static void setOverlabList(List<List<String>> forms){
        String nickname = new String();

        for(List<String> crew : forms){
            nickname = crew.get(1);
            setOverlabWords(nickname);
        }
    }

    static void setOverlabWords(String nickname){
        boolean alone = true;

        for(int i=0; i<nickname.length()-1; i++){
            alone=temp.add(nickname.substring(i,i+2));
            if(!alone){
                overlabWords.add(nickname.substring(i,i+2));
            }
        }
    }
}
