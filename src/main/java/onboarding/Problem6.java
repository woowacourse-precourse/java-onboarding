package onboarding;

import java.util.*;
import java.util.stream.Collectors;

class Member {
    private static final String DOMAIN = "@email.com";
    private String name;
    private String email;
    private ArrayList<String> words;

    public ArrayList<String> getWords(){
        return words;
    }

    public String getEmail(){
        return email;
    }

    public String getRemoveDomain(){
        return email.replace(DOMAIN, "");
    }

    public Member(String name, String email, ArrayList<String> words) {
        this.name = name;
        this.email = email;
        this.words = words;
    }

}
public class Problem6 {

    private static ArrayList<Member> members = new ArrayList<>(); // 입력받는 전체 멤버들 저장
    private static Set<Member> duplicatedMembers = new HashSet<>(); // 연속되는 글자가 포함된 멤버들을 저장 중복되지 않도록 set 자료구조를 이용

    public static List<String> solution(List<List<String>> forms) {
        setMembers(forms);
        for(int i=0; i<members.size();i++){
            filterDuplicateMember(members.get(i));
        }
        List<String> answer = duplicatedMembers.stream()
                .sorted(Comparator.comparing(Member::getRemoveDomain)) // mail에서 domain을 제거한 후 sorting을 한다.
                .map(Member::getEmail)
                .collect(Collectors.toList());

        return answer;
    }

    /**
     * crew들의 정보로 Member객체 생성
     */

    private static void setMembers(List<List<String>> forms){
        for(List<String> member : forms){
            members.add(new Member(member.get(1), member.get(0),  getConsecutiveWords(member.get(1))));
        }
    }

    /**
     * 멤버 변수 words 에 연속되는 글자들의 조합의 경우의 수를 모두 담는다. 제이슨 -> 제이, 이슨
     */

    private static ArrayList<String> getConsecutiveWords(String name){
        ArrayList<String> words = new ArrayList<>();
        for(int i = 0; i < name.length() - 1; i++){
            words.add(name.substring(i, i + 2));
        }
        return words;
    }

    /**
     * 하나의 멤버(member)를 대상으로 members에 있는 member들의 words에 인자 Member의 words가 포함되는지 확인 후
     * 포함된다면 중복되는 멤버들(duplicatedMembers)에 추가한다.
     */

    private static void filterDuplicateMember(Member member) {
        for (int i = members.indexOf(member) + 1; i < members.size(); i++) {
            int index = i;
            if (member.getWords().stream().anyMatch( w -> members.get(index).getWords().contains(w))) {
                duplicatedMembers.add(member);
                duplicatedMembers.add(members.get(index));
            }
        }
    }
}
