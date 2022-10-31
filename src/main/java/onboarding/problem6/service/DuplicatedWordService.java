package onboarding.problem6.service;

public class DuplicatedWordService {
    public static boolean isDuplicatedWord(String duplicateWord, String word){
        return word.contains(duplicateWord);
    }

}
