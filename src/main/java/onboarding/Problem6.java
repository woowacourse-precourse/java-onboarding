package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
//        List<String> answer = List.of("answer");
        List<String> answer = new ArrayList<>();
        // 사용자 이름을 기반으로 2글자씩 substring정보를 담는 이중 list 생성
        List<String> emailList = makeEmailList(forms);
        List<String> nameList = makeNameList(forms);

        List<List<String>> substringList = makeSubstringList(nameList);

        return answer;
    }

    private static List<List<String>> makeSubstringList(List<String> nameList) {
        List<List<String>> substringList = new ArrayList<>();
        for (int i=0; i<nameList.size(); i++) {
            List<String> allSubstring = makeSubstring(nameList.get(i));
            substringList.add(allSubstring);
        }
        return substringList;
    }

    private static List<String> makeSubstring(String name) {
        List<String> allSubString = new ArrayList<>();
        for (int i=0; i<name.length()-1; i++) {
            allSubString.add(name.substring(i, i+2));
        }
        return allSubString;
    }


    private static List<String> makeNameList(List<List<String>> forms) {
        List<String> nameList = new ArrayList<>();
        for (List<String> form : forms) {
            String name = form.get(1);
            nameList.add(name);
        }
        return nameList;
    }

    private static List<String> makeEmailList(List<List<String>> forms) {
        List<String> emailList = new ArrayList<>();
        for (List<String> form : forms) {
            String emailAddress = form.get(0);
            emailList.add(emailAddress);
        }
        return emailList;
    }
}
