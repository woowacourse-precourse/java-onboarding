package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.Crew;
import domain.CrewFormValidator;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
    	List<String> answer = new ArrayList<>();
        CrewFormValidator validator = new CrewFormValidator(getCrewList(forms));
    	for (Crew crew : validator.getInvalidCrews()) {
    		answer.add(crew.getEmail());
    	}
        Collections.sort(answer);
        return answer;
    }

    /**
     * 신청목록(forms)을 신청한 크루 정보를 표현하는 vo객체에 대한 리스트로 바꾸어 반환한다.
     * @param forms
     * @return Crew 타입의 ArrayList
     */
    private static List<Crew> getCrewList(List<List<String>> forms) {
    	List<Crew> crews = new ArrayList<>();
        for (List<String> form : forms) {
        	crews.add(new Crew(form.get(0), form.get(1)));
        }
        return crews;
    }
}
