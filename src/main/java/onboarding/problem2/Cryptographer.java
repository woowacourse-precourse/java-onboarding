package onboarding.problem2;

import onboarding.problem2.utils.Parser;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cryptographer {
    private Set<Integer> set = new HashSet<>();

    public boolean checkEncrypted(List<String> stringList) {
        for (int i = 0; i < stringList.size() - 1; i++) {
            if (stringList.get(i).equals(stringList.get(i + 1))) {
                return true;
            }
        }
        return false;
    }

    public String decrypt(String string) {
        List<String> stringList = Parser.convertStringToList(string);
        while (checkEncrypted(stringList)) {
            set.clear();
            stringList = removeDuplicated(stringList);
        }

        return Parser.convertStackToString(stringList);
    }

    private List<String> removeDuplicated(List<String> stringList) {
        for (int i = 0; i < stringList.size() - 1; i++) {
            checkDuplicated(stringList, i);
        }

        for (int index : set) {
            stringList.set(index,"");
        }

        stringList.removeAll(List.of(""));
        return stringList;
    }

    private void checkDuplicated(List<String> stringList, int index) {
        if (stringList.get(index).equals(stringList.get(index + 1))) {
            set.add(index);
            set.add(index + 1);
        }
    }
}
