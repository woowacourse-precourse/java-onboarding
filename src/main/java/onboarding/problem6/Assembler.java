package onboarding.problem6;

public class Assembler {
	private static CrewController crewController;

	public void createAndWire() {
		DuplicationChecker duplicationChecker = new DuplicationCheckerImp();
		ResultStyleFormatter resultStyleFormatter = new EmailSorter();
		crewController = new CrewController(duplicationChecker, resultStyleFormatter);
	}

	public CrewController getCrewController() {
		return crewController;
	}
}
