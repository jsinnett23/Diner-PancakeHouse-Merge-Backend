package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.PancakeHouseRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/merger") // Set the request mapping to "/merger"
public class MergerController {

    private final DinerRepository dinerRepository;
    private final PancakeHouseRepository pancakeHouseRepository;

    // Constructor injection of the repositories
    public MergerController(DinerRepository dinerRepository, PancakeHouseRepository pancakeHouseRepository) {
        this.dinerRepository = dinerRepository;
        this.pancakeHouseRepository = pancakeHouseRepository;
    }

    @GetMapping
    public List<MenuItem> getMergedMenu() {
        // Fetch menu items from both the diner and pancake house
        List<MenuItem> dinerMenuItems = Arrays.asList(dinerRepository.getTheMenu());
        List<MenuItem> pancakeHouseMenuItems = pancakeHouseRepository.getTheMenu();

        // Combine both lists
        List<MenuItem> combinedMenu = Stream.concat(dinerMenuItems.stream(), pancakeHouseMenuItems.stream())
                .sorted(Comparator.comparing(MenuItem::getName)) // Sort by name
                .collect(Collectors.toList());

        return combinedMenu;
    }
}
