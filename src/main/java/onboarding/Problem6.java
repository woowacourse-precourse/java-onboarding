package onboarding;

import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        answer = DuplicateNameChecker.checkNameList(forms);

        return answer;
    }
}

class DuplicateNameChecker {
    private static List<String> duplicateMailList = Collections.emptyList();
    private static List<String> reappraiseList = Collections.emptyList();

    public static List<String> checkNameList(List<List<String>> forms) {

        DuplicateWordList duplicateWordList = new DuplicateWordList();

        for (List<String> innerForm : forms) {
            checkNSortOutName(innerForm,duplicateWordList);
        }

        for (String changedInnerForm : reappraiseList) {
            String[] strings = changedInnerForm.split("&&&");

            String[] dividedWords = WordDivider.divideWord(strings[0]);

            for (String word : dividedWords) {
                if(duplicateWordList.isContainList(
                        duplicateWordList.detection ,word)) {
                    duplicateMailList = ListAdder.plzAdd(duplicateMailList, strings[1]);
                }
            }
        }
        duplicateMailList = ListSorter.plzSort(duplicateMailList);

        return duplicateMailList;
    }

    private static void checkNSortOutName(List<String> innerForm,
                                          DuplicateWordList duplicateWordList) {
        String nickName = innerForm.get(0);
        String[] wordlist = WordDivider.divideWord(nickName);
        int countAdded = duplicateWordList.addWords(wordlist);
        if(wordlist.length != countAdded) {
            duplicateMailList = ListAdder.plzAdd(duplicateMailList, innerForm.get(1));
        }

        if(wordlist.length == countAdded) {
            String innerFormString = innerForm.toString();
            innerFormString =
                    innerFormString.substring(1,innerFormString.length() - 1);
            innerFormString = innerFormString.replace(", ","&&&");
            reappraiseList = ListAdder.plzAdd(reappraiseList, innerFormString);
        }
    }
}

class DuplicateWordList {
    public List<String> candidate = Collections.emptyList();
    public List<String> detection = Collections.emptyList();

    public boolean addWord(String word) {

        if (!isContainList(candidate, word)) {
            candidate =
                    ListAdder.plzAdd(candidate, word);
            return true;
        }

        if (!isContainList(detection, word)) {
            detection =
                    ListAdder.plzAdd(detection,word);

        }
        return false;
    }

    public int addWords(String[] words) {

        SuccessCount count = new SuccessCount();

        for (String word : words) {
            count.countSuccess(addWord(word));
        }

        return count.toInt();

    }

    public boolean isContainList(List<String> list ,String word) {
        return list.contains(word);
    }
}


class WordDivider {
    public static String[] divideWord(String word) {
        String[] oneLetters = word.split("");
        String[] dividedWords = new String[oneLetters.length - 1];

        for (int i = 0; i < dividedWords.length; i++) {
            dividedWords[i] = oneLetters[i] + oneLetters[i + 1];
        }

        return dividedWords;
    }
}

class SuccessCount {
    private int successCount;

    public void countSuccess(boolean isSuccess) {
        if (isSuccess) {
            successCount++;
        }
    }

    public int toInt() {
        return successCount;
    }
}


class ListAdder {

    public static List<String> plzAdd(List<String> list, String item) {

        String listString = list.toString();
        listString = listString.substring(1,listString.length() - 1);

        if (list.size() == 0) {
            return List.of(item);
        }

        listString = listString + ", " + item;
        String[] arrString = listString.split(", ");
        return List.of(arrString);
    }
}

class ListSorter {

    public static List<String> plzSort(List<String> list) {

        String[] strings = list.toArray(new String[0]);
        String[] out = new String[1];


        int innerCount = 0;
        out[innerCount] = strings[0];
        innerCount++;

        while (innerCount < strings.length) {
            int index = 0;
            while (index < out.length &&
                    out[index].compareTo(strings[innerCount]) < 0) {
                index++;
            }

            out = pushSlotInArray(out,index);
            out[index] = strings[innerCount];
            innerCount++;
        }

        return List.of(out);
    }


    private static String[] pushSlotInArray(String[] array, int index) {
        String[] strings = new String[array.length + 1];
        int counter = 0;
        int indexer = counter;
        while (counter < array.length) {
            if (counter == index) {
                indexer++;
            }
            strings[indexer] = array[counter];

            indexer++;
            counter++;
        }

        return strings;
    }

}