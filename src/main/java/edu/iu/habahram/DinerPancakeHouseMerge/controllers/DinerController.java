package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.DinerRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/diner")
public class DinerController {

    private final DinerRepository repository;

    public DinerController(DinerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<MenuItem> get() {
        List<MenuItem> items = new ArrayList<>();
        // Since getTheMenu returns Menu, we get the iterator from the Menu
        Iterator<MenuItem> iterator = repository.getTheMenuIterator();
        iterator.forEachRemaining(items::add); // Add each item from the iterator to the list
        return items;
    }
}
