package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();

        getRepeatedNicknamesInForms(forms, answer);
        List<String> idList = removeEmailDotCom(new HashSet<>(answer));
        List<String> emailList = appendEmailDotCom(idList);

        return emailList;
    }

    private static void getRepeatedNicknamesInForms(List<List<String>> forms, List<String> answer) {
        for (List<String> form : forms) {
            String nickName = form.get(1);
            if (nickName.length() >= 2) {
                getRepeatedSubnicknamesInNickname(forms, nickName, answer);
            }
        }
    }

    // 닉네임의 부분 닉네임 구하기
    private static void getRepeatedSubnicknamesInNickname(List<List<String>> forms, String nickName,
        List<String> answer) {
        for (int elementLength = 2; elementLength <= nickName.length(); ++elementLength) {
            for (int index = 0; index < nickName.length() - (elementLength - 1); index++) {
                String subNickName = "";
                subNickName = nickName.substring(index, index + elementLength);
                getReapeatedMatchedNicknameInForms(answer, forms, subNickName);
            }
        }
    }

    // 리스트에서 부분 닉네임과 중복되는 닉네임 찾기
    private static void getReapeatedMatchedNicknameInForms(List<String> answer, List<List<String>> forms,
        String subNickname) {
        int count = 0;
        for (List<String> form2 : forms) {
            if (form2.get(1).indexOf(subNickname) != -1) {
                answer.add(form2.get(0));
                count++;
            }
        }
        if (count == 1) {
            answer.remove(answer.size() - 1);
        }
    }

    private static List<String> removeEmailDotCom(Set<String> set) {
        List<String> idList = new ArrayList<>();
        for (String email : set) {
            int startIndex = email.indexOf("@");
            String id = email.substring(0, startIndex);
            idList.add(id);
        }
        Collections.sort(idList);
        return idList;
    }

    private static List<String> appendEmailDotCom(List<String> idList) {
        List<String> emailList = new ArrayList<>();
        for (String id : idList) {
            String email = id + "@email.com";
            emailList.add(email);
        }
        return emailList;
    }

}
