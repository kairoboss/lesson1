package com.example.lesson1.ui;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.lesson1.data.Card;
import com.example.lesson1.data.Game;

import java.util.List;

public class EmojiGame {

    private Game<String> game;

    @RequiresApi(api = Build.VERSION_CODES.R)
    public EmojiGame(){
        List<String> content = List.of("\uD83D\uDE0B", "\uD83D\uDC4C");
        game = new Game<>(content);
    }

    public void choose(Card<String> card){
        game.choose(card);
    }

    public List<Card<String>> getCards() {
        return game.getCards();
    }
}
