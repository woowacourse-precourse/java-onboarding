package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = getDuplicatedName(forms);
        return answer;
    }

    /**
     * 닉네임에 중복된 글자가 들어있는 사람의 이메일을 반환
     * @param forms
     * @return List<String>: 중복된 이름에 대한 이메일이 담긴 리스트
     */
    private static List<String> getDuplicatedName(List<List<String>> forms){
        // 중복된 요소를 없애기 위해 Set 사용
        Set<String> resultEmails = new HashSet<>();
        // forms에서 추출
        List<String> names = new ArrayList<>();
        List<String> emails = new ArrayList<>();

        for(int i=0;i<forms.size();i++){
            emails.add(forms.get(i).get(0));
            names.add(forms.get(i).get(1));
        }

        for(int i=0;i<names.size();i++){
            String name = names.get(i);
            if(resultEmails.contains(emails.get(i)))
                continue;

            for(int j=i+1;j<names.size();j++){
                String target = names.get(j);

                if(isContainName(name, target)){
                    resultEmails.add(emails.get(i));
                    resultEmails.add(emails.get(j));
                }
            }
        }
        List<String> result = new ArrayList<>(resultEmails);
        result.sort(String::compareTo);
        return result;
    }

    /**
     * 두 문자열에 중복된 글자가 있는지 판별
     * @param name
     * @param target
     * @return true: 중복된 글자가 존재한다면
     */
    private static boolean isContainName(String name, String target) {
        for(int i=0;i<name.length()-2;i++){
            if(target.contains(name.substring(i, i+2)))
                return true;
        }
        return false;
    }
}
