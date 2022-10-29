package onboarding;

import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.HashSet;
public class Problem6 {
    private static final HashMap<String, String> TwoCharacterMap = new HashMap<>();
    private static final HashSet<String> AnswerEmailSet = new HashSet<>();

    public static List<String> splitNameEveryTwoCharacter(String name){
        List<String> twoCharacterList = new LinkedList<>();
        for(int i = 0; i < name.length() - 1; i++){
            String twoCharacters = name.substring(i, i + 2);
            twoCharacterList.add(twoCharacters);
        }
        return twoCharacterList;
    }

    public static void checkTwoCharacterListDuplicate(List<String> twoCharacterList, String email){
        for(String twoCharacter : twoCharacterList){
            if(TwoCharacterMap.containsKey(twoCharacter)){
                addEmailOfDuplicate(twoCharacter, email);
                continue;
            }
            TwoCharacterMap.put(twoCharacter, email);
        }
    }

    public static void addEmailOfDuplicate(String twoCharacter, String newEmail){
        String matchingEmail = TwoCharacterMap.get(twoCharacter);
        if(areDifferentEmails(newEmail, matchingEmail)){
            AnswerEmailSet.add(newEmail);
            AnswerEmailSet.add(matchingEmail);
        }
    }

    public static boolean areDifferentEmails(String email1, String email2){
        return !email1.equals(email2);
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new LinkedList<>();
        for(List<String> user : forms){
            String email = user.get(0);
            String name = user.get(1);
            List<String> twoCharacterList = splitNameEveryTwoCharacter(name);
            checkTwoCharacterListDuplicate(twoCharacterList, email);
        }
        return answer;
    }
}
