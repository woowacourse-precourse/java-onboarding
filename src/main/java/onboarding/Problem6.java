package onboarding;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> formsMap = listToMap(forms);
        if(validateEmailPattern(formsMap).size() != 0) {
            throw new InputMismatchException("형식에 맞지 않는 이메일이 존재합니다.");
        }

        List<String> answer = validateNicknamePattern(formsMap);
        return answer;
    }

    public static Map<String, String> listToMap(List<List<String>> forms) {
        Map<String, String> formsMap = new HashMap<>();
        for(List<String> form : forms) {
            formsMap.put(form.get(1), form.get(0));
        }
        return formsMap;
    }

    public static List<String> validateEmailPattern(Map<String, String> forms) {

        String emailRegex = "^[0-9a-zA-Z-_]{1,9}@email.com$";
        Pattern emailPattern = Pattern.compile(emailRegex);

        Collection<String> emailList = forms.values();
        List<String> invalidEmailList = new ArrayList<>();

        for(String email : emailList) {
            Matcher matching = emailPattern.matcher(email);
            if(!matching.matches())
                invalidEmailList.add(email);
        }
        return invalidEmailList;
    }

    public static List<String> validateNicknamePattern(Map<String, String> forms) {

        List<String> nicknameList = new ArrayList<>(forms.keySet());
        List<String> duplicatedNickname = new ArrayList<>();

        for(int i = 0; i < nicknameList.size()-1; i++) {
            duplicatedNickname.addAll(findDuplicatedNickname(nicknameList, i));
        }

        List<String> duplicatedCrewEmail = new ArrayList<>();
        for(String nickname : duplicatedNickname) {
            duplicatedCrewEmail.add(forms.get(nickname));
        }

        duplicatedCrewEmail.sort(Comparator.naturalOrder());
        return duplicatedCrewEmail.stream().distinct().collect(Collectors.toList()); // 리스트 내 중복 제거
    }

    public static List<String> findDuplicatedNickname(List<String> nicknameList, int index) {
        String nickname = nicknameList.get(index);
        List<String> duplicatedCrew = new ArrayList<>();

        for(int i = 0; i < nickname.length()-1; i++) {
            Pattern nicknamePattern = composeNicknamePattern(nickname, i);

            for(int r = index+1; r < nicknameList.size(); r++) {
                Matcher matching = nicknamePattern.matcher(nicknameList.get(r));
                if(matching.matches()) {
                    duplicatedCrew.add(nicknameList.get(r));
                    duplicatedCrew.add(nickname);
                }
            }
        }
        return duplicatedCrew;
    }

    public static Pattern composeNicknamePattern(String nickname, int chunkIdx) {
        String chunk = nickname.substring(chunkIdx, chunkIdx + 2);
        String regex = String.format("^([가-힇]?(%s)[가-힇]?){1,19}$", Pattern.quote(chunk));
        return Pattern.compile(regex);
    }
}