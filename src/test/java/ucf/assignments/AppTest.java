/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Cameron Parrish
 */
package ucf.assignments;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



class AppTest {
    @Test
    void AddItem(){
        List<ItemMain.Items> ItemList = new ArrayList<>();
        ItemList = ItemMain.CreateItem(ItemList, "Bob", "Test", "2019-12-01", "Complete");
            Assert.assertTrue(ItemList.get(0).name == "Bob" && ItemList.get(0).description == "Test");

            /*
            Psuedocode:
            Create ItemList array of Items
            Have this equal to CreateItem from the ItemMain class. Fill in random strings to test.
            Assert.assertTrue and test to make sure that ItemList.get(0) contains the correct strings
             */
    }

    @Test
    void RemoveItem(){
        List<ItemMain.Items> ItemList = new ArrayList<>();
        String Name = "Bob";
        ItemList = ItemMain.CreateItem(ItemList, "Bob", "Test", "2019-12-01", "Complete");
        ItemList = ItemMain.DestroyItem(ItemList, Name);
        Assert.assertTrue(ItemList.isEmpty());

        /*
            Psuedocode:
            Create ItemList array of Items
            Have this equal to CreateItem from the ItemMain class. Fill in random strings to test.
            Have ItemList equal DestroyItem from the ItemMain class. Fill in with correct name of item.
            This should have removed the item.
            Assert.assertTrue and check if ItemList.isEmpty() evaluates as true.
        */
    }

    @Test
    /*
    Premise:
    Editing an Item is coded to delete the original item then create the item with the given inputs
    So the process is you create an item
    You click an item and click "Edit item" which adds all the various strings to correct locations
    When first clicked to edit flag is set to 0 to denote an edit. This means it will go search for the
    object clicked. When you click an object and click edit it stores it in currentitem.
    CurrentItem.name is what we want to search for in the ItemMain (Hence why it will be hardset here)
    The edit flag is also hardset here since we want to denote edit and not create
     */
    void EditDueDate(){
        List<ItemMain.Items> ItemList = new ArrayList<>();
        ItemMain.Items CurrentItem = new ItemMain.Items();
        ItemList = ItemMain.CreateItem(ItemList, "Bob", "Test", "2019-12-01", "Complete");
        CurrentItem = ItemList.get(0);
        ItemList = ItemMain.EditItem(ItemList, CurrentItem.name, 0);
        ItemList = ItemMain.CreateItem(ItemList, "Bob", "Test", "2018-11-21", "Complete");
        Assert.assertEquals(ItemList.get(0).duedate, "2018-11-21");


        /*
        Psuedocode:
        We want to create an ItemList and a CurrentItem (List of items and single item)
        Have ItemList equal to CreateItem from the ItemMain class. Fill in random strings to test.
        Here we are going to emulate us selecting an item. When we select an item it technically
        searches for the item in ItemList by name, but here we set it do be for simplicity sake.
        We then emulate clicking the submit button on the program, this will run both EditItem and CreateItem
        from the ItemMain class.
        - For EditItem we have to hardset editflag to 0 (Since it's a global variable and is set when
        we are attempting to edit the program. This should search for the item based on CurrentItem.name
        and remove it if found.
        -For Create Item we just change the duedate from the original and run it like before.
        We then check to make sure the duedate of the first item in itemlist is that new duedate,
        if it is we sucessfully deleted the old one and added the new one.
         */
    }

