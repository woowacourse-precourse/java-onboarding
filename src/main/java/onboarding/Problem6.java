package onboarding;

import org.mockito.internal.matchers.CompareTo;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashMap<String, HashSet<Integer>> nicknameDictionary = new HashMap<>();
        for (List<String> form : forms) {
            nicknameDictionary.put(form.get(0), makeHashList(form.get(1)));
        }
        ArrayList<String> emailList = new ArrayList<>(nicknameDictionary.keySet());
        HashSet<String> duplicateList = new HashSet<>();
        for (int i = 0; i < emailList.size(); i++) {
            for (int j = i + 1; j < emailList.size(); j++) {
                String userEmail1 = emailList.get(i);
                String userEmail2 = emailList.get(j);
                if (isContainString(nicknameDictionary.get(userEmail1), nicknameDictionary.get(userEmail2))) {
                    duplicateList.add(userEmail1);
                    duplicateList.add(userEmail2);
                }
            }
        }
        List<String> answer = new ArrayList<>(duplicateList);
        answer.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String id1 = o1.split("@")[0];
                String id2 = o2.split("@")[0];
                return id1.compareTo(id2);
            }
        });
        return answer;
    }

    // 2글자씩 잘라서 set으로 만드는 기능
    public static HashSet<Integer> makeHashList(String nickname) {
        HashSet<Integer> hashList = new HashSet<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            String substring = nickname.substring(i, i + 2);
            int hashCode = substring.hashCode();
            hashList.add(hashCode);
        }
        return hashList;
    }
    // 부분 문자열 포함 확인 기능
    public static boolean isContainString(Set<Integer> nicknameHashList1, Set<Integer> nicknameHashList2) {
        int total = nicknameHashList1.size() + nicknameHashList2.size();
        HashSet<Integer> unionSet = new HashSet<>();
        unionSet.addAll(nicknameHashList1);
        unionSet.addAll(nicknameHashList2);
        // 두 개를 전부 더한 집합의 크기와 두 개를 합친 set의 크기를 비교하여 다를 경우 중복이 발생한 것.
        return total != unionSet.size();
    }
}
