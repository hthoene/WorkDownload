package work.download.appuser;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import work.download.delivery.Delivery;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import work.download.passwordreset.PasswordResetToken;
import work.download.utils.GlobalConfig;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "AppUser")
@Table(name = "app_user")
@EqualsAndHashCode
public class AppUser implements UserDetails {

    @SequenceGenerator(
            name = "app_user_sequence",
            sequenceName = "app_user_sequence",
            allocationSize = 1
    )
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "app_user_sequence"
    )
    private Long id;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private AppUserRole appUserRole;

    @JsonIgnore
    private String profilePicturePath;

    private String companyName;
    private Boolean locked = false;
    private Boolean enabled = false;

    private Boolean verified = false;

    private LocalDateTime accountCreationDate = LocalDateTime.now();

    // 1 GB
    private Long storage = 1073741824L*3;

    @OneToOne(mappedBy = "appUser", orphanRemoval = true)
    private PasswordResetToken passwordResetToken;

    @JsonIgnore
    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER, orphanRemoval = true, cascade = {CascadeType.ALL})
    private List<Delivery> deliveries = new ArrayList<>();

    public AppUser(
                   String email,
                   String password,
                   AppUserRole appUserRole, String companyName) {
        this.email = email;
        this.password = password;
        this.appUserRole = appUserRole;
        this.companyName = companyName;
    }

    public String getProfilePictureUrl() {

        if(profilePicturePath == null) {
            return "https://cdn-icons-png.flaticon.com/512/3135/3135715.png";
        }

        return GlobalConfig.getInstance().getBackendUrl() + "api/v1/file/picture/" + getId();
    }

    public void addDelivery(Delivery delivery) {
        this.getDeliveries().add(delivery);
        delivery.setOwner(this);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority =
                new SimpleGrantedAuthority(appUserRole.name());
        return Collections.singletonList(authority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

}
