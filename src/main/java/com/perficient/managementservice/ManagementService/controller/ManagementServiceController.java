package com.perficient.managementservice.ManagementService.controller;

import com.perficient.managementservice.ManagementService.entity.AppointmentBean;
import com.perficient.managementservice.ManagementService.Configuration;
import com.perficient.managementservice.ManagementService.entity.UserBean;
import com.perficient.managementservice.ManagementService.exception.AppointmentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URISyntaxException;
import java.util.List;

@RequestMapping("/api/v1")
@RestController
public class ManagementServiceController {

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private Configuration config = new Configuration();

    @GetMapping("/user/{id}")
    public ResponseEntity<UserBean> getUser(@PathVariable int id) {
        try {
            UserBean user = restTemplate.getForObject(config.getUserservice() + "/user/{id}", UserBean.class, id);
            return ResponseEntity.ok(user);
        } catch (AppointmentNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable int id) {
        try{
            restTemplate.delete(config.getUserservice() + "/user/{id}", id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("User with id " + id + " was deleted successfully.");
        }catch(AppointmentNotFoundException e)
        {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping("/user")
    public ResponseEntity<?> createUser(@RequestBody UserBean user) {
        try{
            UserBean bean = restTemplate.postForObject(config.getUserservice() + "/user", user, UserBean.class);
            return ResponseEntity.status(HttpStatus.CREATED).body(bean);
        }catch (AppointmentNotFoundException e)
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("User ID is not correct");
        }

    }

    @PutMapping("/user/{id}")
    public ResponseEntity<UserBean> updateUser(@PathVariable int id, @RequestBody UserBean user) throws URISyntaxException {
    	String url = config.getUserservice() + "/user/" + id;

        HttpEntity<UserBean> request = new HttpEntity<>(user);

        try{
            ResponseEntity<UserBean> response = restTemplate.exchange(url, HttpMethod.PUT, request, UserBean.class);
            return ResponseEntity.ok(response.getBody());
        }catch (HttpClientErrorException.NotFound ex)
        {
            return ResponseEntity.notFound().build();
        }
    }
    
    @GetMapping("/users")
    public ResponseEntity<List<UserBean>> getUsers() {
        try{
            List<UserBean> user = restTemplate.getForObject(config.getUserservice() + "/users", List.class);
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }catch (AppointmentNotFoundException exception)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @GetMapping("/appointments")
    public ResponseEntity<List<AppointmentBean>> getAppointments() {
        try {
            List<AppointmentBean> appointment = restTemplate.getForObject(config.getAppointmentservice() + "/appointments", List.class);
            return ResponseEntity.status(HttpStatus.OK).body(appointment);
        } catch (AppointmentNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }
    //works
    @GetMapping("/appointments/{id}")
    public ResponseEntity<AppointmentBean> getAppintment(@PathVariable int id) {
        try {
            AppointmentBean appointment = restTemplate.getForObject(config.getAppointmentservice() + "/appointments/{aptId}", AppointmentBean.class, id);
            return ResponseEntity.status(HttpStatus.OK).body(appointment);
        }catch (AppointmentNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @DeleteMapping("/appointments/{aptId}")
    public ResponseEntity<String> deleteAppointment(@PathVariable int aptId) {
        try{
            restTemplate.delete(config.getAppointmentservice() + "/appointments/{aptId}", aptId);
            return ResponseEntity.status(HttpStatus.OK).body("Appointment with ID:" + aptId + " was deleted successfully.");
        }catch (AppointmentNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }

    }
    @PostMapping("/appointments")
    public ResponseEntity<AppointmentBean> createAppointment(@RequestBody AppointmentBean user) {
        try{
            AppointmentBean appointment=  restTemplate.postForObject(config.getAppointmentservice() + "/appointments", user, AppointmentBean.class);
            return ResponseEntity.status(HttpStatus.CREATED).body(appointment);
        }catch (AppointmentNotFoundException e)
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

    }

    @PutMapping("/appointments/{aptId}")
    public ResponseEntity<AppointmentBean> updateAppointment(@PathVariable int aptId, @RequestBody AppointmentBean appt) throws URISyntaxException {
        String url = config.getAppointmentservice() + "/appointments/" + aptId;

        HttpEntity<AppointmentBean> request = new HttpEntity<>(appt);

        try{
            ResponseEntity<AppointmentBean> response = restTemplate.exchange(url, HttpMethod.PUT, request, AppointmentBean.class);
            return ResponseEntity.ok(response.getBody());
        }catch (HttpClientErrorException.NotFound ex)
        {
            return ResponseEntity.notFound().build();
        }
    }

}
