package onboarding.problem2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cryptogram {

    private List<String> stringList;

    public Cryptogram(String inputString) {
        stringList = mapString(inputString);
    }

    private List mapString(String inputString) {
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
