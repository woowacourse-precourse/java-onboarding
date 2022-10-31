package onboarding;

import java.util.*;
import java.util.stream.Collectors;

class Member {
    private static final String DOMAIN = "email.com";
    private String name;
    private String email;
    private ArrayList<String> words;

    public ArrayList<String> getWords(){
        return words;
    }

    public String getEmail(){
        return email;
    }

    public String removeDomain(){
        return email.replace(DOMAIN, "");
    }

    public Member(String name, String email, ArrayList<String> words) {
        this.name = name;
        this.email = email;
        this.words = words;
    }

}
public class Problem6 {

    private static ArrayList<Member> members = new ArrayList<>();
    private static Set<Member> duplicatedMembers = new HashSet<>();

    public static List<String> solution(List<List<String>> forms) {
        setMembers(forms);
        for(int i=0; i<members.size();i++){
            filterDuplicateMember(members.get(i));
        }
        List<String> answer = duplicatedMembers.stream()
                .sorted(Comparator.comparing(Member::removeDomain))
                .map(Member::getEmail)
                .collect(Collectors.toList());

        return answer;
    }

    private static void setMembers(List<List<String>> forms){
        for(List<String> member : forms){
            members.add(new Member(member.get(1), member.get(0),  getConsecutiveWords(member.get(1))));
        }
    }

    private static ArrayList<String> getConsecutiveWords(String name){
        ArrayList<String> words = new ArrayList<>();
        for(int i = 0; i < name.length() - 1; i++){
            words.add(name.substring(i, i + 2));
        }
        return words;
    }

    private static void filterDuplicateMember(Member member) {
        for (int i = members.indexOf(member) + 1; i < members.size(); i++) {
            int index = i;
            if (member.getWords().stream().anyMatch(w -> members.get(index).getWords().contains(w))) {
                duplicatedMembers.add(member);
                duplicatedMembers.add(members.get(index));
            }
        }
    }
}
