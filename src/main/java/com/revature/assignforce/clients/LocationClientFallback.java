package com.revature.assignforce.clients;

import org.springframework.stereotype.Component;

import com.revature.assignforce.beans.Location;

@Component
public class LocationClientFallback implements LocationClient {

	@Override
	public Location getLocation(int id) {
		return new Location();
	}

}
