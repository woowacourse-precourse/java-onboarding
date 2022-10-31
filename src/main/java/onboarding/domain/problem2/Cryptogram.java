package onboarding.domain.problem2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cryptogram {

    private List<String> stringList;

    public Cryptogram(String inputString) {
        if (inputString==null)
            throw new NullPointerException("문자열을 입력해주세요");
        if (outOfRange(inputString))
            throw new IllegalArgumentException("길이가 1이상 1000이상인 문자열을 입력하십시오.");
        if (isNotLowerLetter(inputString))
            throw new IllegalArgumentException("알파벳 소문자만 입력해주세요.");
        stringList = mapString(inputString);
    }

    private boolean outOfRange(String inputString) {
        if (inputString.length() > 1000)
            return true;
        return false;
    }

    private boolean isNotLowerLetter(String inputString) {
        char chr;
        for (int i=0; i<inputString.length();i++) {
            chr = inputString.charAt(i);
            if (!Character.isLetter(chr)||Character.isUpperCase(chr))
                return true;
        }
        return false;
    }

    private List<String> mapString(String inputString) {
        List<String> mapped = new ArrayList<>();
        for (int i = 0; i< inputString.length(); i++) {
            mapped.add(inputString.substring(i,i+1));
        }
        return mapped;
    }

    public boolean remove() {
        boolean removed = false;
        Set<Integer> removedIndex = find();
        for (int i=stringList.size()-1; i>=0;i--) {
            if (removedIndex.contains(i)) {
                stringList.remove(i);
                removed = true;
            }
        }
        return removed;
    }

    private Set<Integer> find() {
        String sameValue = "A";
        Set<Integer> removedIndex = new HashSet<>();

        for (int i = 0; i< stringList.size(); i++) {
            if (stringList.get(i).equals(sameValue)) {
                removedIndex.add(i);
                removedIndex.add(i-1);
                continue;
            }
            sameValue = stringList.get(i);
        }
        return removedIndex;
    }
    public String toString() {
        return String.join("",stringList);
    }

}
