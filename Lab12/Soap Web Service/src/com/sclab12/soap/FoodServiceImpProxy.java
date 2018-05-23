package com.sclab12.soap;

public class FoodServiceImpProxy implements com.sclab12.soap.FoodServiceImp {
  private String _endpoint = null;
  private com.sclab12.soap.FoodServiceImp foodServiceImp = null;
  
  public FoodServiceImpProxy() {
    _initFoodServiceImpProxy();
  }
  
  public FoodServiceImpProxy(String endpoint) {
    _endpoint = endpoint;
    _initFoodServiceImpProxy();
  }
  
  private void _initFoodServiceImpProxy() {
    try {
      foodServiceImp = (new com.sclab12.soap.FoodServiceImpServiceLocator()).getFoodServiceImp();
      if (foodServiceImp != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)foodServiceImp)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)foodServiceImp)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (foodServiceImp != null)
      ((javax.xml.rpc.Stub)foodServiceImp)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.sclab12.soap.FoodServiceImp getFoodServiceImp() {
    if (foodServiceImp == null)
      _initFoodServiceImpProxy();
    return foodServiceImp;
  }
  
  public com.sclab12.soap.FoodItems getItem(int id) throws java.rmi.RemoteException{
    if (foodServiceImp == null)
      _initFoodServiceImpProxy();
    return foodServiceImp.getItem(id);
  }
  
  public com.sclab12.soap.FoodItems[] getAllItems() throws java.rmi.RemoteException{
    if (foodServiceImp == null)
      _initFoodServiceImpProxy();
    return foodServiceImp.getAllItems();
  }
  
  public boolean addFoodItems(com.sclab12.soap.FoodItems food) throws java.rmi.RemoteException{
    if (foodServiceImp == null)
      _initFoodServiceImpProxy();
    return foodServiceImp.addFoodItems(food);
  }
  
  public boolean deleteFoodItems(int id) throws java.rmi.RemoteException{
    if (foodServiceImp == null)
      _initFoodServiceImpProxy();
    return foodServiceImp.deleteFoodItems(id);
  }
  
  
}