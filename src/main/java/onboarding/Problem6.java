package onboarding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.*;

public class Problem6 {

    private static final String EMAIL_DOMAIN = "@email.com";
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        Map<String, ArrayList<String>> consecutiveLettersMap = new HashMap<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            if (isValidForm(email, nickname)){ // email, nicknamee 유효성 검사
                makeConsecutiveLettersMap(consecutiveLettersMap, form); // 닉네임의 모든 연속적인 두 글자에 대한 맵 만들기
            }
        }

        return answer;
    }


    private static boolean isValidForm(String email, String nickname) {
        boolean isValidEmail = email.endsWith(EMAIL_DOMAIN);
        boolean isValidNickname = isHangulNickname(nickname);
        return (isValidEmail && isValidNickname);
    }

    private static String getConsecutiveLetters(char firstLetter, char secondLetter){
        return append(firstLetter)
                .append(secondLetter)
                .toString();
    }

    private static void makeConsecutiveLettersMap(Map<String, ArrayList<String>> lettersMap, List<String> info){
        String email = info.get(0);
        String nickname = info.get(1);
        char[] nickNameArray = nickname.toCharArray();

        for(int i=0;i<nickNameArray.length-1;i++){
            String letters = getConsecutiveLetters(nickNameArray[i],nickNameArray[i+1]);
            addToLettersMap(lettersMap, letters, email);
        }

    }
    private static void addToLettersMap(Map<String, ArrayList<String>> lettersMap, String letters, String email){
        ArrayList<String> arr;
        if(lettersMap.containsKey(letters)){
            arr = lettersMap.get(letters);
        }else{
            arr = new ArrayList<>();
        }
        arr.add(email);
        lettersMap.put(letters,arr);
    }

    private static boolean isHangulNickname(String nickname){
        for(char letter : nickname.toCharArray()){
            if(!valueOf(letter).matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*")){
                return false;
            }
        }
        return true;
    }
}