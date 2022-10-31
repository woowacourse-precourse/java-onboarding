package onboarding;

import java.util.*;


public class Problem6 {
    private static final String[] emailDomains = {"email.com"};
    private static final List<List<String>> badForms = new ArrayList<>();

    /**
     * <div> 신청받은 닉네임 중 <b>같은 글자가 연속적으로 포함 되는 닉네임</b>을 작성한 지원자의 이메일 목록을
     * 리턴합니다. </div>
     *
     * <br>
     * 세부 기능 목록 :
     *
     *  <ol>
     *      <li>중복되는 단어 자료구조(해시)에 저장</li>
     *      <li>저장된 자료구조에 중복 유저를 찾는 메서드</li>
     *      <li>form의 유효성 검사</li>
     *  </ol>
     *
     *
     * @param forms 크루의 정보 [이메일, 닉네임]의 리스트
     * @return 같은 글자가 연속적으로 포함되는 닉네임을 작성한 지원자의 이메일 {@code List}
     *
     */
    public static List<String> solution(List<List<String>> forms) {
        if(!validation("crew_limit", forms.size())) return new ArrayList<>();

        List<String> answer = new ArrayList<>(findOverlapUsers(getHash(forms)));
        answer.sort(Comparator.naturalOrder());
        return answer;
    }

    private static HashSet<String> findOverlapUsers(HashMap<String, ? extends List<String>> hash) {
        HashSet<String> set = new HashSet<>();
        hash.forEach((key, emails) -> {
            if(emails.size() > 1) emails.forEach(set::add);
        });
        return set;
    }

    private static HashMap<String, ? extends List<String>> getHash(List<List<String>> forms) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        for(List<String> form : forms) {
            String nickName = form.get(1);
            String email = form.get(0);

            if(!(validation("email", email)) || !(validation("nick_name", nickName))) {
                badForms.add(form);
                continue;
            }

            if(nickName.length() < 2) {
                ArrayList<String> emails = map.getOrDefault(nickName, new ArrayList<>());
                emails.add(email);
                map.put(nickName, emails);
                continue;
            }

            for(int i = 1; i < nickName.length(); i++) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(nickName.charAt(i - 1));
                stringBuilder.append(nickName.charAt(i));

                String key = stringBuilder.toString();

                ArrayList<String> emails = map.getOrDefault(key, new ArrayList<>());
                emails.add(email);
                map.put(key, emails);
            }
        }
        return map;
    }

    private static boolean validation(String type, Object target){
        switch (type) {
            case "crew_limit":
                int crewNumber = ((Number)target).intValue();
                if(!(0 < crewNumber && crewNumber < 10001)) return false;
                break;

            case "nick_name":
                int nameLength = ((String)target).length();
                if(!(0 < nameLength && nameLength < 20)) return false;
                if(!((String)target).matches("^[가-힣]*$")) return false;
                break;

            case "email":
                int mailLength = ((String)target).length();
                if(!(10 < mailLength && mailLength < 20)) return false;
                if(!domainCheck((String)target)) return false;
                break;

            default:
                return false;
        }
        return true;
    }

    private static boolean domainCheck(String email) {
        for (String domain : emailDomains) {
            if(!(email.matches("[a-z0-9]+@" + domain))) return false;
        }
        return true;
    }
}
