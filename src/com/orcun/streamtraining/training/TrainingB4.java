package com.orcun.streamtraining.training;

import java.util.ArrayList;
import java.util.List;

import com.orcun.streamtraining.domain.User;
import com.orcun.streamtraining.util.StreamConstans.Language;
import com.orcun.streamtraining.util.StreamConstans.Title;

/*
 * Get all users name who are software engineers
 */
public class TrainingB4 {
	//With for
	public List<String> getSoftwareEngineersNameV1(List<User> userList) {
		List<String> names = new ArrayList<>();
		for(User user:userList) {
			if(user.getTitle().equals(Title.SOFTWARE_ENGINEER))
				names.add(user.getName());
		}
		return names;
	}

	//TODO: Получить имена всех software engineers (используйте filter по Title + map для getName + collect(toList))
	public List<String> getSoftwareEngineersNameV2(List<User> userList) {
		return new ArrayList<>(); // Replace with your stream implementation
	}

	public static void main(String[] args) {
		List<User> userList = createTestData();
		TrainingB4 training = new TrainingB4();
		
		List<String> expected = training.getSoftwareEngineersNameV1(userList);
		List<String> actual = training.getSoftwareEngineersNameV2(userList);
		
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
