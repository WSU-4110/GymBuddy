package src.database;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class firebaseDatabase {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myref = database.getReference("message");
}
