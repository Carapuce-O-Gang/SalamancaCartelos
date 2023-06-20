package carapuceogang.salamancacartelos.authservice.dtos;

public class SignUpDto {
    private String username;
    private String mail;
    private String password;

    public SignUpDto(String username, String mail, String password) {
        this.username = username;
        this.mail = mail;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }
}
