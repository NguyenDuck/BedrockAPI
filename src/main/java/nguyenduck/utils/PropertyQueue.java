package nguyenduck.utils;

import java.util.*;
import java.util.function.Consumer;

public class PropertyQueue implements Queue<Property> {

    private final HashMap<Integer, ArrayList<Property>> queue = new HashMap<>();

    @Override
    public int size() {
        return queue.keySet().stream().mapToInt(priority -> queue.get(priority).size()).sum();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o instanceof Property) return queue.keySet().stream().anyMatch(priority -> queue.get(priority).contains(o));
        return false;
    }

    private ArrayList<Property> toArrayList() {
        ArrayList<Property> list = new ArrayList<>();
        for (Integer priority : queue.keySet()) {
            list.addAll(queue.get(priority));
        }
        return list;
    }

    @Override
    public Iterator<Property> iterator() {
        return toArrayList().iterator();
    }

    @Override
    public Object[] toArray() {
        return toArrayList().toArray();
    }

    @Override
    public <T> T[] toArray(T [] a) {
        return toArrayList().toArray(a);
    }

    @Override
    public boolean add(Property property) {
        return add(0, property);
    }

    public boolean add(Integer priority, Property property) {
        ArrayList<Property> list = queue.get(priority);
//        System.out.println(list);
        if (list == null) {
            list = new ArrayList<>();
            list.add(property);
            queue.put(priority, list);
            return true;
        } else {
            return list.add(property);
        }
    }

    @Override
    public boolean remove(Object o) {
        if (o instanceof Property) {
            for (Integer priority : queue.keySet()) {
                ArrayList<Property> list = queue.get(priority);
                if (list.remove(o)) {
                    return queue.put(priority, list) != null;
                }
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return toArrayList().containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends Property> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        queue.clear();
    }

    @Override
    public boolean offer(Property property) {
        return offer(0, property);
    }

    public boolean offer(Integer priority, Property property) {
        ArrayList<Property> list = queue.get(priority);
        list.add(property);
        return queue.put(priority, list) != null;
    }

    @Override
    public Property remove() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Property poll() {
        if (!queue.isEmpty()) {
            for (Integer priority : queue.keySet()) {
                ArrayList<Property> list = queue.get(priority);
                Property r = list.get(0);
                if (r != null) {
                    queue.put(priority, list);
                    return r;
                }
            }
        }
        return null;
    }

    @Override
    public Property element() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Property peek() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void forEach(Consumer<? super Property> action) {
        Queue.super.forEach(action);
    }
}
