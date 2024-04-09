package edu.iu.habahram.DinerPancakeHouseMerge.controllers;

import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import edu.iu.habahram.DinerPancakeHouseMerge.model.Menu;
import edu.iu.habahram.DinerPancakeHouseMerge.repository.MergerRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/merger")
public class MergerController {

    private final MergerRepository repository;

    public MergerController(MergerRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<MenuItem> get() {
        List<MenuItem> menuItems = new ArrayList<>();
        ArrayList<Menu> menus = repository.getTheMenus();
        for (Menu menu : menus) {
            Iterator<MenuItem> iterator = menu.createIterator();
            while (iterator.hasNext()) {
                menuItems.add(iterator.next());
            }
        }
        return menuItems;
    }
}
