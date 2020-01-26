package net.class101.server1.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import net.class101.server1.entity.UserKlass;

public class UserKlassRepository {

	private List<UserKlass> userKlasses = new ArrayList<>();

	private UserKlassRepository(){}
	
	private static class SingleTonHolder{
        private static final UserKlassRepository instance = new UserKlassRepository();
    }
     
    public static UserKlassRepository getInstance(){
        return SingleTonHolder.instance;
    }

	public void save(UserKlass userKlass) {
		userKlasses.add(userKlass);
	}

	public List<UserKlass> findAll() {
		return userKlasses;
	}

	public List<UserKlass> findBySn(Set<Long> productsSn) {
		return userKlasses.stream()
				.filter(k -> productsSn.contains(k.getProduct().getSn()))
				.collect(Collectors.toList());
	}
    
}
