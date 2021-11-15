/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Cameron Parrish
 */
package ucf.assignments;

import java.util.ArrayList;
import java.util.List;

public class Filter {

    public static List<ItemMain.Items> AllItems(List<ItemMain.Items> ItemList, List<ItemMain.Items> FilterItemList){

        return ItemList;
        /*
        Psuedocode:
        Just passes through ItemList for now
         */
    }

    public static List<ItemMain.Items> CompleteItems(List<ItemMain.Items> ItemList, List<ItemMain.Items> FilterItemList){
        for(int i=0; i<ItemList.size(); i++){
            if(ItemList.get(i).status.toString() == "Complete"){
                FilterItemList.add(ItemList.get(i));
            }
        }
        return FilterItemList;
        /*
        Psuedocode:
        Iterate through the length of ItemList.size
        If ItemList.get status is equal to complete add it to FilterItemList
        Return FilterItemList
         */
    }

    public static List<ItemMain.Items> InCompleteItems(List<ItemMain.Items> ItemList, List<ItemMain.Items> FilterItemList){
        for(int i=0; i<ItemList.size(); i++){
            if(ItemList.get(i).status.toString() == "Incomplete"){
                FilterItemList.add(ItemList.get(i));
            }
        }



        return FilterItemList;
        /*
        Psuedocode:
        Iterate through the length of ItemList.size
        If ItemList.get status is equal to Incomplete add it to FilterItemList
        Return FilterItemList
         */
    }
}
