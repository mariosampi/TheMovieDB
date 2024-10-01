package com.svalero.themoviedb_001;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.svalero.themoviedb_001.json_mapper.Movie;
import com.svalero.themoviedb_001.json_mapper.MovieResponse;
import com.svalero.themoviedb_001.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String API_KEY = "a4baafc5fd87ddc79d6c8548a8559b9d";  // Reemplaza con tu API key real


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGetPopular = findViewById(R.id.btnGetPopular);

        btnGetPopular.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Call<MovieResponse> call = RetrofitClient.getInstance().getPopularMovies();
                call.enqueue(new Callback<MovieResponse>() {
                    @Override
                    public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                        if (response.isSuccessful()) {
                            List<Movie> movies = response.body().getResults();
                            // Procesa y muestra las películas aquí
                            for (Movie myMovie:movies
                            ) {
                                Toast.makeText(MainActivity.this, "Movie:" + myMovie.getTitle(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieResponse> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Error al obtener las películas", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        EditText textSearch = findViewById(R.id.textSearch);
        Button btnSearch = findViewById(R.id.btnSearch);

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String query = textSearch.getText().toString();

                // Realiza la llamada a la API cuando se hace clic en el botón de búsqueda
                Call<MovieResponse> call = RetrofitClient.getInstance().searchMovies(API_KEY);
                call.enqueue(new Callback<MovieResponse>() {
                    @Override
                    public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                        if (response.isSuccessful()) {
                            List<Movie> movies = response.body().getResults();
                            // Procesa y muestra las películas aquí
                            for (Movie myMovie : movies) {
                                Toast.makeText(MainActivity.this, "Movie: " + myMovie.getTitle(), Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "No se encontraron resultados", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<MovieResponse> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Error al buscar películas", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}