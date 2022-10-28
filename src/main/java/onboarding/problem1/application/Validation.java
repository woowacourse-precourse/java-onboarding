package onboarding.problem1.application;

import java.util.List;

public interface Validation {

	boolean validate(List<Integer> infos) throws RuntimeException;
}
