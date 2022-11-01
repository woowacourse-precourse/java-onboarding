package onboarding;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Problem6 pb6 = new Problem6();
        Map<String, Integer> nicknameMap = new HashMap<>();
        Set<Integer> alertIdxSet = new HashSet<>();
        for(int i = 0; i < forms.size(); i++) {
            List<String> user = forms.get(i);
            String email = user.get(0);
            String nickname = user.get(1);

            if(!pb6.isValidEmail(email) || !pb6.isValidNickname(nickname)) {
                continue;
            }

            pb6.getNickname(nickname, i, nicknameMap, alertIdxSet);
        }

        List<String> answer = pb6.putIndexInAlertList(alertIdxSet, forms);
        pb6.sortAlertEmailList(answer);
        return answer;
    }

    public boolean isValidEmail(String email) {
        String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@email.com";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(email);
        return m.matches() && email.length() >= 11 && email.length() <= 20;
    }

    public boolean isValidNickname(String nickname) {
        String regex= "[ㄱ-ㅎㅏ-ㅣ가-힣]";
        String tmp = nickname;
        tmp = tmp.replaceAll(regex, "");
        return tmp.length() == 0;
    }

    public void getNickname(String nickname, int idx, Map<String, Integer> nicknameMap, Set<Integer> alertIdxSet) {
        for (int i = 0; i < nickname.length() - 1; i++){
            char nicknameChar1 = nickname.charAt(i);
            char nicknameChar2 = nickname.charAt(i + 1);

            String words = String.valueOf(nicknameChar1) + String.valueOf(nicknameChar2);
            if (!nicknameMap.containsKey(words)) {
                nicknameMap.put(words, idx);
                continue;
            }
            int overlapIdx = nicknameMap.get(words);
            alertIdxSet.add(overlapIdx);
            alertIdxSet.add(idx);
        }
    }

    public List<String> putIndexInAlertList(Set<Integer> alertIdxSet, List<List<String>> forms) {
        List<String> alertEmailList = new ArrayList<>();
        for(Integer index: alertIdxSet) {
            String email = findUserEmail(index, forms);
            alertEmailList.add(email);
        }
        return alertEmailList;
    }

    public String findUserEmail(int index, List<List<String>> forms) {
        List<String> userInfo = forms.get(index);
        return userInfo.get(0);
    }

    public void sortAlertEmailList(List<String> alertEmailList) {
        alertEmailList.sort(new Comparator<String>() {
            @Override
            public int compare(String email1, String email2) {
                String str1 = getEmailString(email1);
                String str2 = getEmailString(email2);
                int minimumLength = Math.min(str1.length(), str2.length());
                int idx = 0;
                while(idx < minimumLength && str1.charAt(idx) == str2.charAt(idx)) {
                    idx++;
                }
                if(idx == minimumLength) {
                    // 만약 "wone"와 "wone123"이 있을 때 "wone"을 먼저 출력한다.
                    return str1.length() - str2.length();
                }
                return str1.charAt(idx) - str2.charAt(idx);
            }
        });
    }

    public String getEmailString(String email) {
        return email.substring(0, email.length() - 10);
    }
}
