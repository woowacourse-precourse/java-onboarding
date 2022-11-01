package onboarding;

import java.util.*;

public class Problem6 {
    /*
        기능 요구 사항 목록
        1. 사용자의 닉네임만 추출하는 함수
        2. 사용자의 이메일만 추출하는 함수
        3. 모든 닉네임에서 반복 가능한 문자열 나열 함수
        4. 리스트에서의 문자열 카운터 해시맵 생성 함수
        5. 해시맵에서 값이 1보다 큰 키만 추출하는 함수
        6. 중복 문자열이 포함된 이메일 추출 함수
        7. solution 함수
    */

    // 사용자의 닉네임만 추출하는 함수
    private static List<String> allNicknames(List<List<String>> forms) {
        List<String> nicknames = new ArrayList<>();

        for (List<String> form : forms) {
            String nickname = form.get(1);
            nicknames.add(nickname);
        }
        return nicknames;
    }

    // 사용자의 이메일만 추출하는 함수
    private static List<String> allEmails(List<List<String>> forms) {
        List<String> emails = new ArrayList<>();

        for (List<String> form : forms) {
            String email = form.get(0);
            emails.add(email);
        }
        return emails;
    }

    // 닉네임 하나에 반복 가능한 문자열 추출
    private static List<String> repeatsInName(List<String> substrings, String nickname) {
        for (int i = 0; i < nickname.length()-1; i++) {
            String str = nickname.substring(i, i+2);
            substrings.add(str);
        }
        return substrings;
    }

    // 모든 닉네임에서 반복 가능한 문자열 나열
    private static List<String> allRepeats(List<String> nicknames) {
        List<String> substrings = new ArrayList<>();

        for (String nickname : nicknames)
            repeatsInName(substrings, nickname);

        return substrings;
    }

    // 해시맵에 문자열이 있는지 확인
    private static HashMap<String, Integer> strInMap(HashMap<String, Integer> counter, String substr) {
        // 해시맵에 문자열이 없을 경우
        if (!counter.containsKey(substr)) {
            counter.put(substr, 1);
            return counter;
        }

        // 해시맵에 문자열이 있을 경우
        int value = counter.get(substr) + 1;
        counter.put(substr, value);
        return counter;
    }

    // 리스트에서의 문자열 카운터 해시맵 생성 함수
    private static HashMap<String, Integer> countRepeats(List<String> substrings) {
        HashMap<String, Integer> counter = new HashMap<>();

        // 카운터 실행
        for (String key : substrings)
            strInMap(counter, key);

        return counter;
    }

    // 카운터 해시맵에서 value가 1보다 큰 key만 추출하는 함수
    private static List<String> repeatedString(HashMap<String, Integer> counter) {
        List<String> repeats = new ArrayList<>();

        for (String key : counter.keySet()) {
            int value = counter.get(key);
            if (value > 1) repeats.add(key);
        }
        return repeats;
    }

    // 닉네임에 중복되는 문자열이 있는지 확인
    private static Boolean strInName(String nickname, List<String> repeats) {
        for (String str : repeats) {
            if (nickname.contains(str)) return true;
        }
        return false;
    }

    // 중복 문자열이 포함된 사용자의 이메일 추출 함수
    private static List<String> sendEmail(List<String> repeats, List<String> nicknames, List<String> emails) {
        Set<String> sendSet = new HashSet<>();

        for (String nickname : nicknames) {
            int idx = nicknames.indexOf(nickname);
            String email = emails.get(idx);

            Boolean containsStr = strInName(nickname, repeats);
            if (containsStr) sendSet.add(email);
        }

        List<String> sendList = new ArrayList<>(sendSet);
        Collections.sort(sendList);
        return sendList;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> nicknames = allNicknames(forms);
        List<String> emails = allEmails(forms);
        List<String> possibleStr = allRepeats(nicknames);
        HashMap<String, Integer> counter = countRepeats(possibleStr);
        List<String> repeats = repeatedString(counter);
        List<String> answer = sendEmail(repeats, nicknames, emails);

        return answer;
    }
}
