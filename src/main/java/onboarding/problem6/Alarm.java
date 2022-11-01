package onboarding.problem6;

import java.util.*;

public class Alarm {


    // 모두의 닉네임을 가져오는 리스트
    public List<String> getNickNames(List<List<String>> forms) {
        ArrayList<String> nicknames = new ArrayList<>();

        for (List<String> form : forms) {
            nicknames.add(form.get(1));
        }

        return nicknames;
    }

    // 연속된 두 글자로 닉네임을 쪼갠 문자열 리스트
    public List<String> splitNickName(List<String> nicknames) {
        ArrayList<String> twoLetterNickNames = new ArrayList<>();

        for (String nickname : nicknames) {
            for (int i = 0; i < nickname.length()-1; i++) {
                twoLetterNickNames.add(nickname.substring(i,i+2));
            }
        }
        return twoLetterNickNames;
    }


    // 두 글자로 쪼갠 문자열 리스트 중에서 닉네임에 중복으로 포함된 문자열 반환
    public List<String> duplicatedTwoLetterNicknames(List<List<String>> forms) {
        List<String> twoLetterNickNames = splitNickName(getNickNames(forms));
        Map<String, Integer> map = new HashMap<>();
        List<String> duplicatedTwoLetters = new ArrayList<>();

        for (List<String> form : forms) {
            String nickname = form.get(1);

            for (String twoLetterNickName : twoLetterNickNames) {
                if (!map.containsKey(twoLetterNickName)) {
                    map.put(twoLetterNickName, 0);
                }
                else {
                    if (nickname.contains(twoLetterNickName)) {
                        map.put(twoLetterNickName, map.get(twoLetterNickName) + 1);
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

}
