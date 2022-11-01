package onboarding;

import java.util.*;

public class Problem6 {
    public static List<List<String>> getValidList(List<List<String>> forms){
        String domain = "@email.com";
        for(int i = 0; i < forms.size(); i++ ) {
            if(!forms.get(i).get(0).substring(forms.get(i).get(0).length() - 10).equals(domain))
                forms.remove(i);
            if(forms.get(i).get(0).length() < 11 || forms.get(i).get(0).length() > 19)
                forms.remove(i);
            boolean koeanWord = forms.get(i).get(1).matches("^[가-힣]*$");
            if(!koeanWord)
                forms.remove(i);
            if(forms.get(i).get(1).length() < 1 || forms.get(i).get(1).length() > 19)
                forms.remove(i);
        }
        return forms;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<String>();
        List<List<String>> validForms = getValidList(forms);
        if (forms.size() < 1 || forms.size() > 10000)
            return answer;
        //닉네임을 2개식 분리 하면서 중복된 이메일 add
        Map<String, List<String>> listMap = new HashMap<>();
        for (List<String> validForm : validForms) {
            for (int j = 0; j < validForm.get(1).length() - 1; j++) {
                if (listMap.containsKey(validForm.get(1).substring(j, j + 2)))
                    listMap.get(validForm.get(1).substring(j, j + 2)).add(validForm.get(0));
                else {
                    List<String> emailList = new ArrayList<String>();
                    emailList.add(validForm.get(0));
                    listMap.put(validForm.get(1).substring(j, 2), emailList);
                }
            }
        }
        //비슷한 닉네임을 가진 이메일이 2개 이상이면 축출
        for (String key : listMap.keySet()) {
            if (listMap.get(key).size() > 1) {
                answer.addAll(listMap.get(key));
            }
        }
        //중복 제거하기 위해 set으로 바꾸고 다시 list로 변경
        List<String> sort_answer = new ArrayList<String>(new LinkedHashSet<String>(answer));
        //정렬
        Collections.sort(sort_answer);
        return sort_answer;
    }
}
