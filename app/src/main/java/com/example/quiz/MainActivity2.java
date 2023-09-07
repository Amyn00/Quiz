package com.example.quiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.*;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    private DatabaseReference mDatabase;
    private RecyclerView mRecyclerView;
    private QuizAdapter mAdapter;
    private List<Question> qstList = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("question");

        // Initialisez le RecyclerView
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new QuizAdapter(qstList);
        mRecyclerView.setAdapter(mAdapter);

        // Ajoutez un ValueEventListener pour récupérer les données
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Cette méthode est appelée lorsque les données changent dans la base de données

                /*for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    // Parcourez les enfants (utilisateurs) de la base de données
                    String ctn = snapshot.child("contenu").getValue(String.class);
                    String f = snapshot.child("filiere").getValue(String.class);

                    // Faites quelque chose avec les données, par exemple, affichez-les dans le logcat
                    Log.d("FirebaseData", "contenu: " + ctn + ", filiere: " + f);
                }*/
                qstList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Question qst = snapshot.getValue(Question.class);
                    if (qst != null) {
                        qstList.add(qst);
                    }
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Gérez les erreurs ici en cas d'échec de la récupération des données
                Log.e("FirebaseData", "Erreur : " + databaseError.getMessage());
            }
        });

    }

}