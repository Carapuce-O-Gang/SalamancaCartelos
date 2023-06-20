package carapuceogang.salamancacartelos.authservice.dtos;

public class SignInDto {
    private String username;
    private String password;

    public SignInDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
