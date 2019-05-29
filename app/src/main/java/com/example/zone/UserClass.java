package com.example.zone;

import java.util.List;

public class UserClass {

    private Firebase_Helper FirebaseHelper=new Firebase_Helper();
    private boolean result;

    //Data type for user
    private String UserId;
    private String FirstName;
    private String LastName;
    private String UserEmail;
    private String UserPassword;
    private String Location;
    private boolean Gender;
    private String RoleId;
    private String University;
    private String Collage;
    private String ProfilePictureId;
    private List<String> Interests;


    public UserClass() {

    }

    public UserClass(String userId, String firstName, String userPassword, String location, boolean gender, String roleId, String university, String collage, String profilePictureId) {
        UserId = userId;
        FirstName = firstName;
        UserPassword = userPassword;
        Location = location;
        Gender = gender;
        RoleId = roleId;
        University = university;
        Collage = collage;
        ProfilePictureId = profilePictureId;
    }



    public String getUserId() {
        return UserId;
    }

    public void setUserId(String userId) {
        UserId = userId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public boolean isGender() {
        return Gender;
    }

    public void setGender(boolean gender) {
        Gender = gender;
    }

    public String getRoleId() {
        return RoleId;
    }

    public void setRoleId(String roleId) {
        RoleId = roleId;
    }

    public String getUniversity() {
        return University;
    }

    public void setUniversity(String university) {
        University = university;
    }

    public String getCollage() {
        return Collage;
    }

    public void setCollage(String collage) {
        Collage = collage;
    }

    public String getProfilePictureId() {
        return ProfilePictureId;
    }

    public void setProfilePictureId(String profilePictureId) {
        ProfilePictureId = profilePictureId;
    }

    //create new user
    public boolean SignUpWithEmailAndPassword(String email, String password)
    {
        result = FirebaseHelper.SignUpWithEmailAndPassword(email,password);

        if (result){
            return false;
        }
        else {
            return true;
        }
    }

    //Sign In With Email And Password
    public boolean SignInWithEmailAndPassword(String email, String password){
        result = FirebaseHelper.signInWithEmailAndPassword(email, password);

        if (result){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean getCurrentUser(){
        if (FirebaseHelper.currentUser==null){
            result= false;
        }
        else {
            result = true;
        }
        return result;
    }
}
