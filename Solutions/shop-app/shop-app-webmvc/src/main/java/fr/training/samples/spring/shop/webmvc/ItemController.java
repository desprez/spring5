package fr.training.samples.spring.shop.webmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${spring.shop.showItems.url}")
    private String showItemsUrl;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/items")
    public ModelAndView showItems() {
        ItemDTO[] response = restTemplate.getForObject(showItemsUrl, ItemDTO[].class);
        List<ItemDTO> items = Arrays.asList(response);
        return new ModelAndView("items", "items", items);
    }

}