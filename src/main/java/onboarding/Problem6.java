package onboarding;

import java.util.*;

public class Problem6 {
    // 기능 목록 1 : 닉네임을 두 글자씩 나누는 함수
    public static List<String> makeNewnickname(String nickname){
        List<String> new_nickname = new ArrayList<>();

        for(int i=0;i<nickname.length()-1;i++){
            String temp = "";
            temp+=nickname.charAt(i);
            temp+=nickname.charAt((i+1));
            new_nickname.add(temp);
        }

        return new_nickname;
    }

    // 기능 목록 2 : 두 글자로 나눠진 닉네임이 포함된 이메일을 구하는 함수
    public static List<List<String>> getemailOfnickname(Set<String> nickname_set, List<List<String>> forms){
        List<List<String>> duplication_email = new ArrayList<>();

        for(String nickname:nickname_set){
            List<String> temp = new ArrayList<>();
            for(List<String> form:forms){
                if(form.get(1).contains(nickname)){
                    temp.add(form.get(0));
                }
            }
            duplication_email.add(temp);
        }

        return duplication_email;
    }

    // 기능 목록 3 : 같은 글자가 연속적으로 포함되는 닉네임을 작성한 지원자의 이메일 목록을 구하는 함수
    public static List<String> findDuplicationEmail(List<List<String>> duplication_email){
        List<String> result = new ArrayList<>();
        for(List<String> duplication:duplication_email){
            if(duplication.size() > 1){
                for(String d:duplication){
                    result.add(d);
                }
            }
        }

        Set<String> answer_set = new HashSet<String>(result);
        result = new ArrayList<>(answer_set);

        Collections.sort(result);

        return result;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        List<String> nickname_forms = new ArrayList<>();
        List<List<String>> duplication_email = new ArrayList<>();

        // 닉네임을 두글자로 나누는 모든 경우의 수를 구하는 반복문
        for(List<String> f:forms){
            // make new nicknmae form
            List<String> temp = makeNewnickname(f.get(1));

            for(String t:temp){
                nickname_forms.add(t);
            }
        }

        // 닉네임을 두글자로 나누는 모든 경우의 수의 중복 제거
        Set<String> nickname_set = new HashSet<String>(nickname_forms);

        // 두 글자로 나눠진 닉네임이 포함된 이메일 구하기
        duplication_email = getemailOfnickname(nickname_set,forms);

        // 같은 글자가 연속적으로 포함되는 닉네임을 작성한 지원자의 이메일 목록 구하기
        answer = findDuplicationEmail(duplication_email);

        return answer;
    }
}
