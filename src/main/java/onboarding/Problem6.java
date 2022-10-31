package onboarding;

import java.util.*;

public class Problem6 {

    static class Form{
        String nickname;
        String email;

        public Form(String nickname, String email) throws Exception {
            if (!isValidEmail(email)) {
                throw new Exception("Wrong email");
            }

            if (!isValidNickname(nickname)) {
                throw new Exception("Wrong name");
            }

            this.nickname = nickname;
            this.email = email;
        }

        private boolean isValidNickname(String nickname) {
            if (!isKoreanNickname(nickname)) return false;
            if (!isValidNicknameSize(nickname.length())) return false;

            return true;
        }

        private boolean isValidNicknameSize(int length) {
            return length >= 1 && length < 20;
        }

        private boolean isKoreanNickname(String nickname) {
            boolean isKorean = true;
            for (int i = 0; i < nickname.length() ; i++) {
                isKorean = isKoreanCharacter(nickname.charAt(i));
            }

            return isKorean;
        }

        private boolean isKoreanCharacter(char c) {
            return (c >= '가' && c <= '힣') || (c >= 'ㄱ' && c <= 'ㅎ');
        }

        private boolean isValidEmail(String email) {
            if (!isValidEmailSize(email.length())) return false;
            if (!isContainsEmail(email)) return false;

            return true;
        }

        private boolean isContainsEmail(String email) {
            String[] s = email.split("@");
            return s[1].equals("email.com");
        }

        private boolean isValidEmailSize(int length) {
            return length >= 11 && length< 20;
        }
    }

    private static boolean isValidPersonal(int n) {
        return n >= 1 && n <= 10_000;
    }

    static HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
    static TreeSet<String> treeSet = new TreeSet<String>();
    static HashSet<String> hashSet = new HashSet<String>();
    List<List<String>> list;
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("");
        if(!isValidPersonal(forms.size())) return answer;
        List<List<String>> list = new ArrayList<>();
        for (List<String> strings : forms) {
            try {
                Form form = new Form(strings.get(1), strings.get(0));
                List<String> temp = List.of(form.nickname, form.email);
                list.add(temp);
            } catch (Exception e) {
                e.printStackTrace();
                return answer;
            }
        }
        for (List<String> strings : list) {
            addStringToHashMap(strings.get(0));
        }
        for (Map.Entry<String, Integer> stringIntegerEntry : hashMap.entrySet()) {
            putHashSetToMoreThan2LengthString(stringIntegerEntry);
        }
        for (String s : hashSet) {
            putTreeSet(s, list);
        }
        System.out.println(treeSet);






        return answer;
    }

    private static void putTreeSet(String s, List<List<String>> list) {
        for (List<String> strings : list) {
            putEmailToTreeSet(s,strings);
        }
    }

    private static void putEmailToTreeSet(String s, List<String> strings) {
        if (strings.get(0).contains(s)) {
            treeSet.add(strings.get(1));
        }
    }

    private static void putHashSetToMoreThan2LengthString(Map.Entry<String, Integer> stringIntegerEntry) {
        if (stringIntegerEntry.getValue() >= 2) {
            hashSet.add(stringIntegerEntry.getKey());
        }
    }

    private static void addStringToHashMap(String s) {
        HashSet<String> temp = new HashSet<String>();
        for (int i = 0; i <s.length()-1 ; i++) {
            String tempString = s.substring(i, i + 2);
            temp.add(putString(tempString, temp));
        }
    }

    private static String putString(String tempString, HashSet<String> temp) {
        if (!temp.contains(tempString)) {
            hashMap.put(tempString, hashMap.getOrDefault(tempString, 0) + 1);
            return tempString;
        }

        return "";
    }
}
