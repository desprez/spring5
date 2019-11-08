package fr.training.samples.spring.shop.samples.spring.shop.infrastructure.item;

import java.util.Set;

import fr.training.samples.spring.shop.samples.spring.shop.domain.item.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Badr NASS
 *
 */
public interface ItemDataJpaRepository extends JpaRepository<ItemEntity, String> {

    /**
	 * @param id
	 * @return Set<ItemEntity>
	 */
	Set<ItemEntity> findByIdIn(Set<String> id);

}
