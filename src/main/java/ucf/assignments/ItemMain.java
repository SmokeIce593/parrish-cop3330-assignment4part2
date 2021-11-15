/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Cameron Parrish
 */

package ucf.assignments;

import java.util.ArrayList;
import java.util.List;

public class ItemMain {
    // This is an item object. Contains the information we need for a single item
    public static class Items {
        public String name;
        public String description;
        public String duedate;
        public String status;
    }



    public static List<ItemMain.Items> CreateItem(List<ItemMain.Items> ItemList, String Name, String Description, String Duedate, String Status){
        Items ThisItem = new Items();
        ThisItem.name = Name;
        ThisItem.description = Description;
        ThisItem.duedate = Duedate;
        ThisItem.status = Status;
        ItemList.add(ThisItem);

        return ItemList;
        /*
        Psuedocode:
        Create an Item.
        Add each value passed into method to Item. (Name, Description, Duedate, and Status)
        Then add the item to ItemList and return ItemList
         */

    }


    public static Items EditItemGetObj(List<ItemMain.Items> ItemList, String name){
        for(int i=0; i<ItemList.size(); i++){
            if(ItemList.get(i).name == name){
                return ItemList.get(i);
            }

        }


        return null;
         /*
        Psuedocode:
        Iterate through ItemList.size
        If Itemlist.get(i).name is equal to the name (which was passed into method)
        Return the item
         */
    }

    public static List<ItemMain.Items> DestroyItem(List<ItemMain.Items> ItemList, String Current){
        for (int i = 0; i < ItemList.size(); i++) {
            if (ItemList.get(i).name == Current) {
                ItemList.remove(i);
                return ItemList;
            }
        }



        return null;
         /*
        Psuedocode:
        Iterate through ItemList.size
        If Itemlist.get(i).name is equal to the current name (which was passed into method)
        remove the item from ItemList
        Return ItemList
         */
    }

    public static List<ItemMain.Items> EditItem(List<ItemMain.Items> ItemList, String Current, int EditFlag){
        if(EditFlag == 0){
            ItemList = ItemMain.DestroyItem(ItemList, Current);
        }
        return ItemList;
    }



}
