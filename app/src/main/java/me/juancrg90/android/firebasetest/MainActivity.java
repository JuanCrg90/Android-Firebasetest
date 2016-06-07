package me.juancrg90.android.firebasetest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.editText)
    EditText editText;

    FirebaseDatabase database;
    DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("message");
    }

    @OnClick(R.id.button)
    public void writeToFirebase() {
        myRef.setValue(editText.getText().toString());
        editText.setText("");
    }
}
