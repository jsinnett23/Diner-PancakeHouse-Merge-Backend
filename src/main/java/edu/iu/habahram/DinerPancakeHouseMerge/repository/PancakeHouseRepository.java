package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.Menu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.PancakeHouseMenu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.Iterator; // Ensure this is your custom Iterator
import org.springframework.stereotype.Repository;

@Repository
public class PancakeHouseRepository {
    private final Menu pancakeHouseMenu = new PancakeHouseMenu();
    public Menu getPancakeHouseMenu() {
        return pancakeHouseMenu;
    }
}
