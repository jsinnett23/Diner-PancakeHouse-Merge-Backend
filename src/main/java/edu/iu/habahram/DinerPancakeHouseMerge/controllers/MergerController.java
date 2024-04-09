package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.Iterator;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergerController {

    DinerRepository dinerRepository;
    PancakeHouseRepository pancakeHouseRepository;

    public MergerController(DinerRepository dinerRepository, PancakeHouseRepository pancakeHouseRepository) {
        this.dinerRepository = dinerRepository;
        this.pancakeHouseRepository = pancakeHouseRepository;
    }

    @GetMapping
    public List<MenuItem> get() {
        List<MenuItem> mergedMenu = new ArrayList<>();
        java.util.Iterator<MenuItem> pancakeIterator = pancakeHouseRepository.getPancakeHouseMenu().createIterator();
        while (pancakeIterator.hasNext()) {
            mergedMenu.add(pancakeIterator.next());
        }
        java.util.Iterator<MenuItem> dinerIterator = dinerRepository.getTheMenu().createIterator();
        while (dinerIterator.hasNext()) {
            mergedMenu.add(dinerIterator.next());
        }
        mergedMenu.sort(Comparator.comparing(MenuItem::getName));
        return mergedMenu;
    }
}
