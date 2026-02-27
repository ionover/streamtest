package com.orcun.streamtraining.training;

import java.util.ArrayList;
import java.util.List;

import com.orcun.streamtraining.domain.User;
import com.orcun.streamtraining.util.StreamConstans.Language;
import com.orcun.streamtraining.util.StreamConstans.Title;

/*
 * Get any user who earns more than x dolar
 */
public class TrainingB6 {
	//With for
	public User getUsersWhoEarnsMoreV1(List<User> userList, double salary) {
		for(User user:userList) {
			if(user.getSalary()>salary)
				return user;
		}
		return null;
	}

	//TODO: Найти любого пользователя с зарплатой больше заданной (используйте filter + findFirst + orElse)
	public User getUsersWhoEarnsMoreV2(List<User> userList, double salary) {
		return null; // Replace with your stream implementation
	}

	public static void main(String[] args) {
		List<User> userList = createTestData();
		TrainingB6 training = new TrainingB6();
		double testSalary = 3000;
		
		User expected = training.getUsersWhoEarnsMoreV1(userList, testSalary);
		User actual = training.getUsersWhoEarnsMoreV2(userList, testSalary);
		
		if ((expected == null && actual == null) || (expected != null && expected.equals(actual))) {
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
