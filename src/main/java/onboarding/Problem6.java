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

    private static boolean isDuplicatedPart(String source, String dest) {
        for (int i = 0; i < source.length(); i++) {
            for (int j = 0; j < dest.length(); j++) {
               if (isConsecutiveDuplicationChar(source, dest, i, j)) return true;
            }
        }
        return false;
    }

    private static boolean isConsecutiveDuplicationChar(String source, String dest, int sourceIndex, int destIndex) {
        return source.charAt(sourceIndex) == dest.charAt(destIndex) &&
               sourceIndex + 1 < source.length() && destIndex + 1 < dest.length() &&
               source.charAt(sourceIndex + 1) == dest.charAt(destIndex + 1);
    }

    static class ResultEmailListManager {
        private List<String> resultEmailList = new ArrayList<>();

        public List<String> getResultEmailList() {
            return resultEmailList;
        }

        public void addIfNotExists(String email) {
            if (!resultEmailList.contains(email)) resultEmailList.add(email);
        }

        //by Bubble Sort
        public void sortByAsc() {
            for (int i = resultEmailList.size() - 1; i > 0; i--) {
                for (int j = 0; j < i; j++) {
                    if (isBiggerOrderThanNext(j)) swapWithNext(j);
                }
            }
        }

        private boolean isBiggerOrderThanNext(int index) {
            return resultEmailList.get(index).compareTo(resultEmailList.get(index + 1)) > 0;
        }

        private void swapWithNext(int index) {
            String tmp = resultEmailList.get(index);
            resultEmailList.set(index, resultEmailList.get(index + 1));
            resultEmailList.set(index + 1, tmp);
        }
    }
}
