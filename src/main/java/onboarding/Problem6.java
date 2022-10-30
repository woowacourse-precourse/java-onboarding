package onboarding;

import com.sun.source.tree.SynchronizedTree;

import java.util.*;

public class Problem6 {

    // 각 서브 단어들을 전부 모은다.
    static Set<String> findWords(String nick) {
        Set<String> wordset = new HashSet<>();
        for(int i=2; i<=nick.length(); i++) {
            for(int j=0; j<nick.length()-i+1; j++) {
                String subword = nick.substring(j, j+i);
                wordset.add(subword);
            }
        }
        return wordset;
    }
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>(); // 이메일 담을 리스트
        Set<String> allWords = new HashSet<>(); // 모든 서브 단어들
        // 각 단어의 서브 단어들을 모은다.
        for(List<String> form : forms) {
            allWords.addAll(findWords(form.get(1)));
        }

        return new ArrayList<>(answer);
    }
}
