package work.download.delivery;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import work.download.appuser.AppUser;
import lombok.Data;
import work.download.delivery.enums.DeliveryStatus;
import work.download.delivery.enums.NotifyMode;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.UUID;

@Data
@Table(name = "delivery")
@Entity(name = "Delivery")
@ToString
@EqualsAndHashCode
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    private Long id;

    @Column(name = "uuid", nullable = false, unique = true)
    private String uuid = UUID.randomUUID().toString();

    @Column(name = "title")
    private String title;

    @Column(name = "disk_path", nullable = false)
    private String diskPath;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "id", name = "owner_id", nullable = false)
    private AppUser owner;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    @Column(name="delivered_at")
    private LocalDate deliveredAt;

    @Column(name = "client_email")
    private String clientEmail = "/";

    @Column(name = "order_number")
    private String orderNumber;

    @Column(name = "url_name")
    private String urlName;

    @Column(name = "password")
    private String password;

    @Column(name = "notify_mode", nullable = false)
    @Enumerated(EnumType.STRING)
    private NotifyMode notifyMode = NotifyMode.NONE;

    @Column(name = "delivery_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus = DeliveryStatus.OPEN;

    @Column(name = "last_access")
    private LocalDateTime lastAccess = LocalDateTime.now();

    @Column(name = "sent_created_email")
    private Boolean sentCreatedEmail = false;

    @Column(name = "sent_delivered_email")
    private Boolean sentDeliveredEmail = false;



}
