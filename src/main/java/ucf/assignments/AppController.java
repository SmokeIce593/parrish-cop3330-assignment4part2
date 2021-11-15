/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Cameron Parrish
 */
package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AppController {
    @FXML

    // For DisplayItems
    public Button EditItem;
    public Button CreateItem;
    public Button DeleteItem;
    public ChoiceBox FilterChoices;
    public ListView ItemListView;
    public Button ConfirmFilter;
    public TextField PathLocation;


    // For Import and Export
    public Label Import_Export;
    public Button SaveList;
    public Button ImportList;


    // For New Add/Edit
    public Label NameAddL;
    public Label DescriptionAddL;
    public Label DueDateAddL;
    public Label StatusAddL;
    public Label AddEditL;
    public Rectangle RectangleMain;
    public TextField AddNameF;
    public TextField AddDescriptionF;
    public DatePicker AddDateP;
    public ChoiceBox AddStatusC;
    public VBox vboxTest;
    public Button CreateItemSubmitB;
    public Button AddEditBack;

    // Create a Current ToDoList
    public ToDoListMain.ToDoList CurrentList = new ToDoListMain.ToDoList();


    // Create a Current Item
    public ItemMain.Items CurrentItem = new ItemMain.Items();

    public List<ItemMain.Items> ItemList = new ArrayList<>();

    public List<ItemMain.Items> FilterItemList = new ArrayList<>();

    public int EditFlag = 0;


    // Initializer
    @FXML
    public void initialize() {
        try {
            FilterChoices.getItems().add("All");
            FilterChoices.getItems().add("Complete");
            FilterChoices.getItems().add("Incomplete");
            AddStatusC.getItems().add("Complete");
            AddStatusC.getItems().add("Incomplete");
            AddStatusC.setValue("Incomplete");
            FilterChoices.setValue("All");

            vboxTest.setDisable(true);
            vboxTest.setVisible(false);
            RectangleMain.setVisible(false);

            /*
            Psuedocode:
            Initialize all the choicebox options. There are two choiceboxes in the program
            1. FilterChoices (This is where you filter out the view between all, complete, incomplete)
            Three options need to be .add All, Complete, and Incomplete
            2. AddStatusC (This is where you put either Complete or Incomplete for an item)
            Two options need to be .add Complete and Incomplete

            We then must disable the add/edit item vbox and rectangle, so we can see the main view
            using .setDisable and .setVisible
             */


        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    // Navigates to Edit Item page
    @FXML
    public void EditItemButton() throws IOException {
        try {
            if (!ItemListView.getSelectionModel().getSelectedItem().equals(null)) {
                vboxTest.setDisable(false);
                vboxTest.setVisible(true);
                RectangleMain.setVisible(true);
                CurrentItem = ItemMain.EditItemGetObj(ItemList, ItemListView.getSelectionModel().getSelectedItem().toString());
                AddNameF.setText(CurrentItem.name);
                AddDescriptionF.setText(CurrentItem.description);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate localDate = LocalDate.parse(CurrentItem.duedate, formatter);

                AddDateP.setValue(localDate);
                AddStatusC.setValue(CurrentItem.status);
                EditFlag = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
        Psuedocode:
        Using .setDisable and .setVisible undisable the vbox and make that and rectangle visible.
        Find item using EditItemGetObj
        Set respective fields (AddNameF AddDescriptionF AddDateP and AddStatusC) to values from EditItemGetObj
        since EditItemGetObj returns Item
        Set global variable Editflag to 0 (1 would denote creating an item)
         */
    }

    @FXML
    public void CreateItemButton() throws IOException {

        vboxTest.setDisable(false);
        vboxTest.setVisible(true);
        RectangleMain.setVisible(true);
        EditFlag = 1;

        AddNameF.clear();
        AddDescriptionF.clear();
        AddDateP.setValue(null);
        AddStatusC.setValue("Incomplete");

        /*
        Psuedocode:
        Using .setDisable and .setVisible undisable the vbox and make that and rectangle visible.
        Set global variable Editflag to 1 (0 would denote edting an item)
        Clear all fields (AddNameF AddDescriptionF AddDateP and AddStatusC)
         */

    }

    @FXML
    public void AddEditBackPress() throws IOException {
        vboxTest.setDisable(true);
        vboxTest.setVisible(false);
        RectangleMain.setVisible(false);

        /*
        Psuedocode:
        Using .setDisable and .setVisible disable the vbox and make that and rectangle invisible.
         */
    }

    @FXML
    public void ClearList() throws IOException {
        ItemList.clear();
        ItemListView.getItems().clear();
        CurrentList.ItemList.clear();
        ConfirmFilterButton();

        /*
        Psuedocode:
        Clear ItemList, ItemListView, and CurrentList.ItemList (This is a complete wipe of all items)
        Then run ConfirmFilterButton (This resets the ItemListView and FilterItemList)
         */
    }




    @FXML
    public void DeleteItemButton() throws IOException {
        // We also want to remove the selected item from the ItemList
        try {
            ItemMain.DestroyItem(ItemList, ItemListView.getSelectionModel().getSelectedItem().toString());


            // We also want to remove the selected item from the List View
            ItemListView.getItems().remove(ItemListView.getSelectionModel().getSelectedItem().toString());

            // We then need to give ItemListView to CurrentList
            CurrentList.ItemList = ItemList;
            ConfirmFilterButton();

        } catch (Exception e) {
            e.printStackTrace();
        }

        /*
        Psuedocode:
        We want to remove the current selected item from our main ItemList
        To do so we have to iterate through the size of the list and compare the name of that item
        to the selected item (converted to a string)
        If these names are the same remove the item from ItemList

        We then want to remove the item from the List View (So it is no longer visible to the user)
        Remove item based on ItemListView selected item (String).
        Then set CurrentList.ItemList = ItemList
         */
    }





    // Export/Import using the TextField File Location
    @FXML
    public void SaveListButton() throws IOException {
        ItemList = ImportExport.ExportItems(ItemList, PathLocation.getText());

        /*
        Psuedocode:
        When SaveListButton is clicked
        It will pass to ExportItems method (Which will export the items)
         */
    }

    @FXML
    public void ImportListButton() throws IOException {
        ItemList = ImportExport.ImportItems(ItemList, PathLocation.getText());
        CurrentList.ItemList = ItemList;
        ConfirmFilterButton();
         /*
        Psuedocode:
        When ImportListButton is clicked
        It will pass to ImportItems method (Which will export the items)
         */
    }



    @FXML
    // Premise of Method:
    // When the submit button is clicked it runs this
    // Add item to current to-do list based on the different labels
    // Then go back to the item view list based on the current to-do list
    public void CreateItemSubmitButton() throws IOException {
        try {
            String Date = AddDateP.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            System.out.printf("%s", Date);
            // Goes to the CreateItem function with the information provided
            ItemList = ItemMain.CreateItem(ItemList, AddNameF.getText(), AddDescriptionF.getText(), Date, (String) AddStatusC.getValue());

            // Flag to check if currentitem will be destroyed
            ItemList = ItemMain.EditItem(ItemList, CurrentItem.name, EditFlag);

            // Adds the new item to the currentlist
            CurrentList.ItemList = ItemList;

            // Clears list view and readds everything back
            ConfirmFilterButton();



            vboxTest.setDisable(true);
            vboxTest.setVisible(false);
            RectangleMain.setVisible(false);
            AddNameF.clear();
            AddDescriptionF.clear();
            AddDateP.setValue(null);
            AddStatusC.setValue(null);
        } catch (Exception e) {
            e.printStackTrace();
        }




        /*
        Psuedocode:
        Convert the date using a date formatter into yyyy-mm-dd using DateTimeFormatter
        Set ItemList equal to the method CreateItem. That function goes and adds all the fields into an item and adds
        the item to ItemList then returns ItemList.
        Set CurrentList ItemList array equal to ItemList.
        Add the item just added to ItemListView by getting size of currentList -1
         */
    }

    public void wipe(int FilterFlag) {
        ItemListView.getItems().clear();
        if (FilterFlag == 0) {
            for (int i = 0; i < CurrentList.ItemList.size(); i++) {
                ItemListView.getItems().add(CurrentList.ItemList.get(i).name);
            }
        } else {
            for (int i = 0; i < FilterItemList.size(); i++) {
                ItemListView.getItems().add(FilterItemList.get(i).name);
            }

        }
        /*
        Psuedocode:
        Clear the ItemListView (The purpose of this function is to display correct items)
        If the value taken in (FilterFlag equals 0) we need to iterate through the size of currentlist.itemlist
        and add all items to ItemListView
        Else we need to iterate through the size of FilterItemList and all all items to ItemListView
         */
    }

    @FXML
    public void ConfirmFilterButton() throws IOException {
        int FilterFlag;
        FilterItemList.clear();
       if(FilterChoices.getValue() == "Incomplete"){
           FilterItemList = Filter.InCompleteItems(ItemList, FilterItemList);
           FilterFlag = 1;
        }
       else if(FilterChoices.getValue() == "Complete"){
           FilterItemList = Filter.CompleteItems(ItemList, FilterItemList);
           FilterFlag = 1;
       }
       else{
           ItemList = Filter.AllItems(ItemList, FilterItemList);
           FilterFlag = 0;

       }

       wipe(FilterFlag);

       /*
        Psuedocode:
        Clear FilterList
        Check FilterChoice to see if it's incomplete, complete, or all.
        If it's incomplete or complete set FilterFlag to 1 (Which is used in wipe)
            -If incomplete FilterItemList equals Incompleteitems method. This method should determine which
            items are or complete.
            -If complete FilterItemList equals Completeitems method. This method should determine which
            items are incomplete or complete.
        Else set FilterFlag to 0 and ItemList = FilterAllItems (Which just passes ItemList to ItemList)
        Then Wipe using FilterFlag value which correctly displays the filter or the ItemList
         */
    }




}
