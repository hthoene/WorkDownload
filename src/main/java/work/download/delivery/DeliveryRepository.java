package work.download.delivery;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    List<Delivery> findDeliveriesByOwnerId(Long id);

    Delivery findDeliveryByUrlName(String urlName);

    @Query(value = "SELECT d FROM Delivery d ORDER BY d.lastAccess ASC ")
    List<Delivery> findAllOrderedByUnused(Pageable pageable);

}
