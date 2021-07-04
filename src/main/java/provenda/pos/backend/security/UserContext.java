package provenda.pos.backend.security;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserContext {

private String userName;

private String applicationName;

private String ipAddress;

private Long id;

private String device;

private Long sucursalId;

}
