package com.ada.ecommerce.exception;

public class EmailAlreadyTaken extends RuntimeException{
  public final static String MESSAGE_ERROR = "Email %s already taken";

  public EmailAlreadyTaken(String email ) {
    super(String.format(MESSAGE_ERROR, email));
  }
}
