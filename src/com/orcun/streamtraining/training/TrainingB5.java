package com.orcun.streamtraining.training;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.orcun.streamtraining.domain.User;
import com.orcun.streamtraining.util.StreamConstans.Language;
import com.orcun.streamtraining.util.StreamConstans.Title;

/*
 * Get two users who are vegetarian
 */
public class TrainingB5 {
	//With for
	public List<User> getTwoVegeterianUserV1(List<User> userList) {
		List<User> list = new ArrayList<>();
		for(User user:userList) {
			if(user.isVegetarian())
				list.add(user);
			if(list.size()==2)
				break;
		}
		return list;
	}

	//TODO: Получить первых двух вегетарианцев (используйте filter + limit(2) + collect(toList))
	public List<User> getTwoVegeterianUserV2(List<User> userList) {
		return new ArrayList<>(); // Replace with your stream implementation
	}

	public static void main(String[] args) {
		List<User> userList = createTestData();
		TrainingB5 training = new TrainingB5();
		
		List<User> expected = training.getTwoVegeterianUserV1(userList);
		List<User> actual = training.getTwoVegeterianUserV2(userList);
		
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
