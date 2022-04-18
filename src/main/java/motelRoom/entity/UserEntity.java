package motelRoom.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "table_user")
public class UserEntity {

    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "user_id", columnDefinition = "VARCHAR(40)")
    @Type(type = "uuid-char")
    @NotNull(message = "ID can't be null")
    private UUID id;

    @NotNull(message = "username can't be null")
    @Column( name = "username")
    private String username;

    @NotNull(message = "Password can't be null")
    @Column(name = "passwords")
    private String password;

    @Column(name = "roles")
    private String role;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "birth_date")
    private Date birthDate;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "gender")
    private int gender;

    @Column(name = "fb")
    private String fb;

    @Column(name = "url_avatar")
    private String urlAvatar;

}