    /*
    Premise:
    Editing an Item is coded to delete the original item then create the item with the given inputs
    So the process is you create an item
    You click an item and click "Edit item" which adds all the various strings to correct locations
    When first clicked to edit flag is set to 0 to denote an edit. This means it will go search for the
    object clicked. When you click an object and click edit it stores it in currentitem.
    CurrentItem.name is what we want to search for in the ItemMain (Hence why it will be hardset here)
    The edit flag is also hardset here since we want to denote edit and not create
     */
    @Test
    void EditDescriptionItem(){
        List<ItemMain.Items> ItemList = new ArrayList<>();
        ItemMain.Items CurrentItem = new ItemMain.Items();
        ItemList = ItemMain.CreateItem(ItemList, "Bob", "Test", "2019-12-01", "Complete");
        CurrentItem = ItemList.get(0);
        ItemList = ItemMain.EditItem(ItemList, CurrentItem.name, 0);
        ItemList = ItemMain.CreateItem(ItemList, "Bob", "Jolly", "2019-12-01", "Complete");
        Assert.assertEquals(ItemList.get(0).description, "Jolly");

        /*
        Psuedocode:
        We want to create an ItemList and a CurrentItem (List of items and single item)
        Have ItemList equal to CreateItem from the ItemMain class. Fill in random strings to test.
        Here we are going to emulate us selecting an item. When we select an item it technically
        searches for the item in ItemList by name, but here we set it do be for simplicity sake.
        We then emulate clicking the submit button on the program, this will run both EditItem and CreateItem
        from the ItemMain class.
        - For EditItem we have to hardset editflag to 0 (Since it's a global variable and is set when
        we are attempting to edit the program. This should search for the item based on CurrentItem.name
        and remove it if found.
        -For Create Item we just change the description from the original and run it like before.
        We then check to make sure the description of the first item in itemlist is that new description,
        if it is we sucessfully deleted the old one and added the new one.
         */
    }

    @Test
    void EditItemOBJTest(){
        List<ItemMain.Items> ItemList = new ArrayList<>();
        ItemMain.Items CurrentItem = new ItemMain.Items();
        ItemList = ItemMain.CreateItem(ItemList, "Bob", "Test", "2019-12-01", "Incomplete");

        CurrentItem = ItemMain.EditItemGetObj(ItemList, "Bob");
        Assert.assertEquals(CurrentItem.name, ItemList.get(0).name);

         /*
            Psuedocode:
            Create ItemList array of Items
            Create CurrentItem (which is just an Item)
            Have ItemList equal to CreateItem from the ItemMain class. Fill in random strings to test.
            Have CurrentItem equal to EditItemGetObj from the ItemMain class. The string to search for is "Bob"
            Assertequals the items.name and ItemList.get(0).name.
        */
    }

    @Test
    void MarkItemAsComplete(){
        List<ItemMain.Items> ItemList = new ArrayList<>();
        ItemList = ItemMain.CreateItem(ItemList, "Bob", "Test", "2019-12-01", "Complete");
        Assert.assertTrue(ItemList.get(0).status == "Complete");

        /*
            Psuedocode:
            Create ItemList array of Items
            Have this equal to CreateItem from the ItemMain class. Fill in random strings to test.
            Assert.assertTrue and test to make sure that ItemList.get(0) contains the correct strings
            Note an item can be marked as complete/incomplete on creation OR on edit (which can be shown in the edit
            junit test.
         */
    }

    @Test
    void DisplayAllItems(){
        List<ItemMain.Items> ItemList = new ArrayList<>();
        List<ItemMain.Items> FilterItemList = new ArrayList<>();
        ItemList = ItemMain.CreateItem(ItemList, "Bob", "Test", "2019-12-01", "Complete");
        int size = ItemList.size();
        ItemList = Filter.AllItems(ItemList, FilterItemList);
        Assert.assertTrue(size == ItemList.size() && ItemList.get(0).name == "Bob");

        /*
        Psuedocode:
        Create Item list and FilterItem List (Item array and Item)
        Create Item using CreateItem from ItemMain class.
        Note the size of ItemList.
        Run AllItems from Filter class.
        AssertTrue check the size and the name of the first item, these should be the same
         */

    }

