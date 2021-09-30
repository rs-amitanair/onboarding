package com.randstad.dto;

public class EmployeeDto {
    /**
     * employee id
     */
    private int id;

    /**
     * employee id
     */
    private String email;

    /**
     * employee password
     */
    private String password;

    /**
     * employee first name
     */
    private String firstName;

    /**
     * employee last name
     */
    private String lastName;

    /**
     * employee address
     */
    private String address;

    /**
     * employee city
     */
    private String city;

    /**
     * employee state
     */
    private String state;

    /**
     * employee country
     */
    private String country;

    /**
     *  gets the id
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * sets the id
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * gets the first name
     *
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * sets the first name
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * gets the last name
     *
     * @return lastname
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * sets the last name
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * gets the address
     *
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * sets the address
     *
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * gets the city
     *
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * sets the city
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * gets the state
     *
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * sets the state
     *
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * gets the country
     *
     * @return
     */
    public String getCountry() {
        return country;
    }

    /**
     * sets the country
     *
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * gets the employee email
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * sets the email
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * gets the password
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * sets the password
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
