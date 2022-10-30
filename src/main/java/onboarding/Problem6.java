package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Database.validateData(forms);
        Database.setData(forms);
        List<String> answer = getEmailListByCheckNickname();
        return answer;
    }

    static List<String> getEmailListByCheckNickname() {
        List<Integer> duplicatedIndexList = getDuplicatedIndex();
        List<String> duplicatedEmailList = getEmailListByIndexList(duplicatedIndexList);
        List<String> answer = checkEmailList(duplicatedEmailList);
        return answer;
    }

    static List<Integer> getDuplicatedIndex() {
        List<Integer> duplicatedIndex = new ArrayList<>();
        List<String> nameList = Database.getNameList();
        int nameCount = nameList.size();
        for (int i = 0; i < nameCount; i++) {
            String name = nameList.get(i);
            boolean isNameDuplicated = checkNameDuplication(name, i);
            if (isNameDuplicated) {
                duplicatedIndex.add(i);
            }
        }
        return duplicatedIndex;
    }

    static boolean checkNameDuplication(String name, int indexOfName) {
        List<String> nameSplitBy2 = splitNameBy2(name);
        boolean isDuplicated = false;
        for (int i = 0; i < nameSplitBy2.size(); i++) {
            String twoCharacters = nameSplitBy2.get(i);
            boolean isNameDuplicated = Database.checkDuplicationByTwoCharacters(twoCharacters, indexOfName);
            if (isNameDuplicated) {
                isDuplicated = true;
                break;
            }
        }
        return isDuplicated;
    }

    static List<String> splitNameBy2(String name) {
        List<String> nameSplitBy2 = new ArrayList<>();
        List<String> characterList = new ArrayList<>(Arrays.asList(name.split("")));
        int lengthOfName = characterList.size();
        for (int i = 0; i < lengthOfName - 1; i ++) {
            String twoCharacters = characterList.get(i) + characterList.get(i+1);
            nameSplitBy2.add(twoCharacters);
        }
        return nameSplitBy2;
    }
}

class Database {

    static List<String> nameList = new ArrayList<>();
    static List<String> emailList = new ArrayList<>();

    static void setData(List<List<String>> forms) {
        nameList.clear();
        emailList.clear();
        setNameList(forms);
        setEmailList(forms);
    }

    static void setNameList(List<List<String>> forms) {
        forms.stream().forEach(form -> {
            String name = form.get((1));
            nameList.add(name);
        });
    }

    static void setEmailList(List<List<String>> forms) {
        forms.stream().forEach(form -> {
            emailList.add(form.get(0));
        });
    }

    static List<String> getNameList() {
        return nameList;
    }

    static List<String> getEmailList() {
        return emailList;
    }

    static boolean checkDuplicationByTwoCharacters(String twoCharacters, int indexOfName) {
        boolean isDuplicated = false;
        int nameCount = nameList.size();
        for (int i = 0; i < nameCount; i++) {
            if (i == indexOfName) {
                continue;
            }
            String name = nameList.get(i);
            boolean isContained = name.contains(twoCharacters);
            if (isContained) {
                isDuplicated = true;
                break;
            }
        }
        return isDuplicated;
    }


}