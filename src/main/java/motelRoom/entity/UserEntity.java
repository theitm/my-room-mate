package motelRoom.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "table_user")
public class UserEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "user_id", columnDefinition = "VARCHAR(40)")
    @Type(type = "uuid-char")
    private UUID user_id;

    @Column(name = "username")
    private String username;

    @Column(name = "passwords")
    private String passwords;

    @Column(name = "roles")
    private String roles;

    @Column(name = "full_name")
    private String full_name;

    @Column(name = "birth_date")
    private Date birth_date;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "gender")
    private int gender;

    @Column(name = "fb")
    private String fb;

    @Column(name = "url_avatar")
    private String url_avatar;


}
