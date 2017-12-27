/*
Author: Jake Edwards
Date Started: 02/20/2017
Date Finished: 03/03/2017

Purpose: Read a formatted file and create a linked list inventory from that data.
*/

package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException{

        //setup File and Scanner objects
        File file = new File("C:\\Users\\edwar\\Documents\\Data Structures\\Take1\\Lab_3\\assets\\p3.dat");
        Scanner input = new Scanner(file);


        ListOperators list = new ListOperators();

        int numToRemove;
        int numToAdd;
        int componentNumber;
        String description;
        int inStock;
        int reorderLevel;

        // test for end of file
        while (input.hasNext()) {

            // control statement for all file commands: R, A, D, I, P, Q
            switch (input.next()) {

                // remove from stock
                case "R" :
                    componentNumber = input.nextInt();
                    numToRemove = input.nextInt();
                    Node ref = (Node)list.search(componentNumber);

                    if (ref.getUnitsInStock() - numToRemove <= 0) {
                        ref.setUnitsInStock(0);
                        ref.setReorderFlag(true);
                    }
                    else if (ref.getUnitsInStock() - numToRemove < ref.getReorderLevel()) {
                        ref.setReorderFlag(true);
                        list.removeFromStock(componentNumber, numToRemove);
                    }
                    else {
                        list.removeFromStock(componentNumber, numToRemove);
                    }


                    break;

                // Add to stock
                case "A" :
                    componentNumber = input.nextInt();
                    numToAdd = input.nextInt();

                    list.addToStock(componentNumber, numToAdd);
                    break;

                // Delete component
                case "D" :
                    componentNumber = input.nextInt();
                    list.deleteComponent(componentNumber);
                    break;

                // Insert component
                case "I" :
                    componentNumber = input.nextInt();
                    description = (input.next() + " " + input.next()).trim();
                    inStock = input.nextInt();
                    reorderLevel = input.nextInt();

                    list.insertComponent(componentNumber, description, inStock, reorderLevel);
                    break;

                // Print inventory
                case "P" :
                    list.traverse();
                    System.out.println();
                    break;

                // Exit program
                case "Q" :
                    System.exit(0);
                    break;
            }
        }
    }

}
