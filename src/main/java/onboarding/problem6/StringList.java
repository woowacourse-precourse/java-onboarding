package onboarding.problem6;

import java.util.ArrayList;
import java.util.List;

public class StringList {

    public static List<String> sort(List<String> stringList){

        List<String> answer = new ArrayList<>(stringList);
        if (stringList.size() <= 1) return answer;

        int startIndex = 0;
        int endIndex = answer.size() - 1;
        return sortSubsection(answer, startIndex, endIndex);
    }

    private static List<String> sortSubsection(List<String> list, int startIndex, int endIndex){
        int part = partition(list, startIndex, endIndex);
        if (startIndex < part - 1) list = sortSubsection(list, startIndex, part -1);
        if (part < endIndex) list = sortSubsection(list, part, endIndex);
        return list;
    }

    private static int partition(List<String> list, int left, int right){
        String pivot = list.get((left + right) / 2);
        while (left <= right){
            while (areTwoStringsInOrder(list.get(left), pivot)) left++;
            while (areTwoStringsInOrder(pivot, list.get(right))) right--;
            if (left <= right){
                changeLocation(list, left, right);
                left++; right--;
            }
        }
        return left;
    }

    private static void changeLocation(List<String> list, int index1, int index2){
        String temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    private static boolean areTwoStringsInOrder(String word1, String word2){
        return compareStrings(word1, word2) < 0;
    }

    private static int compareStrings (String word1, String word2){
        for (int i=0; i<Math.min(word1.length(), word2.length()); i++){
            if (word1.charAt(i) != word2.charAt(i)){
                return word1.charAt(i) - word2.charAt(i);
            }
        }
        return word1.length() - word2.length();
    }
}
