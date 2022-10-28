package onboarding.problem1.application;

import java.util.List;

public interface Validation {

	boolean isValid(List<Integer> infos) throws RuntimeException;
}
