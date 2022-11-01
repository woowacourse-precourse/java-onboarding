package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 기능 구현 사항
 * 1. 중복 처리 함수
 * 2. result 문자열 오름차순 정렬
 */
public class Problem6 {
    static List<Boolean> Duplicate = new ArrayList<>();
    static List<String> answer = new ArrayList<>();
    static List<String> nicknames = new ArrayList<>();

    private static boolean isDuplicate(String str1, String str2){
        for(int i = 0; i < str1.length() - 1 ; i++){
            for (int j = 0; j < str2.length() - 1; j++){
                if (str1.substring(i, i + 2).equals(str2.substring(j, j + 2))){
                    return true;
                }
            }
        }
        return false;
    }
    private static void setBooleanValueDup(List<List<String>> forms){
        for (int i = 0; i < forms.size() - 1; i++){
            for (int j = i + 1; j < forms.size(); j++){
                if (!Duplicate.get(j) && isDuplicate(nicknames.get(i), nicknames.get(j))){
                    Duplicate.set(i, true);
                    Duplicate.set(j, true);
                }
            }
        }
    }
    public static List<String> solution(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++){
            Duplicate.add(false);
            nicknames.add(forms.get(i).get(1));
        }

        setBooleanValueDup(forms);

        for (int i = 0; i < forms.size(); i++){
            if (Duplicate.get(i)){
                answer.add(forms.get(i).get(0));
            }
        }

        Collections.sort(answer);
        return answer;
    }
}
