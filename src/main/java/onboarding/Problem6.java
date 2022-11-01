package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem 6
 * @author Davin An
 * @version 1.0
 */
public class Problem6 {

    /**
     * Finds which users have overlapping usernames
     * @param forms List of users' email and username
     * @return List of emails of users with overlapping usernames
     */
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        for (int i = 0; i < forms.size(); i++) {
            for (int j = i + 1; j < forms.size(); j++) {
                if (compareString(forms.get(i).get(1), forms.get(j).get(1))) {
                    answer.add(forms.get(i).get(0));
                    answer.add(forms.get(j).get(0));
                }
            }
        }
        return removeDuplicates(answer);
    }

    /**
     * Checks if two Strings have an overlap of at least length two
     * @param s1 First String
     * @param s2 Second String
     * @return True if there is overlap of length two, false otherwise
     */
    public static boolean compareString(String s1, String s2) {
        for (int i = 0; i < s1.length() - 1; i++) {
            if (s2.contains(s1.substring(i, i + 2))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Removes duplicates from result list and sorts in ascending order
     * @param list List to remove duplicates and sort
     * @return New list
     */
    public static List<String> removeDuplicates(List<String> list) {
        List<String> newList = new ArrayList<>();
        for (String s : list) {
            if (!newList.contains(s)) {
                newList.add(s);
            }
        }
        Collections.sort(newList);
        return newList;
    }

    public static void main(String[] args) {}
}