    @Test
    void DisplayIncompletedItems(){
        List<ItemMain.Items> ItemList = new ArrayList<>();
        List<ItemMain.Items> FilterItemList = new ArrayList<>();
        ItemList = ItemMain.CreateItem(ItemList, "Bob", "Test", "2019-12-01", "Complete");
        ItemList = ItemMain.CreateItem(ItemList, "Builder", "Test", "2019-12-01", "Incomplete");
        int size = ItemList.size();
        ItemList = Filter.InCompleteItems(ItemList, FilterItemList);
        Assert.assertTrue(size != ItemList.size() && ItemList.get(0).name != "Bob");

        /*
        Psuedocode:
        Create Item list and FilterItem List (Item array and Item)
        Create two Items using CreateItem from ItemMain class (One complete and one incomplete)
        Note the size of ItemList.
        Run AllItems from Filter class.
        AssertTrue check the size and the name of the first item, these should not be the same.
         */

    }


    @Test
    void DisplayCompletedItems(){
        List<ItemMain.Items> ItemList = new ArrayList<>();
        List<ItemMain.Items> FilterItemList = new ArrayList<>();
        ItemList = ItemMain.CreateItem(ItemList, "Bob", "Test", "2019-12-01", "Complete");
        ItemList = ItemMain.CreateItem(ItemList, "Builder", "Test", "2019-12-01", "Incomplete");
        int size = ItemList.size();
        ItemList = Filter.CompleteItems(ItemList, FilterItemList);
        Assert.assertTrue(size != ItemList.size() && ItemList.get(0).name == "Bob");

        /*
        Psuedocode:
        Create Item list and FilterItem List (Item array and Item)
        Create two Items using CreateItem from ItemMain class (One complete and one incomplete)
        Note the size of ItemList.
        Run AllItems from Filter class.
        AssertTrue check the size and the name of the first item, the size should not be the same,
        The name should be (Since the first item name is Bob.
         */

    }


    @Test
    // The path will need to be changed to work
    void ExportList() throws IOException {
        List<ItemMain.Items> ItemList = new ArrayList<>();
        ItemList = ItemMain.CreateItem(ItemList, "Bob", "Test", "2019-12-01", "Complete");
        List<ItemMain.Items> ItemListCompare = new ArrayList<>();
        ItemListCompare = ItemMain.CreateItem(ItemList, "Bob", "Test", "2019-12-01", "Complete");
        ItemList = ImportExport.ExportItems(ItemList, "C:/Users/parriscz/Downloads/export.txt");
        Assert.assertEquals(ItemList.get(0).name, ItemListCompare.get(0).name);

        /*
        Psuedocode:
        This just checks and makes sure that ItemList is passed into the function and does not change.
        Create ItemList and ItemListcompare.
        Have this equal to CreateItem from the ItemMain class. Fill in random strings to test.
        Have ItemList equal the Export method from ImportExport class (with my desktop path)
        Assert.assertTrue and test to make sure that ItemList.get(0) equals ItemListCompare.get(0)
         */
    }



    @Test
    // The path will need to be changed to work
    // This checks the first item in the export and verifies it's been exported
    void ImportList() throws IOException {
        String Path = "C:/Users/parriscz/Downloads/export.txt";
        List<ItemMain.Items> ItemListCreate = new ArrayList<>();
        ItemListCreate = ItemMain.CreateItem(ItemListCreate, "bob", "Test", "2019-12-01", "Complete");
        ItemListCreate = ImportExport.ExportItems(ItemListCreate, Path);

        List<ItemMain.Items> ItemList = new ArrayList<>();
        ItemList = ImportExport.ImportItems(ItemList, Path);
        Assert.assertEquals(ItemList.get(0).name, "bob");

        /*
        Psuedocode:
        Creates an ItemListCreate instance
        Have this equal to CreateItem from the ItemMain class. Fill in random strings to test.
        Have ItemList equal the Export method from ImportExport class (with my desktop path) with path
        C:/Users/Cameron/Desktop/ImportTest.txt
        Creates an ItemList instance.
        ItemList equals Importitems from ImportExport class with path of C:/Users/Cameron/Desktop/ImportTest.txt
        AssertEquals ItemList.get(0).name and the name of exported item
        Make sure to change the path location to desired path
         */
    }
}