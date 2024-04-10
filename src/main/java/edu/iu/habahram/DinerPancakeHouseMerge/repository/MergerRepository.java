package edu.iu.habahram.DinerPancakeHouseMerge.repository;

import edu.iu.habahram.DinerPancakeHouseMerge.model.*;
import edu.iu.habahram.DinerPancakeHouseMerge.model.Menu;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuComponent;
import edu.iu.habahram.DinerPancakeHouseMerge.model.MenuItem;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import edu.iu.habahram.DinerPancakeHouseMerge.model.CompositeIterator;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin

@Repository
public class MergerRepository {




    public List<MenuItemRecord> getVegetarianMenuItems() {
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));

        CompositeIterator iterator = new CompositeIterator(Arrays.asList(allMenus.getItems()).iterator());
        List<MenuItemRecord> records = new ArrayList<>();
        while (iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            if (menuItem.isVegetarian()) {
                records.add(new MenuItemRecord(menuItem.getName(),
                        menuItem.getDescription(),
                        menuItem.isVegetarian(),
                        menuItem.getPrice()));
            }
        }
        return records;
    }

    public List<MenuItemRecord> getBreakfastMenuItems() {
        MenuComponent breakfastMenu = new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast");
        return getMenuItems(breakfastMenu);
    }

    public List<MenuItemRecord> getLunchMenuItems() {
        MenuComponent lunchMenu = new DinerMenu("DINER MENU", "Lunch");
        return getMenuItems(lunchMenu);
    }

    public List<MenuItemRecord> getSupperMenuItems() {
        MenuComponent supperMenu = new CafeMenu("CAFE MENU", "Dinner");
        return getMenuItems(supperMenu);
    }

    private List<MenuItemRecord> getMenuItems(MenuComponent menu) {
        CompositeIterator iterator = new CompositeIterator(Arrays.asList(menu.getItems()).iterator());
        List<MenuItemRecord> records = new ArrayList<>();
        while (iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            records.add(new MenuItemRecord(menuItem.getName(),
                    menuItem.getDescription(),
                    menuItem.isVegetarian(),
                    menuItem.getPrice()));
        }
        return records;
    }

    public List<MenuItemRecord> getTheMenuItems() {
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(new DinerMenu("DINER MENU", "Lunch"));
        allMenus.add(new PancakeHouseMenu("PANCAKE HOUSE MENU", "Breakfast"));
        allMenus.add(new CafeMenu("CAFE MENU", "Dinner"));
        MenuItem[] menuItems = allMenus.getItems();
        List<MenuItemRecord> records = Arrays.stream(menuItems)
                .map(x -> new MenuItemRecord(x.getName(),
                        x.getDescription(),
                        x.isVegetarian(),
                        x.getPrice())).toList();
        return records;
    }

    public void saveCustomer(Customer customer) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/customers.txt", true))) {
            writer.write(customer.getUsername() + "," + customer.getPassword() + "," + customer.getEmail());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


