package library.authentication.message.request;

import lombok.Data;

@Data
public class LoginDTO {

    private String username;
    private String password;
}
