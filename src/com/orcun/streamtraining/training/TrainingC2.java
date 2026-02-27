package com.orcun.streamtraining.training;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.orcun.streamtraining.domain.User;
import com.orcun.streamtraining.util.StreamConstans.Title;

/*
 * Find max salary for every title
 */
public class TrainingC2 {
	//With for
	public Map<Title,Double> findMaxSalaryOfEveryTitleV1(List<User> userList) {
		Map<Title,Double> userMap = new HashMap<>();
		for(User user:userList) {
			Title title = user.getTitle();
			if(userMap.containsKey(title)) {
				double max = userMap.get(title);
				if(max<user.getSalary())
				userMap.put(title, user.getSalary());
			}
			else {
				userMap.put(title, user.getSalary());
			}
		}
		return userMap;
	}
	

}
