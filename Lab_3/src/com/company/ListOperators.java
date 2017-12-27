/*
Author: Jake Edwards
Date Started: 02/20/2017
Date Finished:

Purpose: Provides insert, delete, traverse(print), and search functions to operate on linked lists.
*/

package com.company;

public class ListOperators {

    public Node head;

    public ListOperators() {
        //creates empty list object
        head = null;
    }

    //add new node to list
    public void insertComponent(int componentNumber, String description, int unitsInStock, int reorderLevel) {
        Node newNode = new Node(componentNumber, description, unitsInStock, reorderLevel);
        newNode.next = null;

        if (head == null) { //if list is empty
            head = newNode;
        }
        else { //list is not empty
            Node curr = head;
            Node prev = curr;
            while (curr.next != null) { //as long as link field of curr is not null, advance curr by one
                prev = curr;
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    //delete node from list
    public void deleteComponent(int componentNum){
        Node curr = head;
        Node prev = curr;
        boolean found = false;

        while (curr.next != null && curr.getComponentNumber() != componentNum) { //loop through while not at end of list and component numbers don't match
            prev = curr;
            curr = curr.next;
        }

        if (curr.getComponentNumber() == componentNum) {
            found = true;
        }

        if (found) {
            if (curr.next == null) { // for deleting last item in list
                prev.next = null;    // last item in list will be de-referenced and marked for garbage collection
            }
            else if (curr != head && curr.next != null) { // for deleting item in the middle of the list(excludes first and last items)
                prev.next = curr.next;
            }
            else if (curr == prev) { // for deleting first item in list
                head = curr.next;
                curr = curr.next;
                prev = curr;
            }
        }
        else {
            System.out.println("Error: item " + componentNum + " not found");
        }

    }

    // add number newUnits to the in stock amount for the given componentNum item
    public void addToStock(int componentNum, int newUnits) {
        Node curr = head;
        Node prev = curr;

        while (curr.next != null && curr.getComponentNumber() != componentNum) { //loop through while not at end of list and component numbers don't match
            prev = curr;
            curr = curr.next;
        }
        curr.setUnitsInStock(curr.getUnitsInStock() + newUnits);
    }

    // remove number newUnits from the stock amount for the given componentNum item
    public void removeFromStock(int componentNum, int removedUnits) {
        Node ref = (Node)search(componentNum);
        ref.setUnitsInStock(ref.getUnitsInStock() - removedUnits);
    }

    //print list
    public void traverse() {
        System.out.println("Component                       Current#    Reorder");
        System.out.println("Number    Description           In Stock    Level");
        System.out.println("---------------------------------------------------");
        //System.out.println("000000    Circular Queue    15          3");

        String reorder;
        Node curr = head;
        while (curr != null) {
            if (curr.isReorderFlag()) {
                reorder = " *REORDER*";
            }
            else {
                reorder = "";
            }

            System.out.println(curr.getComponentNumber() + "    " + curr.getDescription() + "\t\t" + curr.getUnitsInStock() + "\t\t\t" + curr.getReorderLevel() + reorder);
            curr = curr.next;
        }
    }

    public Object search(int componentNum) {
        Node curr = head;
        Node prev = curr;

        while (curr.next != null && curr.getComponentNumber() != componentNum) { //loop through while not at end of list and component numbers don't match
            prev = curr;
            curr = curr.next;
        }
        return curr;
    }

    //public static void listBubbleSort()

}
