package toy.toyproject1.domain.entity.member;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginDto {
    @NotBlank
    private String userid;
    @NotBlank
    private String pw;
}
