package motelRoom.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    private UUID id;

    @Column(name = "username")
    private String username;

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
    private String facebook;

    @Column(name = "url_avatar")
    private String avatarUrl;

//    /**relationship one user many room **/
//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable=false, updatable=false)
//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    private List<RoomEntity> roomEntities = new ArrayList<>();

    /**relationship one user many waitinglist **/
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable=false, updatable=false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<WaitingListEntity> waitingListEntities = new ArrayList<>();

    /**relationship one user many evaluation **/
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable=false, updatable=false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<EvaluationEntity> evaluationEntities = new ArrayList<>();

    /**relationship one user many sharingdetail **/
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", insertable=false, updatable=false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<SharingDetailEntity> sharingDetailEntities = new ArrayList<>();
}



