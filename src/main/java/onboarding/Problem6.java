package onboarding;

import java.util.*;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        HashSet<String> letters = makeLetterSet(forms);
        TreeSet<String> emails = getDuplicateSet(letters, forms);
        return new ArrayList<>(emails);
    }

    public static HashSet<String> makeLetterSet(List<List<String>> forms) {
        HashSet<String> letters = new HashSet<>();
        for(List<String> crew : forms){
            String nickname = crew.get(1);
            for(int i = 0; i < nickname.length() - 1; i++){ // 두개의 연속된 문자열 HashSet에 추가
                letters.add(nickname.substring(i, i + 2));
            }
        }
        return letters;
    }

    public static TreeSet<String> getDuplicateSet(HashSet<String> letters, List<List<String>> forms){
        Iterator<String> iterator = letters.iterator();
        ArrayList<String> temp = new ArrayList<>();
        TreeSet<String> answer = new TreeSet<>();

        while(iterator.hasNext()){ // 연속된 문자열 순회하면서 nickname이 포함하고 있는지 체크
            String letter = iterator.next();
            for(List<String> crew : forms){
                String nickname = crew.get(1);
                if(nickname.contains(letter)){
                    temp.add(crew.get(0));
                }
            }
            if(temp.size() >= 2) answer.addAll(temp); // 사이즈 2개 이상이라면 TreeSet에 추가 -> 이메일 오름차순 정렬 및 중복 제거
            temp.clear();
        }
        return answer;
    }
}
