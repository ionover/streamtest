package com.orcun.streamtraining.training;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.orcun.streamtraining.domain.User;
import com.orcun.streamtraining.util.StreamConstans.Language;
import com.orcun.streamtraining.util.StreamConstans.Title;

/*
 * Find users who start in year x and sort them with salary (increasing order)
 */
public class TrainingB8 {
	//With for
	public List<User> getUserStartsInSpecificYearV1(List<User> userList, int year) {
		List<User> list = new ArrayList<>();
		for(User user:userList) {
			if(user.getStartYear()==year)
				list.add(user);
		}
		list.sort(new Comparator<User>(){
			@Override
			public int compare(User u1, User u2) 
		    {
				return (int)(u1.getSalary() - u2.getSalary()); 
		    }
		});
		return list;
	}

	//TODO: Найти пользователей начавших работу в заданный год и отсортировать по зарплате (используйте filter + sorted + collect(toList))
	public List<User> getUserStartsInSpecificYearV2(List<User> userList, int year) {
		return new ArrayList<>(); // Replace with your stream implementation
	}

	public static void main(String[] args) {
		List<User> userList = createTestData();
		TrainingB8 training = new TrainingB8();
		int testYear = 2011;
		
		List<User> expected = training.getUserStartsInSpecificYearV1(userList, testYear);
		List<User> actual = training.getUserStartsInSpecificYearV2(userList, testYear);
		
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
