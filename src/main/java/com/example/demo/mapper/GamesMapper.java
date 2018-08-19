package com.example.demo.mapper;

import com.example.demo.domain.Games;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository()
public interface GamesMapper {

    @Select("SELECT id, game_container as gameContainer FROM GSS_games LIMIT 1")
    Games getGame();

}
