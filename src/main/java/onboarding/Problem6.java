package onboarding;

import java.util.List;

import onboarding.problem6.Assembler;
import onboarding.problem6.CrewController;

public class Problem6 {
	public static List<String> solution(List<List<String>> forms) {
		Assembler assembler = new Assembler();
		assembler.createAndWire();
		final CrewController crewController = assembler.getCrewController();
		List<String> answer = crewController.process(forms);
		return answer;
	}
}
