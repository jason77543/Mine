package com.activity.model;

import java.util.List;



public interface ActivityDAO_Interface {
	void add(Activity activity);
	void update(Activity activity);
	void delete(Integer actNo);
	Activity findByPK(Integer actNo);
	Activity findByPKStatus(Integer actNo,Integer actStatus);
	List<Activity> getAll();
	List<Activity> getAllById(String restMemId);
	List<Activity> getAllByStatus(Integer actStatus);
	
}
