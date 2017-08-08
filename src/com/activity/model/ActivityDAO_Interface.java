package com.activity.model;

import java.util.List;

import com.restMember.model.RestMember;

public interface ActivityDAO_Interface {
	void add(Activity activity);
	void update(Activity activity);
	void delete(Integer actNo);
	Activity findByPK(Integer actNo);
	List<Activity> getAll();
	List<Activity> getAllById(String restMemId);
	List<Activity> getAllByStatus(Integer actStatus);
}
