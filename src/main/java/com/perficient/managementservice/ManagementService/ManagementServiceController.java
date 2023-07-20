package com.perficient.managementservice.ManagementService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class ManagementServiceController {

    private RestTemplate restTemplate = new RestTemplate();
    
    @Autowired
    private Configuration config = new Configuration();

    @GetMapping("/user/{id}")
    public UserBean getUser(@PathVariable int id) {
    	return restTemplate.getForObject(config.getUserservice() + "/user/{id}", UserBean.class,id);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id) {
        restTemplate.delete(config.getUserservice() + "/user/{id}", id);
    }

    @PostMapping("/user")
    public UserBean createUser(@RequestBody UserBean user) {
        return restTemplate.postForObject(config.getUserservice() + "/user", user, UserBean.class);
    }

    @PutMapping("/user/{id}")
    public UserBean updateUser(@PathVariable int id, @RequestBody UserBean user) throws URISyntaxException {
    	String url = config.getUserservice() + "/user/" + id;

        HttpEntity<UserBean> request = new HttpEntity<>(user);

        ResponseEntity<UserBean> response = restTemplate.exchange(url, HttpMethod.PUT, request, UserBean.class);

        return response.getBody();
    }
    
    @GetMapping("/users")
    public List<UserBean> getUsers() {
        return restTemplate.getForObject(config.getUserservice() + "/users", List.class);
    }
    //works
    @GetMapping("/appointments")
    public List<AppointmentBean> getAppointments() {
        return restTemplate.getForObject(config.getAppointmentservice() + "/appointments", List.class);
    }
    //works
    @GetMapping("/appointments/{id}")
    public AppointmentBean getAppintment(@PathVariable int id) {
        return restTemplate.getForObject(config.getAppointmentservice() + "/appointments/{aptId}", AppointmentBean.class, id);
    }
    //error
    @DeleteMapping("/appointments/{aptId}")
    public void deleteAppointment(@PathVariable int aptId) {
        restTemplate.delete(config.getAppointmentservice() + "/appointments/{aptId}", aptId);
    }
    //error
    @PostMapping("/appointments")
    public AppointmentBean createAppointment(@RequestBody AppointmentBean user) {
        return restTemplate.postForObject(config.getAppointmentservice() + "/appointments", user, AppointmentBean.class);
    }

    @PutMapping("/appointments/{aptId}")
    public AppointmentBean updateAppointment(@PathVariable int aptId, @RequestBody AppointmentBean appt) throws URISyntaxException {
        String url = config.getAppointmentservice() + "/appointments/" + aptId;

        HttpEntity<AppointmentBean> request = new HttpEntity<>(appt);

        ResponseEntity<AppointmentBean> response = restTemplate.exchange(url, HttpMethod.PUT, request, AppointmentBean.class);

        return response.getBody();
    }

}
