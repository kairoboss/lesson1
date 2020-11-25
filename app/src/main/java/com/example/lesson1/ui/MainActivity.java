package com.example.lesson1.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.lesson1.R;
import com.example.lesson1.data.Card;

public class MainActivity extends AppCompatActivity implements EmojiGameAdapter.CardCallback {

    private RecyclerView emojiRecycler;
    private EmojiGameAdapter emojiGameAdapter;
    private EmojiGame emojiGame;
    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emojiRecycler = findViewById(R.id.rv_cards);
        emojiGame = new EmojiGame();
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        emojiRecycler.setLayoutManager(mLayoutManager);
        emojiGameAdapter = new EmojiGameAdapter(emojiGame, this);
        emojiRecycler.setAdapter(emojiGameAdapter);
    }

    @Override
    public void choose(Card<String> card) {
        emojiGame.choose(card);
        emojiGameAdapter.notifyDataSetChanged();
    }
}