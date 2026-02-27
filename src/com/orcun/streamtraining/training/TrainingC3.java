package com.orcun.streamtraining.training;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.orcun.streamtraining.domain.User;
import com.orcun.streamtraining.util.StreamConstans.Language;

/*
 * Get (distinct) list of languages  known by the users
 */
public class TrainingC3 {
	//With for
	public List<Language> getLanguagesKnownV1(List<User> userList) {
		Map<Language,Boolean> languageMap = new HashMap<>();
		for(User user:userList) {
			List<Language> languages = user.getLanguages();
			for(Language language:languages) {
				if(!languageMap.containsKey(language)) {
					languageMap.put(language, true);
				}
			}
		}
		return new ArrayList<>(languageMap.keySet());
	}
	

}
