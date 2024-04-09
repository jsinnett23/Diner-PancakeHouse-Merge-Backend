package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.PancakeHouseMenu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.Iterator; // Ensure this is your custom Iterator
import org.springframework.stereotype.Repository;

@Repository
public class PancakeHouseRepository {
    private final PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();

    public PancakeHouseMenu getPancakeHouseMenu() {
        return pancakeHouseMenu;
    }

    // If you decide to return the iterator directly
    public Iterator getIterator() {
        return pancakeHouseMenu.createIterator();
    }
}
