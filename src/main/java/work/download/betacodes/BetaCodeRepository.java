package work.download.betacodes;


import org.springframework.data.jpa.repository.JpaRepository;

public interface BetaCodeRepository extends JpaRepository<BetaCode, Long> {

    BetaCode findByKey(String key);

}
