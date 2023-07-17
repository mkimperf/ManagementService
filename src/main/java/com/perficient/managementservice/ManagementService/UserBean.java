package com.perficient.managementservice.ManagementService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class UserBean {

		private String firstName;

        private String lastName;

        private String gender;

        private String emailAddress;

        private String phoneNumbers;

        private Integer age;
        
        public UserBean(String firstName, String lastName, String gender, String emailAddress, String phoneNumbers,
    			Integer age) {
    		super();
    		this.firstName = firstName;
    		this.lastName = lastName;
    		this.gender = gender;
    		this.emailAddress = emailAddress;
    		this.phoneNumbers = phoneNumbers;
    		this.age = age;
    	}

}
