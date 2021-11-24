package co.edu.unbosque.services.pojo;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserAppPOJO {

    private String userName;
    private String passWord;
    private String email;
    private String role;
    private OfficialPOJO usernameOff;
    private OwnerPOJO usernameOw;
    private VetPOJO usernameVet;

    public UserAppPOJO(){}

    public UserAppPOJO(String username, String passWord, String email, String role){
        this.userName = username;
        this.passWord = passWord;
        this.email = email;
        this.role = role;
    }

    public UserAppPOJO(String username, String passWord, String email, String role, OfficialPOJO usernameOff){
        this.userName = username;
        this.passWord = passWord;
        this.email = email;
        this.role = role;
        this.usernameOff = usernameOff;
    }

    public UserAppPOJO(String username, String passWord, String email, String role, OwnerPOJO usernameOw){
        this.userName = username;
        this.passWord = passWord;
        this.email = email;
        this.role = role;
        this.usernameOw = usernameOw;
    }

    public UserAppPOJO(String username, String passWord, String email, String role, VetPOJO usernameVet){
        this.userName = username;
        this.passWord = passWord;
        this.email = email;
        this.role = role;
        this.usernameVet = usernameVet;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public OfficialPOJO getUsernameOff() {
        return usernameOff;
    }

    public void setUsernameOff(OfficialPOJO usernameOff) {
        this.usernameOff = usernameOff;
    }

    public OwnerPOJO getUsernameOw() {
        return usernameOw;
    }

    public void setUsernameOw(OwnerPOJO usernameOw) {
        this.usernameOw = usernameOw;
    }

    public VetPOJO getUsernameVet() {
        return usernameVet;
    }

    public void setUsernameVet(VetPOJO usernameVet) {
        this.usernameVet = usernameVet;
    }


}
