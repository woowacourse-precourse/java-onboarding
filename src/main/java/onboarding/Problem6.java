package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {

        Set<String> result = new TreeSet<>();   //TreeSet은 기본적으로 오름차순으로 값을 저장하고 중복을 허용하지 않는 Set임.

        for(int i = 0; i < forms.size(); i++) {
            checkDuplicate(forms, result, i);
        }

        List<String> answer = new ArrayList<>(result);
        return answer;
    }

    /**
     *  forms 리스트를 받아 i번째 form과 j번째 form을 비교해서 중복되면 result Set에 넣는 메서드
     */
    private static void checkDuplicate(List<List<String>> forms, Set<String> result, int i) {
        for(int j = i + 1; j < forms.size(); j++) {
            List<String> firstForm = forms.get(i);
            List<String> secondForm = forms.get(j);

            checkDuplicateNickName(firstForm, secondForm, result);
        }
    }

    /**
     *  i번째 form과 j번째 form을 받아서, 닉네임 일부가 중복되면 result Set에 넣는 메서드
     */
    private static void checkDuplicateNickName(List<String> firstForm,
                                               List<String> secondForm,
                                               Set<String> result) {
        //비교할려는 두 닉네임 모두 한글자일때
        if(firstForm.get(1).length() == 1 && secondForm.get(1).length() == 1) {
            isEqualString(firstForm, secondForm, result);
            return;
        }

        //비교할려는 두 닉네임 중 하나만 한글자일때
        if(firstForm.get(1).length() == 1 || secondForm.get(1).length() == 1) {
            return;
        }

        //비교할려는 두 닉네임 모두 두글자일때
        if(firstForm.get(1).length() == 2 && secondForm.get(1).length() == 2) {
            isEqualString(firstForm, secondForm, result);
            return;
        }

        //첫번째 닉네임이 두글자일때
        if(firstForm.get(1).length() == 2) {
            isContain(firstForm.get(1), secondForm.get(1), firstForm.get(0), secondForm.get(0), result);
            return;
        }

        //두번째 닉네임이 두글자일때
        if(secondForm.get(1).length() == 2) {
            isContain(secondForm.get(1), firstForm.get(1), firstForm.get(0), secondForm.get(0), result);
            return;
        }

        //비교할려는 두 닉네임 모두 세글자 이상일때
        for(int i = 0; i + 1 < firstForm.get(1).length(); i++) {
            String subNickName = firstForm.get(1).substring(i, i+2);
            isContain(subNickName, secondForm.get(1), firstForm.get(0), secondForm.get(0), result);
        }

        for(int i = 0; i + 1 < secondForm.get(1).length(); i++) {
            String subNickName = secondForm.get(1).substring(i, i+2);
            isContain(subNickName, firstForm.get(1), firstForm.get(0), secondForm.get(0), result);
        }
    }

    /**
     *  비교하는 두 닉네임 전체가 일치하면 result Set에 넣는 메서드
     */
    private static void isEqualString(List<String> firstForm,
                                      List<String> secondForm,
                                      Set<String> result) {
        if(firstForm.get(1).equals(secondForm.get(1))) {
            result.add(firstForm.get(0));
            result.add(secondForm.get(0));
        }
    }

    /**
     *  비교하는 두 닉네임 일부가 일치하면 result Set에 넣는 메서드
     */
    private static void isContain(String subNickName,
                                  String comparedNickName,
                                  String firstEmail,
                                  String secondEmail,
                                  Set<String> result) {
        if(comparedNickName.contains(subNickName)) {
            result.add(firstEmail);
            result.add(secondEmail);
        }
    }
}
