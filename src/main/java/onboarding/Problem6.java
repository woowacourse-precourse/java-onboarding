package onboarding;

import java.util.*;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<List<String>> answer = new ArrayList<>();

        if (!isValidCrewSize(forms.size())) {
            return Collections.emptyList();
        }

        for(List<String> data : forms){
            if(checkLength(data.get(0)) && checkDomain(data.get(0))
                    && checkNickValid(data.get(1)) && checkNickLength(data.get(1))){
                answer.add(data);
            }
            else{
                continue;
            }
        }
        List<String> wordsDict = createWordsDictionary(answer);
        Set<String> duplicatedComponents = checkDuplicatedComponents(forms, wordsDict);

        return answer;
    }

    private static boolean isValidCrewSize(int size) {
        return size >= 1 && size <= 10000;
    }

    private static boolean checkLength(String emails) {
        int emailLength = emails.length();
        return emailLength >= 11 && emailLength < 20;
    }

    private static boolean checkDomain(String emails) {
        String str = "@email.com";
        return emails.substring(emails.indexOf('@')).equals(str);
    }

    private static boolean checkNickValid(String nickname) {
        return nickname.matches("^[가-힣]*$") == true;
    }

    private static boolean checkNickLength(String nickname) {
        return nickname.length() >= 1 && nickname.length() < 20;
    }

    private static List<String> createWordsDictionary(List<List<String>> forms) {
        List<String> wordsList = new ArrayList<>();

        for (List<String> data : forms) {
            String nickname = data.get(1);
            for (int character = 0; character < nickname.length()-1 ; character++) {
                wordsList.add(nickname.substring(character, character+2));
            }
        }
        return wordsList;
    }

    private static Set<String> checkDuplicatedComponents(List<List<String>> forms, List<String> compareWords) {
        Set<String> duplicatedNickname = new HashSet<>();
        String preEmail = "";
        String nextEmail = "";
        String nextNickname = "";

        for(List<String> data : forms) {
            preEmail = data.get(0);
            for(int nxt = forms.indexOf(data) + 1; nxt < forms.size(); nxt++) {
                nextEmail = forms.get(nxt).get(0);
                nextNickname = forms.get(nxt).get(1);
                for (String word : compareWords) {
                    if(nextNickname.contains(word)) {
                        duplicatedNickname.add(preEmail);
                        duplicatedNickname.add(nextEmail);
                        break;
                    }
                    break;
                }
            }
            break;
        }
        return duplicatedNickname;
    }

}
