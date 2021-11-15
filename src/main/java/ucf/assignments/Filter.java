/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Cameron Parrish
 */
package ucf.assignments;

import java.util.List;
import java.util.Objects;

public class Filter {

    public static List<ItemMain.Items> AllItems(List<ItemMain.Items> ItemList){

        return ItemList;
        /*
        Pseudocode:
        Just passes through ItemList for now
         */
    }

    public static List<ItemMain.Items> CompleteItems(List<ItemMain.Items> ItemList, List<ItemMain.Items> FilterItemList){
        for (ItemMain.Items items : ItemList) {
            if (Objects.equals(items.status, "Complete")) {
                FilterItemList.add(items);
            }
        }
        return FilterItemList;
        /*
        Pseudocode:
        Iterate through the length of ItemList.size
        If ItemList.get status is equal to complete add it to FilterItemList
        Return FilterItemList
         */
    }

    public static List<ItemMain.Items> InCompleteItems(List<ItemMain.Items> ItemList, List<ItemMain.Items> FilterItemList){
        for (ItemMain.Items items : ItemList) {
            if (Objects.equals(items.status, "Incomplete")) {
                FilterItemList.add(items);
            }
        }



        return FilterItemList;
        /*
        Pseudocode:
        Iterate through the length of ItemList.size
        If ItemList.get status is equal to Incomplete add it to FilterItemList
        Return FilterItemList
         */
    }
}
