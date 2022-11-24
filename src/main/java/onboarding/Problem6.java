package onboarding;

import java.util.*;

public class Problem6 {

    private static final String domainFormat = ".*@email.com$";
    private static final Map<String, Integer> subNickNames = new HashMap<>();
    private static final Set<String> domainsWithDuplicatedNickName = new TreeSet<>();

    public static List<String> solution(List<List<String>> forms) {
        setSubNickNames(forms);
        Set<String> duplicatedSubNickNames = extractDuplicatedSubNickNames(subNickNames);
        subNickNames.clear(); //for returning the used up memory space

        forms.stream().
                filter(x -> hasImpossibleNickName(x.get(1), duplicatedSubNickNames)).
                forEach(x -> addDomainWithDuplicatedNickName(x.get(0)));

        return new ArrayList<>(domainsWithDuplicatedNickName);
    }

    /**
     * forms 의 올바른 도메인에 해당하는 모든 닉네임의 2글자를 추출,
     * Map에 해당 부분닉네임을 Key로, 부분닉네임이 사용된 횟수를 Value로 저장한다.
     * @param forms
     */
    private static void setSubNickNames(List<List<String>> forms) {
        forms.stream().filter(x -> isValidateDomain(x.get(0))).
                forEach(x -> {
                    Set<String> subNickNameSpace = createSubNickNameSpace(x.get(1));
                    addFromSetToMap(subNickNameSpace, subNickNames);
                });
    }

    /**
     * 도메인 형식이 @eamil.com을 갖는지에 대한 여부를 Boolean 타입 반환
     * @param userEmail
     * @return
     */
    private static boolean isValidateDomain(String userEmail) {
        return userEmail.matches(domainFormat);
    }

    /**
     * 닉네임의 두글자씩 추출하여 Set으로 반환
     * @param nickName
     * @return
     */
    private static Set<String> createSubNickNameSpace(String nickName) {
        Set<String> set = new HashSet<>();
        for (int i = 1; i < nickName.length(); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(nickName.charAt(i - 1)).append(nickName.charAt(i));
            set.add(stringBuilder.toString());
        }
        return set;
    }

    /**
     * Set에 포함된 모든 Elements를 Map의 키로, 중복 수를 값으로 저장
     * @param set
     * @param map
     */
    private static void addFromSetToMap (Set<String> set, Map<String, Integer> map) {
        set.forEach(x -> map.put(x, map.getOrDefault(x, 0)+1));
    }

    /**
     * Map에 저장된 부분닉네임 중, 중복수가 2이상인 key값들을 set으로 반환
     * @param map
     * @return
     */
    private static Set<String> extractDuplicatedSubNickNames(Map<String, Integer> map) {
        Set<String> set = new HashSet<>();
        map.keySet().stream().filter(x -> map.get(x) > 1).forEach(set::add);
        return set;
    }

    private static boolean hasImpossibleNickName(String nickName, Set<String> impossibleNameSpace) {
        Set<String> subNickNameSpace = createSubNickNameSpace(nickName);
        return subNickNameSpace.stream().anyMatch(impossibleNameSpace::contains);
    }

    private static void addDomainWithDuplicatedNickName(String email) {
        domainsWithDuplicatedNickName.add(email);
    }
}
