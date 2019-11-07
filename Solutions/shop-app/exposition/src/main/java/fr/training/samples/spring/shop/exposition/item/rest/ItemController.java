package fr.training.samples.spring.shop.exposition.item.rest;

import fr.training.samples.spring.shop.application.item.ItemManagement;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemController {

    private ItemManagement itemManagement;
    private ItemMapper itemMapper;


    public ItemController(ItemManagement itemManagement, ItemMapper itemMapper) {
        this.itemManagement = itemManagement;
        this.itemMapper = itemMapper;
    }

    @GetMapping("/items")
    public List<ItemDTO> findAll(){
        return itemMapper.mapToDtoList(itemManagement.getAllItems());
    }

}
