package com.revature.assignforce.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.revature.assignforce.beans.Location;

@FeignClient(name = "location-service/location/", fallback = LocationClientFallback.class)
public interface LocationClient {

	@GetMapping("/{id}")
	public Location getLocation(int id);
}
