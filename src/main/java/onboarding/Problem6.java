package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
/*
* 기능 구현 사항
* 1. 닉네임을 두 글자씩 나누어서 hashSet에 저장.
* 2. 각 입력값마다 기존의 넥네임 리스트와 비교기능 구현
* 3. 중복된 넥네임마다 hashSet에 저장가능 구현
* 4. 정렬 후 리턴하는 기능 구현
* */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        HashSet<String> splittedNickName = mappingTwoCharacterToSet(forms);

        System.out.println(splittedNickName);
        return answer;
    }

    public static HashSet<String> mappingTwoCharacterToSet(List<List<String>> forms){
        HashSet<String> splittedNickName = new HashSet<>();
        for (List<String> information:
             forms) {
            String nickName = information.get(1);
            if(nickName.length() >= 2){
                for (int i = 0; i < nickName.length()-1; i++) {
                    splittedNickName.add(nickName.substring(i, i+2));
                }
            }
        }
        return splittedNickName;
    }
}
