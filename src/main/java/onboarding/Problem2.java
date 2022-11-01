package onboarding;

import java.util.ArrayList;
import java.util.List;

/*
기능 구현 사항
1. while 돌면서 삭제할 인덱스 찾기
2. 인덱스 값에 해당하는 글자 공백으로 만들기
3. 공백 글자를 제외한 나머지 글자 구하기
4. 인덱스 값이 없거나, 더 이상 남은 글자가 없을 때 종료한다.
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        String result = removeDuplicateWord(cryptogram);
        return result;
    }

    private static String removeDuplicateWord(String cryptogram) {
        int index = 0;
        String result = cryptogram;
        while(true) {
            List<Integer> removeIndexes = getRemoveIndexes(result, index);
            if(removeIndexes.size() == 0) {
                break;
            }
            System.out.println(removeIndexes);
            result = changeDuplicateWord(result, removeIndexes);
        }
        return result;
    }

    private static List<Integer> getRemoveIndexes(String word, int index) {
        List<Integer> removeIndexes = new ArrayList<>();
        if(word.isBlank()) {
            return removeIndexes;
        }
        char previousWord = word.charAt(index);
        for(int i = index+1; i < word.length(); i++) {
            if(previousWord == word.charAt(i)) {
                removeIndexes.add(i);
                removeIndexes.add(i-1);
            }
            previousWord = word.charAt(i);
        }
        return removeIndexes;
    }

    private static String changeDuplicateWord(String cryptogram, List<Integer> duplicateIndexes) {
        char[] cryptogramCharArray = cryptogram.toCharArray();
        for (Integer duplicateIndex : duplicateIndexes) {
            cryptogramCharArray[duplicateIndex] = ' ';
        }
        String removedResult = getResult(cryptogramCharArray);
        System.out.println(removedResult);
        return removedResult;
    }

    private static String getResult(char[] cryptogramCharArray) {
        String removeResult = "";
        for (char word : cryptogramCharArray) {
            if (word == ' ') {
                continue;
            }
            removeResult += word;
        }
        return removeResult;
    }
}
