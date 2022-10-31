package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem6 {

    private static void putListToCrews(List<List<String>> forms, List<Crew> crews) {
        for (List<String> strings : forms) {
            crews.add(new Crew(strings.get(0), strings.get(1)));
        }
    }

    private static void checkCrews(List<Crew> crews) {
        if (crews.size() > 10000 || crews.size() < 1)
            throw new IllegalArgumentException("크루는 1명 이상 10,000명 이하입니다.");
    }

    private static List<String> findDuplicate(List<Crew> crews) {
        return crews.stream()
                .filter(x -> checkNickNames(x, crews))
                .map(Crew::getEmail)
                .collect(Collectors.toList())
                .stream()
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    private static boolean checkNickNames(Crew crew, List<Crew> crews) {
        return crews.stream()
                .filter(x -> !x.equals(crew))
                .anyMatch(x -> crew.checkOverlap(x.getNickname()));
    }

    public static List<String> solution(List<List<String>> forms) {
        List<Crew> crews = new ArrayList<>();
        putListToCrews(forms, crews);
        checkCrews(crews);

        return findDuplicate(crews);
    }
}

class Crew {
    private final String email;
    private final String nickname;

    public Crew(String email, String nickname) {
        this.email = checkEmail(email);
        this.nickname = checkNickname(nickname);
    }

    private String checkEmail(String email) {
        if (!email.contains("@") || email.length() < 11 || email.length() >= 20) {
            throw new IllegalArgumentException("이메일 형식에 부합하지 않습니다.");
        }
        if (!email.split("@", 2)[1].equals("email.com")) {
            throw new IllegalArgumentException("이메일의 도메인이 email.com가 아닙니다.");
        }
        return email;
    }

    private String checkNickname(String nickname) {
        if (nickname.length() >= 20 || nickname.length() < 1)
            throw new IllegalArgumentException("닉네임의 길이는 1이상 20미만이어야합니다.");
        if (checkNicknameKorean(nickname))
            throw new IllegalArgumentException("닉네임은 모두 한국어로 이루어져야합니다.");
        return nickname;
    }

    private boolean checkNicknameKorean(String nickname) {
        return Stream.of(nickname.split(""))
                .map(x -> x.charAt(0))
                .anyMatch(x -> (Character.getType(x) != 5));
    }

    public boolean checkOverlap(String otherNickname) {
        return IntStream.range(0, otherNickname.length() - 1)
                .anyMatch(x -> nickname.contains(otherNickname.substring(x, x + 2)));
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }
}