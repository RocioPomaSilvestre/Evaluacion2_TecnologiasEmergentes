package com.rocio.poma.evaluacion2_tecnologiasemergentes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //BASE DE DATOS FIRE_BASE
        FirebaseDatabase db=FirebaseDatabase.getInstance();

        //BASE DE DATOS SQLite
        final AdminBD_SQL adminBD_sql=new AdminBD_SQL(getApplicationContext());

        TextView text_question = (TextView) findViewById(R.id.text_question);
        text_question.setText("ESCRIBA AQUI LA PREGUNTA");

        RadioButton rb1= (RadioButton) findViewById(R.id.answer1);
        RadioButton rb2= (RadioButton) findViewById(R.id.answer1);
        RadioButton rb3= (RadioButton) findViewById(R.id.answer1);
        RadioButton rb4= (RadioButton) findViewById(R.id.answer1);

        RadioGroup group=findViewById(R.id.answer_group);
        Button btn_check=findViewById(R.id.btn_check);
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int id=group.getCheckedRadioButtonId();
                if (id==R.id.answer1){
                    Toast.makeText(getApplicationContext(),"Mas 1 punto OPCION A", Toast.LENGTH_SHORT).show();

                    //ALMACENADO EN LA BASE DE DATOS FB

                    DatabaseReference dbRef=db.getReference("opcion A");
                    String id1= dbRef.push().getKey();
                    Votacion vot=new Votacion(id1,"Mas 1 Votacion para A");
                    dbRef.child(id1).setValue(vot);

                    //ALMACENADO EN LA BASE DE DATOS SQLite
                    String uniqueID=UUID.randomUUID().toString();
                    //adminBD_sql.agregarVotacion(uniqueID,"Mas 1 para A","0","0","0");
                    Toast.makeText(getApplicationContext(),"Tambien se agrego a SQLite", Toast.LENGTH_SHORT).show();


                }

                if (id==R.id.answer2){
                    //ALMACENADO EN FIRE_BASE
                    DatabaseReference dbRef=db.getReference("opcion B");
                    String id1= dbRef.push().getKey();
                    Votacion vot=new Votacion(id1,"Mas 1 Votacion para B");
                    dbRef.child(id1).setValue(vot);
                    Toast.makeText(getApplicationContext(),"Mas 1 punto OPCION B FB", Toast.LENGTH_SHORT).show();

                    //ALMACENADO EN LA BASE DE DATOS SQLite
                    String uniqueID=UUID.randomUUID().toString();
                    //adminBD_sql.agregarVotacion(uniqueID,"0","Mas 1 para B","0","0");
                    Toast.makeText(getApplicationContext(),"Tambien se agrego a SQLite", Toast.LENGTH_SHORT).show();
                }
                if (id==R.id.answer3){

                    //ALMACENADO EN FIRE_BASE
                    DatabaseReference dbRef=db.getReference("opcion B");
                    String id1= dbRef.push().getKey();
                    Votacion vot=new Votacion(id1,"Mas 1 Votacion para C");
                    dbRef.child(id1).setValue(vot);
                    Toast.makeText(getApplicationContext(),"Mas 1 punto OPCION C FB", Toast.LENGTH_SHORT).show();

                    //ALMACENADO EN LA BASE DE DATOS SQLite
                    String uniqueID=UUID.randomUUID().toString();
                   // adminBD_sql.agregarVotacion(uniqueID,"0","0","Mas 1 para C","0");
                    Toast.makeText(getApplicationContext(),"Tambien se agrego a SQLite", Toast.LENGTH_SHORT).show();

                }
                if (id==R.id.answer4){

                    //ALMACENADO EN FIRE_BASE
                    DatabaseReference dbRef=db.getReference("opcion B");
                    String id1= dbRef.push().getKey();
                    Votacion vot=new Votacion(id1,"Mas 1 Votacion para D");
                    dbRef.child(id1).setValue(vot);
                    Toast.makeText(getApplicationContext(),"Mas 1 punto OPCION D FB", Toast.LENGTH_SHORT).show();

                    //ALMACENADO EN LA BASE DE DATOS SQLite
                    String uniqueID=UUID.randomUUID().toString();
                    //adminBD_sql.agregarVotacion(uniqueID,"0","0","0","Mas 1 para D");
                    Toast.makeText(getApplicationContext(),"Tambien se agrego a SQLite", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}