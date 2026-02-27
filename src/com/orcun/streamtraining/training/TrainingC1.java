package com.orcun.streamtraining.training;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.orcun.streamtraining.domain.User;
import com.orcun.streamtraining.util.StreamConstans.Title;

/*
 * Count every employees of every title
 */
public class TrainingC1 {
	//With for
	public Map<Title,Long> countEmployeesOfTitlesV1(List<User> userList) {
		Map<Title,Long> userMap = new HashMap<>();
		for(User user:userList) {
			Title title = user.getTitle();
			if(userMap.containsKey(title)) {
				long count = userMap.get(title);
				userMap.put(title, ++count);
			}
			else {
				userMap.put(title, 1l);
			}
		}
		return userMap;
	}
	

}
