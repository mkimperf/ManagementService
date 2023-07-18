package com.perficient.managementservice.ManagementService;

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

    @GetMapping("/user/{id}")
    public UserBean getUser(@PathVariable int id) {
    	return restTemplate.getForObject("http://localhost:8200/api/v1/user/{id}", UserBean.class,id);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id) {
        restTemplate.delete("http://localhost:8200/api/v1/user/{id}", id);
    }

    @PostMapping("/user")
    public UserBean createUser(@RequestBody UserBean user) {
        return restTemplate.postForObject("http://localhost:8200/api/v1/user", user, UserBean.class);
    }

    @PutMapping("/user/{id}")
    public UserBean updateUser(@PathVariable int id, @RequestBody UserBean user) throws URISyntaxException {
        URI uri = new URI("http://localhost:8200/user/"+id);

        // Create a HttpEntity object for the updated user
        HttpEntity<UserBean> request = new HttpEntity<>(user);

        // Make the exchange request
        ResponseEntity<UserBean> response = restTemplate.exchange(uri, HttpMethod.PUT, request, UserBean.class);

        // Get the updated user from the response
        return response.getBody();
    }
    
    @GetMapping("/users")
    public List<UserBean> getUsers() {
        return restTemplate.getForObject("http://localhost:8200/api/v1/users", List.class);
    }

    @GetMapping("/appointments")
    public List<AppointmentBean> getAppointments() {
        return restTemplate.getForObject("http://localhost:8100/api/v1/users", List.class);
    }
    
    @GetMapping("/appointments/{id}")
    public AppointmentBean getAppintment(@PathVariable int id) {
        return restTemplate.getForObject("http://localhost:8100/api/v1/user/{id}", AppointmentBean.class, id);
    }

    @DeleteMapping("/appointments/{id}")
    public void deleteAppointment(@PathVariable int id) {
        restTemplate.delete("http://localhost:8100/api/v1/user/{id}", id);
    }

    @PostMapping("/appointments")
    public AppointmentBean createAppointment(@RequestBody AppointmentBean user) {
        return restTemplate.postForObject("http://localhost:8200/api/v1/user", user, AppointmentBean.class);
    }

    @PutMapping("/appointment/{id}")
    public AppointmentBean updateAppointment(@PathVariable int id, @RequestBody AppointmentBean appt) throws URISyntaxException {
        URI uri = new URI("http://localhost:8200/user/"+id);

        // Create a HttpEntity object for the updated user
        HttpEntity<AppointmentBean> request = new HttpEntity<>(appt);

        // Make the exchange request
        ResponseEntity<AppointmentBean> response = restTemplate.exchange(uri, HttpMethod.PUT, request, AppointmentBean.class);

        // Get the updated user from the response
        return response.getBody();
    }

}
