package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        String sourceEmail, sourceNickname, destEmail, destNickname;
        ResultEmailListManager manager = new ResultEmailListManager();

        for (int i = 0; i < forms.size(); i++) {
            for (int j = i + 1; j < forms.size(); j++) {
                sourceEmail = forms.get(i).get(0); sourceNickname = forms.get(i).get(1);
                destEmail = forms.get(j).get(0); destNickname = forms.get(j).get(1);

                if (isDuplicatedPart(sourceNickname, destNickname)) {
                    manager.addIfNotExists(sourceEmail);
                    manager.addIfNotExists(destEmail);
                }
            }
        }

        manager.sortByAsc();
        return manager.getResultEmailList();
    }

    private static boolean isDuplicatedPart(String sourceName, String destName) {
        return true;
    }

    static class ResultEmailListManager {
        private List<String> resultEmailList = new ArrayList<>();

        public List<String> getResultEmailList() {
            return resultEmailList;
        }

        public void addIfNotExists(String email) {
            if (!resultEmailList.contains(email)) resultEmailList.add(email);
        }

        public void sortByAsc() {

        }
    }
}
