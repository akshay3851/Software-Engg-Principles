package com.akshay.solid.srp;

/**
 * The SingleResponsibilityPrinciple class demonstrates the Single Responsibility Principle (SRP) in software engineering.
 *
 * <p>
 * According to SRP, a class should have only one reason to change, meaning it should have only one job or responsibility.
 * This class separates the responsibilities of user data management and user authentication into distinct classes.
 * </p>
 *
 * <p>
 * This class is responsible for handling user data.
 * </p>
 *
 * @Author <a href ="https://www.linkedin.com/in/akshay3851/">Akshay Kumar</a>
 */
public class SingleResponsibilityPrinciple {

    private String userData;

    /**
     * Gets the user data.
     *
     * @return the user data as a String.
     */
    public String getUserData() {
        return userData;
    }

    /**
     * Sets the user data.
     *
     * @param userData the user data to set.
     */
    public void setUserData(String userData) {
        this.userData = userData;
    }

}
