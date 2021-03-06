package com.project.bgt.repository;

import com.project.bgt.model.Component;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentRepository extends JpaRepository<Component, Long> {

  List<Component> findAllByLanguageId(long languageId);

  @Query(
    value = "select \n"
      + "\tc.*\n"
      + "from component c\n"
      + "inner join game_component gc\n"
      + "\ton c.id = gc.component_id\n"
      + "where gc.game_id = :gameId",
    nativeQuery = true)
  List<Component> findAllByGameId(@Param("gameId") long gameId);

  @Query(
    value = "select \n"
      + "\tct.* \n"
      + "from component c \n"
      + "inner join component_relationship cr \n"
      + "\ton c.id = cr.original_component_id\n"
      + "inner join component ct \n"
      + "\ton cr.translated_component_id = ct.id \n"
      + "where c.id = :componentId\n"
      + "union\n"
      + "select\n"
      + "\tc.*\n"
      + "from component c\n"
      + "where c.id = :componentId",
    nativeQuery = true
  )
  List<Component> findAllComponentTranslationsByOriginalComponentId(@Param("componentId") long componentId);
}
