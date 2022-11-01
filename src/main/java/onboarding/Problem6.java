package onboarding;

import java.util.*;

class Crew {
    private String email;
    private String nickname;
    private boolean isDuplicate;
    private Set<String> tokens;     // 크루 개인의 중복 토큰

    public Crew(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
        isDuplicate = false;
        this.tokens = makeTokens(this.nickname);
    }

    private Set<String> makeTokens(String nickname) {
        Set<String> tokens = new HashSet<>();

        for (int i = 0; i < nickname.length() - 1; i++) {
            String token = nickname.substring(i, i+2);
            tokens.add(token);
        }
        return tokens;
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

    public boolean isDuplicate(String token) {
        if(this.nickname.contains(token))
            return true;
        return false;
    }
}

public class Problem6 {

    static private List<Crew> crews = new ArrayList<>();
    static private Map<String, Set<String>> totalTokens = new HashMap<>(); // 모든 크루의 중복 토큰 저장
    static private List<String> answer = new ArrayList<>();

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

    // 모든 크루를 비교하며 미리 만들어놓은 토큰을 이용하여 중복인지 체크
    public static void checkDuplicate() {
        for (Crew crew : crews) {
            for (String nickname : totalTokens.keySet()) {
                if (crew.getNickname() != nickname) { // 다른 크루의 토큰과 비교하기 위함
                    Set<String> tokensOfOtherCrew = totalTokens.get(nickname); // 다른 크루의 토큰
                    Iterator<String> it = tokensOfOtherCrew.iterator();

                    while (it.hasNext()) {
                        if (crew.isDuplicate(it.next()) && !crew.getIsDuplicate()) { // 중복이면서 중복처리가 안된 상태라면
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


