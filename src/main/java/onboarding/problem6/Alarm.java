package onboarding.problem6;

import java.util.*;
import java.util.stream.Collectors;

public class Alarm {

    // 같은 글자가 연속적으로 포함되는 닉네임을 작성한 지원자의 이메일 목록 반환하는 메서드
    public List<String> getEmailOfDuplicatedNicknameUsers(List<List<String>> forms) {

        Validator validator = new Validator();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);
            validator.validate(nickname, email);
        }

        return sortEmails(getEmails(duplicatedTwoLetters(forms), forms));
    }

    // 모두의 닉네임을 가져오는 리스트
    public List<String> getNicknames(List<List<String>> forms) {
        ArrayList<String> nicknames = new ArrayList<>();

        for (List<String> form : forms) {
            nicknames.add(form.get(1));
        }

        return nicknames;
    }

    // 연속된 두 글자로 닉네임을 쪼갠 문자열 리스트
    public List<String> splitNickname(List<String> nicknames) {
        ArrayList<String> twoLetters = new ArrayList<>();

        for (String nickname : nicknames) {
            for (int i = 0; i < nickname.length()-1; i++) {
                twoLetters.add(nickname.substring(i,i+2));
            }
        }
        return twoLetters;
    }


    // 두 글자로 쪼갠 문자열 리스트 중에서 닉네임에 중복으로 포함된 문자열 반환
    public List<String> duplicatedTwoLetters(List<List<String>> forms) {
        List<String> twoLetters = splitNickname(getNicknames(forms));
        Map<String, Integer> map = new HashMap<>();
        List<String> duplicatedTwoLetters = new ArrayList<>();

        for (List<String> form : forms) {
            String nickname = form.get(1);

            for (String twoLetter : twoLetters) {
                if (!map.containsKey(twoLetter)) {
                    map.put(twoLetter, 0);
                }
                else {
                    if (nickname.contains(twoLetter)) {
                        map.put(twoLetter, map.get(twoLetter) + 1);
                    }
                }
            }
        }

        String[] keyArr = map.keySet().toArray(new String[map.size()]);
        for(String key : keyArr){
            if(map.get(key) > 1) {
                duplicatedTwoLetters.add(key);
            }
        }
        return duplicatedTwoLetters;
    }

    // 닉네임에 중복으로 포함된 문자열이 있는 닉네임을 가진 사용자들의 이메일 반환
    public List<String> getEmails(List<String> duplicatedTwoLetters, List<List<String>> forms) {
        ArrayList<String> duplicatedEmails = new ArrayList<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            String nickname = form.get(1);

            for (String twoLetters: duplicatedTwoLetters) {
                if(nickname.contains(twoLetters)) {
                    duplicatedEmails.add(email);
                }
            }
        }
        return duplicatedEmails;

    }

    // 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬하고 중복은 제거
    public List<String> sortEmails(List<String> emails) {
        return emails.stream().distinct().sorted().collect(Collectors.toList());
    }

}
