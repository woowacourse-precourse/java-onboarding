package onboarding.problem6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class DuplicateChecker {
    List<List<String>> database;

    public DuplicateChecker(List<List<String>> forms) {
        this.database = forms;
    }

    private boolean hasSubString(String name, String subString){
        return name.indexOf(subString) >= 0;
    }

    boolean checkDuplicate(String name, int index) {
        for (int j = 0; j < database.size(); j++) {
            if (j == index) continue;
            String nameData = database.get(j).get(1);
            for (int i = 0; i < nameData.length() - 1; i++) {
                String substring = nameData.substring(i, i + 2);
                if (hasSubString(name, substring)) return true;
            }
        }
        return false;
    }

    public List<String> getDuplicates() {
        List<String> duplicates = new ArrayList<>();
        for (int i = 0; i < database.size(); i++) {
            String email = database.get(i).get(0);
            String name = database.get(i).get(1);
            if (checkDuplicate(name, i))
                duplicates.add(email);
        }
        duplicates.sort(Comparator.naturalOrder());
        return duplicates.stream().distinct().collect(Collectors.toList());
    }

}
