package onboarding;

import java.util.*;

/**
 * <p>우아한테크코스에서는 교육생(이하 크루) 간 소통 시 닉네임을 사용한다. 간혹 비슷한 닉네임을 정하는 경우가 있는데, 이러할 경우 소통할 때 혼란을 불러일으킬 수 있다.
 * 혼란을 막기 위해 크루들의 닉네임 중 같은 글자가 연속적으로 포함 될 경우 해당 닉네임 사용을 제한하려 한다. 이를 위해 같은 글자가 연속적으로 포함되는 닉네임을 신청한 크루들에게 알려주는 시스템을 만들려고 한다.
 * 신청받은 닉네임 중 같은 글자가 연속적으로 포함 되는 닉네임을 작성한 지원자의 이메일 목록을 return 하도록 solution 메서드를 완성하라.
 * </p><br/>
 * 두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우 중복으로 간주한다.<p>
 * 크루는 1명 이상 10,000명 이하이다.<p>
 * 이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다.<p>
 * 신청할 수 있는 이메일은 email.com 도메인으로만 제한한다.<p>
 * 닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.<p>
 * result는 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬하고 중복은 제거한다.<p>
 */
public class Problem6 {
    /**
     * String, HashMap -> ArrayList
     * 문자열, 해시맵을 받아 리스트를 반환하는데,
     * 해시맵의 값 == 문자열 이라면
     * 해당 값을 리스트에 담아 반환한다.
     * */
    public static List<String> getRawAnswer(String str, Map<String, String> map){
        List<String> rawAnswer = new ArrayList<>();
        for (String key : map.keySet()) {
            String value = map.get(key);
            if (value.contains(str)) {
                rawAnswer.add(key);
            }
        }
        return rawAnswer;
    }


    /**
     * List<String> 형태의 리스트를 중복 제거하고, 문자열 정렬해주는 메소드
     */
    public static List<String> getRefinedAnswer(List<String> data) {
        // 먼저 중복을 제거하고,
        Set<String> set = new HashSet<>(data);
        // 다음 정렬을 해 준다.
        data = new ArrayList<>(set);
        Collections.sort(data);
        return data;
    }


    /**
     * forms 을 HashMap 으로 변환해 주는 메소드
     */
    public static Map<String, String> toMappedForms(List<List<String>> forms) {
        Map<String, String> mappedForms = new HashMap<>();
        for (List<String> item : forms) {
            mappedForms.put(item.get(0), item.get(1));
        }
        return mappedForms;
    }


    /**
     * 문자열을 나누어 리스트에 담는 메서드
     * 이름과 리스트를 받아서, 분리된 이름을 리스트에 담는다.
     * ex) "우테코", [] => ["우테", "테코"]
     */
    public static List<String> getDividedNameList(String name, List<String> dividedNameList) {
        if (name.length() <= 2) {
            dividedNameList.add(name);
        } else {
            for (int i = 0; i < name.length(); i++) {
                if (name.length() - 1 != i) {
                    dividedNameList.add(name.substring(i, i + 2));
                }
            }
        }
        return dividedNameList;
    }

    /**
     * 리스트에서 중복된 요소만 찾아내는 메서드
     * 요소들이 담겨있는 리스트와 중복되는 값들을 담을 리스트를 받아서,
     * 중복되는 값들이 있으면 그것을 중복되는 값들을 담을 리스트에 담는다.
     * ex) ["1", "1", "2", "3", "3", "4"], [] => ["1", "3"]
     */
    public static List<String> getOverlappedNameList(List<String> rawList) {
        List<String> container = new ArrayList<>();
        for (int i = 1; i < rawList.size(); i++) {
            if (Collections.frequency(rawList, rawList.get(i)) > 1) {
                container.add(rawList.get(i));
            }
        }
        return container;
    }


    public static List<String> solution(List<List<String>> forms) {
        Map<String, String> mappedForms = toMappedForms(forms);
        List<String> dividedNameList = new ArrayList<>();
        List<String> overlappedNameList = new ArrayList<>();

        // 리스트에 폼으로 제출받은 모든 이름을 나누어 담는다.
        for (int i = 1; i < forms.size(); i++) {
            dividedNameList = getDividedNameList(forms.get(i).get(1), dividedNameList);
        }

        // 리스트에 있는 나누어진 이름들 중, 중복되는 것들을 찾아 그것을 담는다.
        overlappedNameList = getOverlappedNameList(dividedNameList);

        // 정제되지 않은 상태의 답을 얻는다.
        List<String> rawAnswer = new ArrayList<>();

        // 중복된 것들이 담겨 있는 리스트에 대해서,
        for (String overlappedName : overlappedNameList) {
            // 입력받은 폼 데이터에서 그 중복된 것이 담겨있다면 이메일 값을 답에다 넣는다.
            rawAnswer = getRawAnswer(overlappedName, mappedForms);
        }

        // 중복이 제거되고, 정렬된 데이터를 최종 답으로 정제한다.
        List<String> answer = getRefinedAnswer(rawAnswer);

        return answer;
    }
}