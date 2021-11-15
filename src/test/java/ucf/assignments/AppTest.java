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
    void EditDescriptionItem(){


    }

    @Test
    void EditDueDateItem(){
        /*
    ToDoListMain.ToDoList CurrentList = new ToDoListMain.ToDoList;
    CurrentList = CreateItem(ToDoListMain.ToDoList CurrentList, "Name", "Description", "2019-12-01", "Incomplete")
    ItemMain.Items CurrentItem = CurrentList.Get

    CurrentList = EditItem(ToDoListMain.ToDoList CurrentList, ItemMain.Items CurrentItem,  "Name", "Description", "2015-02-04", "Incomplete")

    If(CurrentList.get(1) obj duedate == "2015-02-04")
        AssertTrue
    AssertFalse
     */

    }

    @Test
    void EditItemOBJTest(){
        List<ItemMain.Items> ItemList = new ArrayList<>();
        ItemMain.Items CurrentItem = new ItemMain.Items();
        ItemList = ItemMain.CreateItem(ItemList, "Bob", "Test", "2019-12-01", "Complete");

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
        /*
    ToDoListMain.ToDoList CurrentList = new ToDoListMain.ToDoList;
    CurrentList = CreateItem(ToDoListMain.ToDoList CurrentList, "Name", "Description", "2019-12-01", "Incomplete")
    ItemMain.Items CurrentItem = CurrentList.Get

    CurrentList = EditItem(ToDoListMain.ToDoList CurrentList, ItemMain.Items CurrentItem,  "Name", "Description", "2015-02-04", "Complete")

    If(CurrentList.get(1) obj status = "Complete")
        AssertTrue
    AssertFalse
     */

    }

    @Test
    void DisplayAllItems(){
        /*
        ToDoListMain.ToDoList CurrentList = new ToDoListMain.ToDoList;
        ToDoListMain.ToDoList FilterList = new ToDoListMain.ToDoList;
        CurrentList = CreateItem(ToDoListMain.ToDoList CurrentList, "Name", "Description", "2019-12-01", "Incomplete")
        FilterList = AllItems(CurrentList);
        if(FilterList name == CurrentList name && FilterList obj name == CurrentList obj name)
            AssertTrue
        AssertFalse

         */
    }

    @Test
    void DisplayIncompletedItems(){
        /*
        ToDoListMain.ToDoList CurrentList = new ToDoListMain.ToDoList;
        ToDoListMain.ToDoList FilterList = new ToDoListMain.ToDoList;
        CurrentList = CreateItem(ToDoListMain.ToDoList CurrentList, "Name", "Description", "2019-12-01", "Incomplete")
        FilterList = InCompleteItems(CurrentList);
        if(FilterList name == CurrentList name && FilterList obj name == CurrentList obj name)
            AssertTrue
        AssertFalse
         */

    }


    @Test
    void DisplayCompletedItems(){
        /*
        ToDoListMain.ToDoList CurrentList = new ToDoListMain.ToDoList;
        ToDoListMain.ToDoList FilterList = new ToDoListMain.ToDoList;
        CurrentList = CreateItem(ToDoListMain.ToDoList CurrentList, "Name", "Description", "2019-12-01", "Complete")
        FilterList = InCompleteItems(CurrentList);
        if(FilterList name == CurrentList name && FilterList obj name == CurrentList obj name)
            AssertTrue
        AssertFalse
         */

    }


    @Test
    // The path will need to be changed to work
    void ExportList() throws IOException {
        List<ItemMain.Items> ItemList = new ArrayList<>();
        ItemList = ItemMain.CreateItem(ItemList, "Bob", "Test", "2019-12-01", "Complete");
        List<ItemMain.Items> ItemListCompare = new ArrayList<>();
        ItemListCompare = ItemMain.CreateItem(ItemList, "Bob", "Test", "2019-12-01", "Complete");
        ItemList = ImportExport.ExportItems(ItemList, "C:/Users/Cameron/Desktop/export.txt");
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
        String Path = "C:/Users/Cameron/Desktop/ImportTest.txt";
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