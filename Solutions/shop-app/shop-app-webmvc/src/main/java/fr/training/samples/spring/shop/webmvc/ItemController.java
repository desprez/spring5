package fr.training.samples.spring.shop.webmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.ModelAndView;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.time.ZonedDateTime;
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
    public ModelAndView showItems() throws URISyntaxException {
        ItemDTO[] response = restTemplate.getForObject(showItemsUrl, ItemDTO[].class);
        List<ItemDTO> items = Arrays.asList(response);

        ResponseEntity<String> result =  WebClient.builder().build().get()
                .uri(showItemsUrl)
                .exchange()
                .flatMap(mono -> mono.toEntity(String.class))
                .block();

        System.out.println(result.getBody());

        return new ModelAndView("items", "items", items);
    }

}