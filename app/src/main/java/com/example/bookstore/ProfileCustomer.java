package com.example.bookstore;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.bookstore.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ProfileCustomer extends AppCompatActivity {

    private EditText ufirstname,ulastname,uphno,uaddress;
    private String semail,sfirstname,slastname,sphno,saddress,userid;
    ProgressBar uProgress;
    //Firebase
    private FirebaseAuth fAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    final FirebaseFirestore db = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_customer);

        ufirstname = findViewById(R.id.ufirstname);
        ulastname = findViewById(R.id.ulastname);
        uphno = findViewById(R.id.uphno);
        uaddress = findViewById(R.id.uaddress);
        Button updateButton = findViewById(R.id.updateButton);
        uProgress = findViewById(R.id.uProgress);

        fAuth = FirebaseAuth.getInstance();
        userid = Objects.requireNonNull(fAuth.getCurrentUser()).getUid();
        DocumentReference typeref = db.collection("Users").document(userid);
        typeref.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if (documentSnapshot.exists()) {
                    semail=documentSnapshot.getString("email");
                    sfirstname=documentSnapshot.getString("firstname");
                    slastname=documentSnapshot.getString("lastname");
                    sphno=documentSnapshot.getString("phno");
                    saddress=documentSnapshot.getString("address");

                    ufirstname.setText(sfirstname);
                    ulastname.setText(slastname);
                    uphno.setText(sphno);
                    uaddress.setText(saddress);
                }
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String updatefn= ufirstname.getText().toString().trim();
                String updateln= ulastname.getText().toString().trim();
                String updatephno= uphno.getText().toString().trim();
                String updateadd= uaddress.getText().toString().trim();

                if(TextUtils.isEmpty(updatefn) ){
                    Toast.makeText(getApplicationContext(),"Enter a first name to update",Toast.LENGTH_LONG).show();
                    return;
                }
                else if(TextUtils.isEmpty(updateln)){
                    Toast.makeText(getApplicationContext(),"Enter a last name to update",Toast.LENGTH_LONG).show();
                    return;
                }
                else if(TextUtils.isEmpty(updatephno)){
                    Toast.makeText(getApplicationContext(),"Enter phone number to update",Toast.LENGTH_LONG).show();
                    return;
                }
                else if(TextUtils.isEmpty(updateadd)){
                    Toast.makeText(getApplicationContext(),"Enter address to update",Toast.LENGTH_LONG).show();
                    return;
                }
            }
        });
    }

    private void UpdateAccountInfo(final String updatefn, final String updateln, final String updatephno, final String updateadd, String updatepc,String semail)
    {
        uProgress.setVisibility(View.VISIBLE);
        fAuth = FirebaseAuth.getInstance();
        final FirebaseFirestore db = FirebaseFirestore.getInstance();
        userid = Objects.requireNonNull(fAuth.getCurrentUser()).getUid();
        Map<String, Object> user = new HashMap<>();
        user.put("firstname", updatefn);
        user.put("lastname", updateln);
        user.put("phno", updatephno);
        user.put("address", updateadd);
        user.put("email", semail);
        user.put("usertype", "Customer");

        db.collection("Users").document(userid).set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()) {
                    uProgress.setVisibility(View.INVISIBLE);
                    Toast.makeText(ProfileCustomer.this,"Information updated successfully", Toast.LENGTH_LONG).show();

                } else{
                    uProgress.setVisibility(View.INVISIBLE);
                    String errorMessage = Objects.requireNonNull(task.getException()).getMessage();
                    Toast.makeText(ProfileCustomer.this, "Error: " + errorMessage, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
