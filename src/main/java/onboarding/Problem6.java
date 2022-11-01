package onboarding;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import onboarding.problem6.Crew;
import onboarding.problem6.EmailValidator;
import onboarding.problem6.ICrewValidator;
import onboarding.problem6.NicknameFilter;
import onboarding.problem6.NicknameValidator;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<Crew> crewList = new LinkedList<>();

        for(List<String> i : forms){
            crewList.add(new Crew(i.get(0), i.get(1)));
        }

        List<ICrewValidator> validatorList = new LinkedList<>();
        validatorList.add(new EmailValidator());
        validatorList.add(new NicknameValidator());

        for(ICrewValidator i : validatorList){
            if(!i.isValid(crewList)){
                throw new IllegalArgumentException("유효하지 않은 파라미터");
            }
        }

        NicknameFilter nicknameFilter = new NicknameFilter();
        List<Crew> survivorList = nicknameFilter.doFilter(new LinkedList<>(crewList));
        crewList.removeAll(survivorList);

        return crewList.stream().map(Crew::getEmail)
            .sorted()
            .collect(Collectors.toList());
    }
}
