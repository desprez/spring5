package fr.training.samples.spring.shop.repository.item;

import fr.training.samples.spring.shop.domain.item.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepositoryDataJPA extends JpaRepository<ItemEntity, String> {
}
