package onboarding;

import java.util.Collections;
import java.util.List;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.HashSet;
public class Problem6 {
    private static final HashMap<String, String> TWO_CHARACTER_MAP = new HashMap<>();
    private static final HashSet<String> ANSWER_EMAIL_SET = new HashSet<>();

    public static void processForms(List<List<String>> forms){
        for(List<String> user : forms){
            String email = user.get(0);
            String name = user.get(1);
            List<String> twoCharacterList = splitNameEveryTwoCharacter(name);
            checkTwoCharacterListDuplicate(twoCharacterList, email);
        }
    }

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
            checkMapContainsTwoCharacter(twoCharacter, email);
        }
    }

    public static void checkMapContainsTwoCharacter(String twoCharacter, String email){
        if(TWO_CHARACTER_MAP.containsKey(twoCharacter)){
            addEmailOfDuplicate(twoCharacter, email);
            return;
        }
        TWO_CHARACTER_MAP.put(twoCharacter, email);
    }

    public static void addEmailOfDuplicate(String twoCharacter, String newEmail){
        String matchingEmail = TWO_CHARACTER_MAP.get(twoCharacter);
        if(areDifferentEmails(newEmail, matchingEmail)){
            ANSWER_EMAIL_SET.add(newEmail);
            ANSWER_EMAIL_SET.add(matchingEmail);
        }
    }

    public static boolean areDifferentEmails(String email1, String email2){
        return !email1.equals(email2);
    }

    public static void moveFromSetToList(List<String> answer){
        for(String email : ANSWER_EMAIL_SET){ //todo: should I use addall() and remove this method?
            answer.add(email);
        }
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new LinkedList<>();
        processForms(forms);
        moveFromSetToList(answer);
        Collections.sort(answer);
        return answer;
    }
}
