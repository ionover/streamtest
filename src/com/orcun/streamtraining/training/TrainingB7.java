package com.orcun.streamtraining.training;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.orcun.streamtraining.domain.User;
import com.orcun.streamtraining.util.StreamConstans.Language;
import com.orcun.streamtraining.util.StreamConstans.Title;

/*
 * Get distinct user names who earn more than x dolar
 */
public class TrainingB7 {
	//With for
	public Set<String> getDistinctUserNameWhoEarnsMoreV1(List<User> userList, double salary) {
		Map<String,Boolean> userNameMap = new HashMap<>();
		for(User user:userList) {
			if(user.getSalary()>salary)
				userNameMap.put(user.getName(), true);
		}
		return userNameMap.keySet();
	}

	//TODO: Получить уникальные имена пользователей с зарплатой больше заданной (используйте filter + map + collect(toSet))
	public Set<String> getDistinctUserNameWhoEarnsMoreV2(List<User> userList, double salary) {
		return new HashSet<>(); // Replace with your stream implementation
	}

	public static void main(String[] args) {
		List<User> userList = createTestData();
		TrainingB7 training = new TrainingB7();
		double testSalary = 5000;
		
		Set<String> expected = training.getDistinctUserNameWhoEarnsMoreV1(userList, testSalary);
		Set<String> actual = training.getDistinctUserNameWhoEarnsMoreV2(userList, testSalary);
		
		if (expected.equals(actual)) {
			System.out.println("✓ Test passed!");
			System.out.println("Result: " + actual);
		} else {
			System.out.println("✗ Test failed!");
			System.out.println("Expected: " + expected);
			System.out.println("Actual: " + actual);
		}
	}

	private static List<User> createTestData() {
		List<User> userList = new ArrayList<>();
		userList.add(new User("Jane", "Lawrence", 21, 5600, Title.SOFTWARE_ENGINEER, true, 2011, new Language[]{Language.ENGILISH, Language.GERMAN}));
		userList.add(new User("Kate", "Winston", 23, 6560, Title.ACCOUNTED, false, 2012, new Language[]{Language.ENGILISH, Language.TURKISH}));
		userList.add(new User("John", "Gordan", 25, 3500, Title.SECURTY, true, 2013, new Language[]{Language.ENGILISH}));
		userList.add(new User("Kate", "Marvel", 29, 8000, Title.POD_LEADER, false, 2011, new Language[]{Language.GERMAN}));
		userList.add(new User("Jane", "Marvel", 32, 8000, Title.PROJECT_LEADER, true, 2010, new Language[]{Language.TURKISH}));
		userList.add(new User("Visnu", "Sarej", 22, 4000, Title.SOFTWARE_ENGINEER, false, 2008, new Language[]{Language.GERMAN}));
		userList.add(new User("Mike", "Denis", 21, 3500, Title.SOFTWARE_ENGINEER, true, 2011, new Language[]{Language.ENGILISH}));
		userList.add(new User("Rajess", "Visnu", 22, 4000, Title.SOFTWARE_ENGINEER, true, 2009, new Language[]{Language.ENGILISH}));
		return userList;
	}
}
