package com.space.working.my.myworkingspace.module.home;

public class SingletonClass {

  public static SingletonClass singletonClass;

  private SingletonClass() {
  }

  static {
    try {
      singletonClass = new SingletonClass();
    }catch (Exception e){
      throw  new RuntimeException("Unhandlled exceoption!");
    }

  }

  public static SingletonClass getSingleton() {
    if (singletonClass == null) {
      try {
        singletonClass = new SingletonClass();
      }catch (Exception e){
        throw  new RuntimeException("Unhandlled exceoption!");
      }
    }
    return singletonClass;
  }
}
