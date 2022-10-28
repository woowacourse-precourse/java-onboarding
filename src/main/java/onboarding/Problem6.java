package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> unclearNicknames = new ArrayList<>();
        List<List<String>> twoLetterWordsAll = new ArrayList<>();

        for (List<String> form : forms) {
            twoLetterWordsAll.add(createTwoLetterWord(form.get(1)));
        }

        for(int i=0; i<twoLetterWordsAll.size(); i++) {
            if(!unclearNicknames.contains(forms.get(i).get(0))) {
                for(int k=i+1; k<twoLetterWordsAll.size(); k++) {
                    if(isContainOverlapWord(twoLetterWordsAll.get(i), twoLetterWordsAll.get(k))) {
                        if(!unclearNicknames.contains(forms.get(i).get(0)))
                            unclearNicknames.add(forms.get(i).get(0));
                        unclearNicknames.add(forms.get(k).get(0));
                    }
                }
            }
        }

        Collections.sort(unclearNicknames);

        return unclearNicknames;
    }

    private static List<String> createTwoLetterWord(String nickname) {
        List<String> twoLetterWords = new ArrayList<>();

        for(int i=0; i<nickname.length()-1; i++) {
            twoLetterWords.add(nickname.substring(i, i+2));
        }

        return twoLetterWords;
    }

    private static boolean isContainOverlapWord(List<String> words1, List<String> words2) {
        boolean status = false;

        for (String word : words1) {
            if(words2.contains(word)){
                status = true;
                break;
            }
        }

        return status;
    }
}
