package onboarding;

import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {
    private static Map<String, String> nicknamePieceAndOwner = new HashMap<>();
    private static Set<String> duplicatedUserEmail = new HashSet<>();

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        if(!checkValidation(forms)){
            return null;
        }
        answer = getListOfDuplicateNickname(forms);
        return answer;
    }

    private static boolean checkValidation(List<List<String>> forms){
        if(dataAmountValidation(forms) || nicknameValidation(forms) || emailValidation(forms)){
            return true;
        }
        return false;
    }

    private static boolean dataAmountValidation(List<List<String>> forms){
        if(1<=forms.size() && forms.size()<=10000){
            return true;
        }
        return false;
    }

    private static boolean nicknameValidation(List<List<String>> forms){
        final int MAX_LENGTH = 20;
        final String NICKNAME_REGEX = "[가-힣]+$";
        return forms.stream()
                .allMatch((a) -> (Pattern.matches(NICKNAME_REGEX,a.get(1))) && (a.get(1)).length()<=MAX_LENGTH);
    }

    private static boolean emailValidation(List<List<String>> forms){
        return forms.stream().map(a-> a.get(0)).allMatch(checkEmailValidation());
    }

    public static Predicate<String> checkEmailValidation(){
        final int MIN_LENGTH = 11;
        final int MAX_LENGTH = 20;
        final String EMAIL_REGEX  = "^\\w+@email\\.com";
        return (target)-> Pattern.matches(EMAIL_REGEX, target)
                && (target.length() <= MAX_LENGTH
                && (MIN_LENGTH <= (target.length())));
    }   

    private static List<String> getListOfDuplicateNickname(List<List<String>> forms){
        for(List<String> user : forms){
            List<String> devidedNicknamePiece = getDevidedNicknamePiece(user.get(1));
            String pieceOwnerEmail = user.get(0);
            enrollNicknamePieceAndOwner(devidedNicknamePiece, pieceOwnerEmail);
        }
        return getSortedDuplicatedList();
    }

    private static List<String> getDevidedNicknamePiece(String nickname){
        List<String> nicknamePieces = new ArrayList<>();
        for(int i=0; i<nickname.length()-1; i++){
            nicknamePieces.add(nickname.substring(i,i+2));
        }
        return nicknamePieces;
    }

    private static void enrollNicknamePieceAndOwner(List<String> pieces, String owner){
        for(String nicknamePiece : pieces){
            if(nicknamePieceAndOwner.containsKey(nicknamePiece)){
                addUserInDuplicatedUser(owner);
                addUserInDuplicatedUser(nicknamePieceAndOwner.get(nicknamePiece));
                continue;
            }
            nicknamePieceAndOwner.put(nicknamePiece,owner);
        }
    }

    private static void addUserInDuplicatedUser(String useremail){
        duplicatedUserEmail.add(useremail);
    }

    private static List<String> getSortedDuplicatedList(){
        return duplicatedUserEmail.stream().sorted().collect(Collectors.toList());
    }

}
