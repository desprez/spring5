package com.training.sample.springboothellorest.exposition;

import com.training.sample.springboothellorest.domaine.Info;
import com.training.sample.springboothellorest.repository.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/infos")
public class InfoController {
    @Autowired
    private InfoRepository infoRepository;

    @GetMapping
    public List<Info> getAllInfo() {
        return infoRepository.findAll();
    }
}
