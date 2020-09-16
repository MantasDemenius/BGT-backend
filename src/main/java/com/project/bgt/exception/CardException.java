package com.project.bgt.exception;

import com.project.bgt.model.Card;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class CardException {

  public static void checkCard(Card card){
    checkTitle(card);
    checkDescription(card);
    checkTitleLength(card);
    checkDescriptionLength(card);
  }

  public static void checkDescription(Card card){
    try{
      if(card.getDescription().isEmpty()){
        throw new ResponseStatusException(
          HttpStatus.BAD_REQUEST , "description cannot be empty");
      }
    }catch(NullPointerException ex){
      throw new ResponseStatusException(
        HttpStatus.BAD_REQUEST, "description is required"
      );
    }
  }

  public static void checkTitle(Card card) {
    try{
    if(card.getTitle().isEmpty()){
      throw new ResponseStatusException(
        HttpStatus.BAD_REQUEST , "title cannot be empty");
    }
  }catch(NullPointerException ex){
    throw new ResponseStatusException(
      HttpStatus.BAD_REQUEST, "title is required"
    );
  }
  }

  public static void checkDescriptionLength(Card card) {
    if(card.getDescription().length() > 500){
      throw new ResponseStatusException(
        HttpStatus.BAD_REQUEST, "description is too long"
      );
    }
  }

  public static void checkTitleLength(Card card) {
    if(card.getTitle().length() > 500){
      throw new ResponseStatusException(
        HttpStatus.BAD_REQUEST, "title is too long"
      );
    }
  }
}