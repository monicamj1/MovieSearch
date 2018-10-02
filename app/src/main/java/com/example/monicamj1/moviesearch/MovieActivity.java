package com.example.monicamj1.moviesearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MovieActivity extends AppCompatActivity {

    //model
    private Movie movie;

    //referencia a objetos de la pantalla
    private TextView title_view;
    private TextView year_view;
    private TextView rating_view;
    private TextView duration_view;
    private TextView genre_view;
    private TextView description_view;
    private TextView director_view;
    private TextView writer_view;
    private TextView actors_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);

        try {
            InputStream stream = getAssets().open("lord.json");
            InputStreamReader reader = new InputStreamReader(stream);
            Gson gson = new Gson();
            movie = gson.fromJson(reader, Movie.class);
        } catch (IOException e) {
            Toast.makeText(this, "No se ha podido leer el fichero", Toast.LENGTH_SHORT).show();
        }

        title_view = findViewById(R.id.title_view);
        year_view = findViewById(R.id.year_view);
        rating_view = findViewById(R.id.rating_view);
        duration_view = findViewById(R.id.duration_view);
        genre_view = findViewById(R.id.genre_view);
        description_view = findViewById(R.id.description_view);
        director_view = findViewById(R.id.director_view);
        writer_view = findViewById(R.id.writer_view);
        actors_view = findViewById(R.id.actors_view);

        title_view.setText(movie.getTitle());
        year_view.setText(movie.getYear());
        rating_view.setText(movie.getRated());
        duration_view.setText(movie.getRuntime());
        genre_view.setText(movie.getGenre());
        description_view.setText(movie.getPlot());
        director_view.setText(movie.getDirector());
        writer_view.setText(movie.getWriter());
        actors_view.setText(movie.getActors());
    }
}
