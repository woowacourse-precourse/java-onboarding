package onboarding.problem7;

public class Assembler {
	private static RecommendController recommendController;

	public void createAndWire() {
		ScoreCalculator scoreCalculator = new ScoreCalculatorImp();
		RankingGetter rankingGetter = new RankingGetterImp();
		recommendController = new RecommendController(scoreCalculator, rankingGetter);
	}

	public RecommendController getRecommendController() {
		return recommendController;
	}
}
