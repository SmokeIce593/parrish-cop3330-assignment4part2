/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Cameron Parrish
 */
package ucf.assignments;

import java.io.*;
import java.util.List;

public class ImportExport {
    public static List<ItemMain.Items> ExportItems(List<ItemMain.Items> ItemList, String Path) {
        try {
            File export = new File(Path);
            FileWriter fw = new FileWriter(export);
            for (ItemMain.Items items : ItemList) {
                fw.write(items.name);
                fw.write(",");
                fw.write(items.description);
                fw.write(",");
                fw.write(items.duedate);
                fw.write(",");
                fw.write(items.status);
                fw.write(",");
            }
            fw.close();

        } catch (IOException iox) {
            //do stuff with exception
            iox.printStackTrace();
        }

        return ItemList;
    }

    public static List<ItemMain.Items> ImportItems(List<ItemMain.Items> ItemList, String Path) throws IOException {
        File importdata = new File(Path);
        // C:/Users/Cameron/Desktop/export.txt
        // C:/Users/parriscz/Downloads/export.txt
        BufferedReader br = new BufferedReader(new FileReader(importdata));

        String current;
        StringBuilder currentphrase = new StringBuilder();
        String name = "";
        String description = "";
        String duedate = "";
        String status;
        int location = 0;
        while ((current = br.readLine()) != null)
            for(int i=0; i<current.length(); i++){
                if(current.charAt(i) != ','){
                    currentphrase.append(current.charAt(i));
                }
                else{
                    switch (location) {
                        case 0 -> {
                            name = currentphrase.toString();
                            currentphrase = new StringBuilder();
                            location = 1;
                        }
                        case 1 -> {
                            description = currentphrase.toString();
                            currentphrase = new StringBuilder();
                            location = 2;
                        }
                        case 2 -> {
                            duedate = currentphrase.toString();
                            currentphrase = new StringBuilder();
                            location = 3;
                        }
                        case 3 -> {
                            status = currentphrase.toString();
                            currentphrase = new StringBuilder();
                            location = 0;
                            ItemMain.CreateItem(ItemList, name, description, duedate, status);
                        }
                    }
                }

            }


        return ItemList;
    }
}
