package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Problem6 {

    private static ArrayList<HashMap<Character,ArrayList<Character>>> crewSubstring = new ArrayList<>();
    private static boolean[] crewDuplication = new boolean[10000];
    public static List<String> solution(List<List<String>> forms) {

        initializeCrewSubstring(forms);
        checkAllCrewDuplicated(forms);
        return addAllDuplicatedCrewEmail(forms);
    }

    private static HashMap<Character, ArrayList<Character>> addHashMap(String crewName){
        HashMap<Character, ArrayList<Character>> substringMap = new HashMap<Character, ArrayList<Character>>();

        for (int i = 0; i < crewName.length() - 1; i++) {
            Character key = crewName.charAt(i);
            Character value = crewName.charAt(i + 1);

            ArrayList<Character> list = new ArrayList<Character>();

            if (substringMap.containsKey(key)) {
                list = substringMap.get(key);
                list.add(value);
            }else{
                list.add(value);
            }

            substringMap.put(key, list);
        }

        return substringMap;
    }

    private static void initializeCrewSubstring(List<List<String>> forms) {
        for (int i = 0; i < forms.size(); i++) {
            crewSubstring.add(addHashMap(forms.get(i).get(1)));
        }
    }

    // 닉네임이 부분문자열 해쉬맵에 있는지 확인
    private static boolean checkHashMap(String crewName,HashMap<Character,ArrayList<Character>> substringMap){
        for (int i = 0; i < crewName.length() - 1; i++) {
            Character key = crewName.charAt(i); // 첫번째 글자
            Character value = crewName.charAt(i + 1); // 두번째 글자

            if (substringMap.containsKey(key)) {
                if(substringMap.get(key).contains(value))
                 return true;
            }
        }

        return false;
    }

    // 특정 크루의 닉네임을 다른 모든 크루의 부분문자열 정보와 확인
    // 다른 크루와 중복된다면 그 크루의 인덱스 반환
    // 중복 없다면 -1 반환
    private static int isCrewDuplicated(String crewName, int crewIndex){
        for (int i = 0; i < crewSubstring.size(); i++) {
            if(i == crewIndex) continue;

            if (checkHashMap(crewName, crewSubstring.get(i))) {
                return i;
            }
        }

        return -1;
    }

    // 모든 크루의 닉네임의 중복 검사
    private static void checkAllCrewDuplicated(List<List<String>> forms){
        for (int i = 0; i < forms.size(); i++) {
            int duplicatedCrew = isCrewDuplicated(forms.get(i).get(1), i);
            if (duplicatedCrew > 0) {
                crewDuplication[i] = true;
                crewDuplication[duplicatedCrew] = true;
            }
        }
    }

    // 중복 확인된 크루의 이메일을 리스트에 추가 후 정렬된 리스트 반환
    private static List<String> addAllDuplicatedCrewEmail(List<List<String>> forms) {
        List<String> emails = new ArrayList<>();

        for (int i = 0; i < forms.size(); i++) {
            if (crewDuplication[i]) {
                emails.add(forms.get(i).get(0));
            }
        }

        Collections.sort(emails);
        return emails;
    }
}
