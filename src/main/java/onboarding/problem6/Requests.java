package onboarding.problem6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Requests {

	private final List<Request> requests;

	public Requests(List<List<String>> forms) {
		List<Request> requests = new ArrayList<>();
		for (List<String> form : forms) {
			String email = form.get(0);
			String nickname = form.get(1);
			requests.add(new Request(email, nickname));
		}
		this.requests = requests;
	}

	public Collection<String> getEmailsOfOverlappedCrews() {
		Set<String> emailsOfOverlappedCrews = new TreeSet<>();
		for (Request request : requests) {
			emailsOfOverlappedCrews.addAll(findEmailsOfOverlappedCrewsBy(request));
		}
		return emailsOfOverlappedCrews;
	}

	private List<String> findEmailsOfOverlappedCrewsBy(Request request) {
		List<String> emailsOfOverlappedCrews = new ArrayList<>();
		for (Request otherRequest : requests) {
			if (request.equals(otherRequest)) {
				continue;
			}
			if (request.hasOverlapWith(otherRequest)) {
				emailsOfOverlappedCrews.add(request.getEmail());
				emailsOfOverlappedCrews.add(otherRequest.getEmail());
			}
		}
		return emailsOfOverlappedCrews;
	}
}
