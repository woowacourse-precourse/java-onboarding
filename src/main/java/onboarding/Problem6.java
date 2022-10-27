package onboarding;

import java.util.*;

class Crew {
    private String email;
    private String nickname;
    private boolean isDuplicate;
    private Set<String> tokens = new HashSet(); // 개인이 가지고 있는 tokens

    public Crew(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
        isDuplicate = false;
        makeTokens(this.nickname);
    }

    private void makeTokens(String nickname) {
        for (int i = 0; i < nickname.length() - 1; i++) {
            String token = nickname.substring(i, i+2);
            this.tokens.add(token);
        }
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public boolean getIsDuplicate() {
        return isDuplicate;
    }

    public Set<String> getTokens() {
        return tokens;
    }

    public void setIsDuplicateTrue() {
        this.isDuplicate = true;
    }
}

public class Problem6 {

    static List<Crew> crews = new ArrayList<>();
    static Map<String, Set<String>> totalTokens = new HashMap<>(); // 모든 crew의 토큰을 관리
    static List<String> answer = new ArrayList<>();

    public static List<String> solution(List<List<String>> forms) {
        initCrews(forms);
        putTokens();
        checkDuplicate();

        Collections.sort(answer);
        return answer;
    }

    public static void initCrews(List<List<String>> forms) {
        for (List<String> form : forms)
            crews.add(new Crew(form.get(0), form.get(1)));
    }

    public static void putTokens() {
        for (Crew crew : crews)
            totalTokens.put(crew.getNickname(), crew.getTokens());
    }

    public static void checkDuplicate() {
        for (Crew crew : crews) {
            for (String nickname : totalTokens.keySet()) {
                if (crew.getNickname() != nickname) { // 다른 crew의 토큰과 비교하기 위함
                    Set<String> tokensOfOtherCrew = totalTokens.get(nickname); // 다른 crew의 토큰
                    Iterator<String> it = tokensOfOtherCrew.iterator();

                    while (it.hasNext()) {
                        if (crew.getNickname().contains(it.next()) && !crew.getIsDuplicate()) {
                            answer.add(crew.getEmail());
                            crew.setIsDuplicateTrue();
                            break;
                        }
                    }
                }
            }
        }
    }
}


