package work.download.betacodes;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "BetaCode")
@Table(name = "beta_codes")
public class BetaCode {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "beta_key", unique = true)
    private String key;

}
