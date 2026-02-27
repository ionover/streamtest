package com.orcun.streamtraining.training;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.orcun.streamtraining.domain.User;
import com.orcun.streamtraining.util.StreamConstans.Title;

/*
 * Group software engineers with vegetarian and non vegetarian
 */
public class TrainingB9 {
	//With for
	public Map<Boolean,List<User>> groupEngineersByIsVegetarianV1(List<User> userList) {
		Map<Boolean,List<User>> userMap = new HashMap<>();
		for(User user:userList) {
			if(!user.getTitle().equals(Title.SOFTWARE_ENGINEER))
				continue;
			if(userMap.containsKey(user.isVegetarian())) {
				userMap.get(user.isVegetarian()).add(user);
			}
			else {
				List<User> list = new ArrayList<>();
				list.add(user);
				userMap.put(user.isVegetarian(), list);
			}
		}
		return userMap;
	}
	

}
