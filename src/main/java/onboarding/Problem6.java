package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> emailList = makeEmailList(forms);
        List<String> nameList = makeNameList(forms);

        List<List<String>> totalSubstringList = makeTotalSubstringList(nameList);
        List<Integer> duplicatedIndexList = getDuplicatedIndex(totalSubstringList, nameList);
        List<String> duplicatedEmailList = makeDuplicatedEmailList(emailList, duplicatedIndexList);

        HashSet<String> set = new HashSet<>(duplicatedEmailList);
        List<String> answer = new ArrayList<>(set);
        Collections.sort(answer);

        return answer;
    }

    private static List<String> makeDuplicatedEmailList(List<String> emailList, List<Integer> duplicatedIndexList) {
        List<String> duplicatedEmailList = new ArrayList<>();
        for (int i=0; i<duplicatedIndexList.size(); i++) {
            int index = duplicatedIndexList.get(i);
            String duplicatedEmail = emailList.get(index);
            duplicatedEmailList.add(duplicatedEmail);
        }
        return duplicatedEmailList;
    }

    private static List<Integer> getDuplicatedIndex(List<List<String>> substringList, List<String> nameList) {
        List<Integer> duplicatedIndexList = new ArrayList<>();
        for (int i=0; i<nameList.size(); i++) {
            String name = nameList.get(i);
            boolean duplicatedFlag = false;
            for (int j=0; j<substringList.size(); j++) {
                if (i == j) {
                    continue;
                }
                if (validateDuplicatedName(name, substringList.get(j))) {
                    duplicatedFlag = true;
                    break;
                }
            }
            if (duplicatedFlag) {
                duplicatedIndexList.add(i);
            }
        }
        return duplicatedIndexList;
    }

    private static boolean validateDuplicatedName(String name, List<String> substringList) {
        for (String substring : substringList) {
            if (name.contains(substring)) {
                return true;
            }
        }
        return false;
    }

    private static List<List<String>> makeTotalSubstringList(List<String> nameList) {
        List<List<String>> totalSubstringList = new ArrayList<>();
        for (String name : nameList) {
            List<String> substringList = makeSubstringList(name);
            totalSubstringList.add(substringList);
        }
        return totalSubstringList;
    }

    private static List<String> makeSubstringList(String name) {
        List<String> substringList = new ArrayList<>();
        for (int i=0; i<name.length()-1; i++) {
            substringList.add(name.substring(i, i+2));
        }
        return substringList;
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
