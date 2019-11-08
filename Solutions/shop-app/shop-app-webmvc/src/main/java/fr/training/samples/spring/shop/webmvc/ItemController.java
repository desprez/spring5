package fr.training.samples.spring.shop.webmvc;

import fr.training.samples.spring.shop.samples.spring.shop.application.item.ItemManagement;
import fr.training.samples.spring.shop.samples.spring.shop.domain.item.ItemEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private ItemManagement itemManagement;

    @Autowired
    private ItemMapper itemMapper;

    @RequestMapping("/items")
    public ModelAndView showItems() {
        final List<ItemEntity> itemEntities = itemManagement.getAllItems();
        List<ItemDTO> items = itemMapper.mapToDtoList(itemEntities);
        return new ModelAndView("items", "items", items);
    }

}