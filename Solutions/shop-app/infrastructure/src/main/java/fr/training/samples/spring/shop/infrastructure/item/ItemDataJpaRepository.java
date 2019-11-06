package fr.training.samples.spring.shop.infrastructure.item;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.training.samples.spring.shop.domain.item.ItemEntity;

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
