/*
Author: Jake Edwards
Date Started: 02/20/2017
Date Finished: 03/03/2017

Purpose: Node class to be used by the ListOperators class
*/

package com.company;

public class Node {

    private int componentNumber;
    private String description;
    private int unitsInStock;
    private int reorderLevel;
    private boolean reorderFlag = false;
    Node next;

    public Node() {
        next = null;
    }

    public Node(int componentNumber, String description, int unitsInStock, int reorderLevel) {
        this.componentNumber = componentNumber;
        this.description = description;
        this.unitsInStock = unitsInStock;
        this.reorderLevel = reorderLevel;
        if (unitsInStock < reorderLevel) {
            reorderFlag = true;
        }
        this.next = null;

    }

    public int getComponentNumber() {
        return componentNumber;
    }

    public String getDescription() {
        return description;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public int getReorderLevel() {
        return reorderLevel;
    }

    public void setComponentNumber(int componentNumber) {
        this.componentNumber = componentNumber;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public void setReorderFlag(boolean reorderFlag) {
        this.reorderFlag = reorderFlag;
    }

    public boolean isReorderFlag() {
        return reorderFlag;
    }

}
