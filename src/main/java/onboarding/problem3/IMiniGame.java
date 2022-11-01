package onboarding.problem3;

public interface IMiniGame<T extends IMiniGameData> {

	T run(T data);
}
