package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 기능 구현 사항
 * 1. 예외 처리
 *      1. 1 <= 크루인원 <= 10_000
 *      2. 이메일 형식. 길이 11자 이상 20자 미만
 *      3. 신청할 수 있는 이메일 email.com
 *      4. 닉네임 한글만 가능. 전체 길이 1글자 이상 20자 미만
 * 2. 중복 처리 함수
 * 3. result 문자열 오름차순 정렬
 */
public class Problem6 {
//    static List<Boolean> Duplicate = Collections.emptyList();
    static List<Boolean> Duplicate;
    private static boolean isDuplicate(String str1, String str2){
        int count = 0;
        for(int i=0; i<str1.length()-1 ; i++){
            for (int j=0; j<str2.length()-1; j++){
                if (str1.substring(i,i+2).equals(str2.substring(j,j+2))){
                    return true;
                }
            }
        }
        return false;
    }
    public static List<Boolean> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        Duplicate = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++){
            Duplicate.add(true);
        }

        List<String> nicknames = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++){
            nicknames.add(forms.get(i).get(1));
        }

        for (int i = 0; i < forms.size() - 1; i++){
            for (int j = i + 1; j < forms.size(); j++){
                if (isDuplicate(nicknames.get(i), nicknames.get(j))){
                    Duplicate.set(i, false);
                    Duplicate.set(j, false);
                }
            }
        }
        return Duplicate;
    }

    public static void main(String[] args){
        System.out.println(solution(List.of(
                List.of("jm@email.com", "제이엠"),
                List.of("jason@email.com", "제이슨"),
                List.of("woniee@email.com", "워니"),
                List.of("mj@email.com", "엠제이"),
                List.of("nowm@email.com", "이제엠")
        )));
    }
}
