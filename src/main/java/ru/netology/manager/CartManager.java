package ru.netology.manager;

import ru.netology.domain.PurchaseItem;

public class CartManager {
    private PurchaseItem[] items = new PurchaseItem[0];

    public void add(PurchaseItem item) {
        // create a new array one more in size
        int length = items.length + 1;
        PurchaseItem[] tmp = new PurchaseItem[length];
        // itar + tab
        // copy element by element
        // for (int i = 0; i < items.length; i++) {
        //   tmp[i] = items[i];
        // }
        System.arraycopy(items, 0, tmp, 0, items.length);
        // put our last element
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public  PurchaseItem [] getAll () {
        PurchaseItem[] result = new PurchaseItem[items.length];
        // iterate over the array in direct order
        // but put in the results in reverse
        for (int i = 0; i < result.length; i++) {
            int index = items.length - i - 1;
            result[i] = items[index];
        }
        return result;
    }

    // naive implementation
    public void removeById(int id) {
        int length = items.length - 1;
        PurchaseItem[] tmp = new PurchaseItem[length];
        int index = 0;
        for (PurchaseItem item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        // change our elements
        items = tmp;
    }
}