package onboarding;

import java.util.*;
import java.util.stream.Collectors;

public class Problem6 {
    private static final int MIN_SIZE = 2;
    private static final int EMAIL_MIN_LENGTH = 11;
    private static final int MAX_LENGTH = 19;
    private static final int NICKNAME_MIN_LENGTH = 1;
    private static List<List<String>> data;

    public static List<String> solution(List<List<String>> forms) {
        data = forms;
        data = validateEmail();
        data = validateLength();
        HashSet<String> letters = makeLetterSet(data);
        TreeSet<String> emails = getDuplicateSet(letters, data);
        return new ArrayList<>(emails);
    }

    public static List<List<String>> validateEmail(){ // @email.com을 포함하는 체크
        return data.stream()
                .filter(object->object.get(0).contains("@email.com"))
                .collect(Collectors.toList());
    }

    public static List<List<String>> validateLength(){
        return data.stream()
                .filter(object->object.get(0).length() <= MAX_LENGTH && object.get(0).length() >= EMAIL_MIN_LENGTH
                        && object.get(1).length() <= MAX_LENGTH && object.get(1).length() >= NICKNAME_MIN_LENGTH)
                .collect(Collectors.toList());
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
        TreeSet<String> answer = new TreeSet<>();

        while(iterator.hasNext()){ // 연속된 문자열 순회하면서 nickname이 포함하고 있는지 체크
            String letter = iterator.next();
            answer.addAll(validation(letter, forms)); // 사이즈 2개 이상이라면 TreeSet에 추가 -> 이메일 오름차순 정렬 및 중복 제거
        }
        return answer;
    }

    public static ArrayList<String> validation(String letter, List<List<String>> forms){
        ArrayList<String> temp = new ArrayList<>();
        for(List<String> crew : forms){
            String nickname = crew.get(1);
            if(nickname.contains(letter)){ // letter를 포함하고 있다면
                temp.add(crew.get(0));
            }
        }
        if(temp.size() >= MIN_SIZE) return temp;
        temp.clear();
        return temp;
    }
}
