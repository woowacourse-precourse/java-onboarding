package onboarding.prob6.domain;

import java.util.ArrayList;
import java.util.List;

public class Judge {

    private final List<List<String>> forms;

    public Judge(List<List<String>> forms) {
        this.forms = forms;
    }

    public List<String> getListOfSameNickName() {
        boolean[] hasSameNickNameArray = getHasSameNickNameArray();
        return getResult(hasSameNickNameArray);
    }

    final List<String> getResult(boolean[] hasSameNickNameArray) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < hasSameNickNameArray.length; i++) {
            if (!hasSameNickNameArray[i]) continue;
            String email = forms.get(i).get(0);
            result.add(email);
        }
        return result;
    }

    final boolean[] getHasSameNickNameArray() {
        int size = forms.size();
        boolean[] a = new boolean[size];
        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                String name1 = forms.get(i).get(1);
                String name2 = forms.get(j).get(1);
                boolean isSame = containSameString(name1, name2);
                if (!isSame) continue;
                a[i] = true;
                a[j] = true;
            }
        }
        return a;
    }

    final boolean containSameString(String origin, String dest) {
        int originLength = origin.length();
        int destLength = dest.length();
        for (int i = 0; i < originLength - 1; i++) {
            for (int j = 0; j < destLength - 1; j++) {
                String a = String.valueOf(origin.charAt(i)) + String.valueOf(origin.charAt(i + 1));
                String b = String.valueOf(dest.charAt(j)) + String.valueOf(dest.charAt(j + 1));
                if (a.equals(b))
                    return true;
            }
        }
        return false;
    }
}
