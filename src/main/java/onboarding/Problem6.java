package onboarding;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

class Name {
    private String name;

    public Name(String name) {
        validateHangeul(name);
        validateLength(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void validateHangeul(String name) {
        if (!name.matches("^[가-힣]*$")) {
            throw new IllegalArgumentException("A name should be Korean");
        }
    }

    private void validateLength(String name) {
        if (name.length() == 0 || name.length() > 19) {
            throw new IllegalArgumentException("A name length must be between 1 and 19");
        }
    }

}

class Email {
    private String email;

    public Email(String email) {
        validateLength(email);
        validateDomain(email);
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    private void validateLength(String email) {
        if (email.length() < 11 || email.length() > 19) {
            throw new IllegalArgumentException("email length must be between 11 and 19");
        }
    }

    private void validateDomain(String email) {
        if (!email.split("@")[1].equals("email.com")) {
            throw new IllegalArgumentException("An allowable email domain is only \"@email.com\"");
        }
    }
}

class Crew {
    private Name name;
    private Email email;

    public Crew(List<String> form) {
        validateSize(form);
        this.name = new Name(form.get(1));
        this.email = new Email(form.get(0));
    }

    public String getName() {
        return this.name.getName();
    }

    public String getEmail() {
        return this.email.getEmail();
    }

    private void validateSize(List<String> form) {
        if (form.size() != 2) {
            throw new IllegalArgumentException("form should be of 2 Strings(email, name)");
        }
    }
}

class TwoCharOfNameTable {
    private Hashtable<String, ArrayList<Crew>> crewTable;

    public TwoCharOfNameTable() {
        crewTable = new Hashtable<>();
    }

    public void put(Crew crew) {
        /* 닉네임에서 2글자씩 분절한 key와 crew 객체를  duplicateCrewTable에 추가 */
        String name = crew.getName();
        for (int i = 0; i < name.length() - 1; i++) {
            String key = name.substring(i, i + 2);
            ArrayList<Crew> crewList = get(key);
            crewList.add(crew);
            this.crewTable.put(key, crewList);
        }
    }

    public List<String> getEmailsOfDuplicateNames() {
        /* 중복된 닉네임을 가진 크루들의 이메일 리스트 반환 */
        List<Crew> crewsWithDuplicateNames = getCrewsWithDuplicateNames();
        if (crewsWithDuplicateNames.size() == 0) {  // 중복 닉네임이 없는 경우 빈 리스트 return
            return Collections.emptyList();
        }

        List<String> emails = crewsWithDuplicateNames.stream()
                .map(c -> c.getEmail())
                .collect(Collectors.toList());

        return sortLikeTreeSet(emails); //email 중복 제거 & 오름차순 정렬
    }

    private List<String> sortLikeTreeSet(List<String> strings) {
        TreeSet<String> distinceAnswer = new TreeSet<>(strings);
        strings = new ArrayList(distinceAnswer);
        return strings;
    }

    private List<Crew> getCrewsWithDuplicateNames() {
        return this.crewTable.values()
                .stream()
                .filter(intList -> intList.size() > 1)
                .findFirst()
                .orElse(new ArrayList<>());
    }

    private ArrayList<Crew> get(String key) {
        if (this.crewTable.containsKey(key)) {
            return this.crewTable.get(key);
        }
        return new ArrayList<>();
    }
}

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        TwoCharOfNameTable crewTable = new TwoCharOfNameTable();
        for (List<String> form : forms) {
            crewTable.put(new Crew(form));
        }
        return crewTable.getEmailsOfDuplicateNames();
    }
}