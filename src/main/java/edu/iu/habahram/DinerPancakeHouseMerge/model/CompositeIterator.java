package edu.iu.habahram.DinerPancakeHouseMerge.model;

import java.util.Iterator;
import java.util.Stack;
import java.util.Arrays;

public class CompositeIterator implements Iterator {
    Stack<Iterator> stack = new Stack<>();

    public CompositeIterator(Iterator iterator) {
        stack.push(iterator);
    }

    public MenuItem next() {
        if (hasNext()) {
            Iterator iterator = stack.peek();
            MenuComponent component = (MenuComponent) iterator.next();
            if (component instanceof Menu) {
                stack.push(Arrays.asList(((Menu)component).getItems()).iterator());
            }
            return (MenuItem) component;
        } else {
            return null;
        }
    }


    public boolean hasNext() {
        if (stack.empty()) {
            return false;
        } else {
            Iterator iterator = stack.peek();
            if (!iterator.hasNext()) {
                stack.pop();
                return hasNext();
            } else {
                return true;
            }
        }
    }
}
