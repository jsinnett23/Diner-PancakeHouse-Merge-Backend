package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.Iterator;
import java.util.Map;

public class CafeMenuIterator implements Iterator<MenuItem> {
    Map<String, MenuItem> items;
    int position = 0;

    public CafeMenuIterator(Map<String, MenuItem> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public MenuItem next() {
        MenuItem item = (MenuItem) items.values().toArray()[position];
        position += 1;
        return item;
    }
}
