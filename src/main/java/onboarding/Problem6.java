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
        List<Integer> duplicatedIndexList = getDuplicatedIndex(substringList);
        List<String> duplicatedEmailList = findEmailByIndex(emailList, duplicatedIndexList);

        return answer;
    }

    private static List<String> findEmailByIndex(List<String> emailList, List<Integer> duplicatedIndexList) {
        List<String> duplicatedEmailList = new ArrayList<>();
        for (int i=0; i<duplicatedIndexList.size(); i++) {
            int index = duplicatedIndexList.get(i);
            String duplicatedEmail = emailList.get(index);
            duplicatedEmailList.add(duplicatedEmail);
        }
        return duplicatedEmailList;
    }

    private static List<Integer> getDuplicatedIndex(List<List<String>> substringList) {
        List<Integer> dupliatedIndexList = new ArrayList<>();
        for (int i=0; i<substringList.size(); i++) {
            boolean DuplicatedFlag = false;
            for (int j=i; j<substringList.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (ValidateDuplicatedName(substringList.get(i), substringList.get(j))) {
                    DuplicatedFlag = true;
                    break;
                }
            }
            if(DuplicatedFlag) {
                dupliatedIndexList.add(i);
            }
        }
        return dupliatedIndexList;
    }

    private static boolean ValidateDuplicatedName(List<String> allSubstring1, List<String> allSubstring2) {
        for (String temp1 : allSubstring1) {
            for (String temp2 : allSubstring2) {
                if(temp1.equals(temp2)) {
                    return true;
                }

            }
        }
        return false;
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
