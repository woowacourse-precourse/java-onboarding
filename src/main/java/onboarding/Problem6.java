package onboarding;

import java.util.*;

class CompareName {
    List<String> splittedNames = new ArrayList<>();

    CompareName(List<List<String>> nameList) {
        String currentName = "";
        for (int nameIndex = 0; nameIndex < nameList.size(); nameIndex++) {
            currentName = nameList.get(nameIndex).get(1);
            for (int subStringIndex = 0; subStringIndex < currentName.length() - 1; subStringIndex++) {
                this.splittedNames.add(currentName.substring(subStringIndex, subStringIndex + 2));
            }
        }
    }

    public void CheckException(List<List<String>> target) throws RestrictException {
        if (target.size() < 1 || target.size() > 10000) {
            throw new RestrictException("OutOfRange");
        } else {
            for (int i = 0; i < target.size(); i++) {
                if (target.get(i).get(1).length() < 1 || target.get(i).get(1).length() >= 20) {
                    throw new RestrictException("NickNameLengthOutOfRange");
                }
                for (int j = 0; j < target.get(i).get(1).length(); j++) {
                    int letterCode = target.get(i).get(1).codePointAt(j);
                    if (letterCode >= 12593 && letterCode <= 12643) {

                    } else if (letterCode >= 12645 && letterCode <= 12686) {

                    } else if (letterCode < 44032 || letterCode > 55203) {
                        throw new RestrictException("NotKorean");
                    }
                }
                if (target.get(i).get(0).endsWith("@email.com") == false) {
                    throw new RestrictException("EmailFormatWrong");
                }
                if (target.get(i).get(0).length() < 11 || target.get(i).get(0).length() >= 20) {
                    throw new RestrictException("EmailLengthOutOfRange");
                }
            }
        }
    }

    public List<String> findDuplicated() {
        Set<String> setCompare = new HashSet<String>();
        Set<String> setDuplicated = new HashSet<String>();
        for (String splittedName : this.splittedNames) {
            if (setCompare.contains(splittedName)) {
                setDuplicated.add(splittedName);
            } else {
                setCompare.add(splittedName);
            }
        }
        List<String> result = new ArrayList<>(setDuplicated);
        return result;
    }

    public List<String> findCrews(List<List<String>> forms, List<String> duplicatedNames) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            for (String duplicatedName : duplicatedNames) {
                if (forms.get(i).get(1).contains(duplicatedName)) {
                    answer.add(forms.get(i).get(0));
                }
            }
        }
        answer.sort(Comparator.naturalOrder());
        return answer;
    }
}

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        CompareName name = new CompareName(forms);
        try {
            name.CheckException(forms);
            answer = name.findCrews(forms, name.findDuplicated());
        } catch (RestrictException e) {
            System.out.println(e.exMsg);
        }
        return answer;
    }
}
