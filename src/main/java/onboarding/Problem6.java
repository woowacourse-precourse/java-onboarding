package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        HashMap<String,Set<String>> words = new HashMap<>();

        for(int i=0;i<forms.size();i++){
            String word = forms.get(i).get(1);
            String email = forms.get(i).get(0);
            List<String> wordslist = getWords(word);
            wordslist.forEach(w -> words.put(w,getEmailList(words,w,email)));
        }
        for(int i=0;i<forms.size();i++){
            String word = forms.get(i).get(1);
            String email = forms.get(i).get(0);
            if (checkDuplication(words,word)){
                answer.add(email);
            }
        }
        Collections.sort(answer);
        return answer;
    }
    public static List<String> getWords(String word){
        List<String> words = new ArrayList<>();
        for(int i=0;i<word.length()-1;i++){
            words.add(word.substring(i,i+2));
        }
        return words;
    }
    public static Set<String> getEmailList(HashMap<String,Set<String>> words,String word,String email){
        Set<String> str1 = words.getOrDefault(word,new TreeSet<>());
        str1.add(email);
        return str1;
    }

    public static boolean checkDuplication(HashMap<String,Set<String>> words,String word){
        List<String> wordList = getWords(word);
        for(String w:wordList){
            int a= words.get(w).size();
            if (a > 1){
                return true;
            }
        }
        return false;
    }
}
