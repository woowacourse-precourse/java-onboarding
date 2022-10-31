package onboarding;

import java.util.*;

public class Problem6 {
    /*
        기능 요구 사항 목록
        1. 사용자의 닉네임만 추출하는 함수
        2. 사용자의 이메일만 추출하는 함수
        3. 연속될 수 있는 문자열 추출 함수
        4. 문자열 카운터 해시맵 생성 함수
        5. 해시맵에서 값이 1보다 큰 키만 추출하는 함수
        6. 중복 문자열이 포함된 이메일 추출 함수
        7. solution (함수 순서대로 실행)
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

    // 연속될 수 있는 문자열 모두 추출하는 함수 (중복값이 포함된 리스트)
    private static List<String> possibleSubstrings(List<String> nicknames) {
        List<String> substrings = new ArrayList<>();

        for (String nickname : nicknames) {
            for (int i = 0; i < nickname.length()-1; i++) {
                String str = nickname.substring(i, i+2);
                substrings.add(str);
            }
        }
        return substrings;
    }

    // 리스트에서의 문자열 카운터 해시맵 생성 함수
    private static HashMap<String, Integer> stringCounter(List<String> substrings) {
        HashMap<String, Integer> counter = new HashMap<>();
        Set<String> strSet = Set.copyOf(substrings);

        // 카운터 해시맵의 value를 모두 0으로 초기화
        for (String str : strSet)
            counter.put(str, 0);

        // 카운터 실행
        for (String key : substrings) {
            if (counter.containsKey(key)) {
                int value = counter.get(key) + 1;
                counter.put(key, value);
            }
        }
        return counter;
    }

    // 카운터 해시맵에서 value가 1보다 큰 key만 추출하는 함수
    private static List<String> repeatedSubstr(HashMap<String, Integer> counter) {
        List<String> repeats = new ArrayList<>();

        for (String key : counter.keySet()) {
            int value = counter.get(key);
            if (value > 1) repeats.add(key);
        }
        return repeats;
    }

    // 중복 문자열이 포함된 사용자의 이메일 추출 함수
    private static List<String> sendEmail(List<String> repeats, List<String> nicknames, List<String> emails) {
        Set<String> sendSet = new HashSet<>();

        for (int i = 0; i < nicknames.size(); i++) {
            for (String str : repeats) {
                String nickname = nicknames.get(i);
                String email = emails.get(i);

                if (nickname.contains(str)) sendSet.add(email);
            }
        }

        List<String> sendList = new ArrayList<>(sendSet);
        Collections.sort(sendList);
        return sendList;
    }

    public static List<String> solution(List<List<String>> forms) {
        List<String> nicknames = allNicknames(forms);
        List<String> emails = allEmails(forms);
        List<String> possibleStr = possibleSubstrings(nicknames);
        HashMap<String, Integer> counter = stringCounter(possibleStr);
        List<String> repeats = repeatedSubstr(counter);
        List<String> answer = sendEmail(repeats, nicknames, emails);

        return answer;
    }
}
