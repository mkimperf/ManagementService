package com.perficient.managementservice.ManagementService;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class UserBean {

		private String firstName;

        public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getEmailAddress() {
			return emailAddress;
		}

		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}

		public String getPhoneNumbers() {
			return phoneNumbers;
		}

		public void setPhoneNumbers(String phoneNumbers) {
			this.phoneNumbers = phoneNumbers;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

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
