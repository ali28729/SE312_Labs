/**
 * FoodServiceImp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.sclab12.soap;

public interface FoodServiceImp extends java.rmi.Remote {
    public com.sclab12.soap.FoodItems getItem(int id) throws java.rmi.RemoteException;
    public com.sclab12.soap.FoodItems[] getAllItems() throws java.rmi.RemoteException;
    public boolean addFoodItems(com.sclab12.soap.FoodItems food) throws java.rmi.RemoteException;
    public boolean deleteFoodItems(int id) throws java.rmi.RemoteException;
}
