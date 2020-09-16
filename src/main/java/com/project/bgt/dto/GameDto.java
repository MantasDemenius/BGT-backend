package com.project.bgt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GameDto {

  String title;
  String description;
  String languageCode;

}