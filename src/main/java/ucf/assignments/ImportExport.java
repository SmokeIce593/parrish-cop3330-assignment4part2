/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Cameron Parrish
 */
package ucf.assignments;

import java.io.*;
import java.util.List;

import static java.lang.System.out;

public class ImportExport {
    public static List<ItemMain.Items> ExportItems(List<ItemMain.Items> ItemList, String Path) throws IOException {
        try {
            File export = new File(Path);
            FileWriter fw = new FileWriter(export);
            for(int i=0; i<ItemList.size(); i++){
                fw.write(ItemList.get(i).name);
                fw.write(",");
                fw.write(ItemList.get(i).description);
                fw.write(",");
                fw.write(ItemList.get(i).duedate);
                fw.write(",");
                fw.write(ItemList.get(i).status);
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
        String currentphrase = "";
        String name = "";
        String description = "";
        String duedate = "";
        String status = "";
        int location = 0;
        while ((current = br.readLine()) != null)
            for(int i=0; i<current.length(); i++){
                if(current.charAt(i) != ','){
                    currentphrase += current.charAt(i);
                }
                else{
                    switch(location){
                        case 0:
                            name = currentphrase;
                            currentphrase = "";
                            location = 1;
                            break;
                        case 1:
                            description = currentphrase;
                            currentphrase = "";
                            location = 2;
                            break;
                        case 2:
                            duedate = currentphrase;
                            currentphrase = "";
                            location = 3;
                            break;
                        case 3:
                            status = currentphrase;
                            currentphrase = "";
                            location = 0;
                            ItemMain.CreateItem(ItemList, name, description, duedate, status);

                            break;
                    }
                }

            }


        return ItemList;
    }
}
