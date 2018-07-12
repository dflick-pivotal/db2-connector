package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.servicebroker.model.CreateServiceInstanceAppBindingResponse;
import org.springframework.cloud.servicebroker.model.CreateServiceInstanceBindingRequest;
import org.springframework.cloud.servicebroker.model.CreateServiceInstanceBindingResponse;
import org.springframework.cloud.servicebroker.model.DeleteServiceInstanceBindingRequest;
import org.springframework.cloud.servicebroker.service.ServiceInstanceBindingService;
import org.springframework.stereotype.Service;

@Service
public class Db2ServiceInstanceBindingService implements ServiceInstanceBindingService {

    @Value("${location_x_db_info}")
    private String location_x_db_info;
    @Value("${location_y_db_info}")
    private String location_y_db_info;
    @Value("${location_z_db_info}")
    private String location_z_db_info;

	@Override
	public CreateServiceInstanceBindingResponse createServiceInstanceBinding(
			CreateServiceInstanceBindingRequest request) {
			
	Map<String,Object> credentials = new HashMap<String,Object>();
	if(request.getPlanId().contentEquals("location-x"))
		credentials.put("jdbcUrl", location_x_db_info);
	if(request.getPlanId().contentEquals("location-y"))
		credentials.put("jdbcUrl", location_y_db_info);
	if(request.getPlanId().contentEquals("location-z"))
		credentials.put("jdbcUrl", location_z_db_info);
    
	return new CreateServiceInstanceAppBindingResponse().withCredentials(credentials);		
	}

	@Override
	public void deleteServiceInstanceBinding(DeleteServiceInstanceBindingRequest request) {
		// TODO Auto-generated method stub
		
	}

}
