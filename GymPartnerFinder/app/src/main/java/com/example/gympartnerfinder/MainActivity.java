package com.example.gympartnerfinder;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nabinbhandari.android.permissions.PermissionHandler;
import com.nabinbhandari.android.permissions.Permissions;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private DatabaseReference databaseReference;


    private RecyclerView recyclerView;
    ArrayList<UserModal> userModals;

    MyAdapter myAdapter;
    private ImageView filter,closeBtn;
    private RelativeLayout layoyutFilter;
    private EditText radius;
    private Spinner gender,availability;
    private Button search;
    String Gender="";
    String Availability="";



    private GoogleMap mMap;
    private FusedLocationProviderClient fusedLocationClient;
    private Location currentLocation;

    private Double CurrentLati;
    private Double CurrentLongi;

    private CheckBox selectRadiusCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radius = findViewById(R.id.radius);
        gender = findViewById(R.id.gender);
        availability = findViewById(R.id.availability);
        search = findViewById(R.id.search);
        selectRadiusCheck = findViewById(R.id.selectRadiusCheck);


        String[] permissions = {Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION};
        Permissions.check(this/*context*/, permissions, null/*rationale*/, null/*options*/, new PermissionHandler() {
            @Override
            public void onGranted() {
initMap();

            }
        });



        availability.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position>0)
                {
                    Availability = availability.getSelectedItem().toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position>0)
                {
                    Gender = gender.getSelectedItem().toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");


        layoyutFilter = findViewById(R.id.layoyutFilter);
        filter = findViewById(R.id.filters);
        closeBtn = findViewById(R.id.closeBtn);

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoyutFilter.setVisibility(View.VISIBLE);
            }
        });
        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoyutFilter.setVisibility(View.GONE);
            }
        });




        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


        userModals = new ArrayList<>();

        myAdapter=new MyAdapter(this,this,userModals);
        recyclerView.setAdapter(myAdapter);

        getDAta();




        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Radius = radius.getText().toString();
                if(Radius.isEmpty() && selectRadiusCheck.isChecked())
                {
                    radius.setError("Please Enter redius");
                    return;
                }
                if(Gender=="")
                {
                    Toast.makeText(MainActivity.this, "Please Select Gender", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(Availability=="")
                {
                    Toast.makeText(MainActivity.this, "Please select availability", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(selectRadiusCheck.isChecked())
                {


                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            userModals.clear();
                            for(DataSnapshot dataSnapshot:snapshot.getChildren())
                            {


                                    double lat1=CurrentLati;
                                    double lon1=CurrentLongi;
                                    double lat2=Double.parseDouble(dataSnapshot.child("lat").getValue().toString());
                                    double lon2=Double.parseDouble(dataSnapshot.child("longi").getValue().toString());

                                    double theta = lon1-lon2;
                                    double dist = Math.sin(deg2rad(lat1))
                                            * Math.sin(deg2rad(lat2))
                                            + Math.cos(deg2rad(lat1))
                                            * Math.cos(deg2rad(lat2))
                                            * Math.cos(deg2rad(theta));
                                    dist = Math.acos(dist);
                                    dist = rad2deg(dist);
                                    dist = dist * 60 * 1.1515;
                                    Log.d("distance",""+Integer.parseInt(Radius));
                                    if(dist<Integer.parseInt(Radius))
                                    {
                                        if(Gender.equals("Both") && Availability.equals("Both"))
                                        {
                                            String Name = dataSnapshot.child("Name").getValue().toString();
                                            String Email = dataSnapshot.child("Email").getValue().toString();
                                            String image = dataSnapshot.child("image").getValue().toString();

                                            UserModal userModal= new UserModal();

                                            userModal.setName(Name);
                                            userModal.setEmail(Email);
                                            userModal.setImage(image);
                                            userModals.add(userModal);
                                        }
                                        if(!Gender.equals("Both") && Availability.equals("Both"))
                                        {
                                            if(dataSnapshot.child("Gender").getValue().equals(Gender))
                                            {
                                                String Name = dataSnapshot.child("Name").getValue().toString();
                                                String Email = dataSnapshot.child("Email").getValue().toString();
                                                String image = dataSnapshot.child("image").getValue().toString();

                                                UserModal userModal= new UserModal();

                                                userModal.setName(Name);
                                                userModal.setEmail(Email);
                                                userModal.setImage(image);
                                                userModals.add(userModal);
                                            }
                                        }
                                        if(Gender.equals("Both") && !Availability.equals("Both"))
                                        {
                                            if(dataSnapshot.child("available").getValue().equals(Availability))
                                            {
                                                String Name = dataSnapshot.child("Name").getValue().toString();
                                                String Email = dataSnapshot.child("Email").getValue().toString();
                                                String image = dataSnapshot.child("image").getValue().toString();

                                                UserModal userModal= new UserModal();

                                                userModal.setName(Name);
                                                userModal.setEmail(Email);
                                                userModal.setImage(image);
                                                userModals.add(userModal);
                                            }
                                        }
                                        if(!Gender.equals("Both") && !Availability.equals("Both"))
                                        {
                                            if(dataSnapshot.child("Gender").getValue().equals(Gender) && dataSnapshot.child("available").getValue().equals(Availability))
                                            {
                                                String Name = dataSnapshot.child("Name").getValue().toString();
                                                String Email = dataSnapshot.child("Email").getValue().toString();
                                                String image = dataSnapshot.child("image").getValue().toString();

                                                UserModal userModal= new UserModal();

                                                userModal.setName(Name);
                                                userModal.setEmail(Email);
                                                userModal.setImage(image);
                                                userModals.add(userModal);
                                            }
                                        }
                                    }

                            }
                            myAdapter.notifyDataSetChanged();
                            hideKeyboard(MainActivity.this);
                            layoyutFilter.setVisibility(View.GONE);


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });


                    return;
                }
                if(!selectRadiusCheck.isChecked())
                {
                    databaseReference.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            userModals.clear();
                            for(DataSnapshot dataSnapshot:snapshot.getChildren())
                            {
                                if(Gender.equals("Both") && Availability.equals("Both"))
                                {
                                    String Name = dataSnapshot.child("Name").getValue().toString();
                                    String Email = dataSnapshot.child("Email").getValue().toString();
                                    String image = dataSnapshot.child("image").getValue().toString();

                                    UserModal userModal= new UserModal();

                                    userModal.setName(Name);
                                    userModal.setEmail(Email);
                                    userModal.setImage(image);
                                    userModals.add(userModal);
                                }
                                if(!Gender.equals("Both") && Availability.equals("Both"))
                                {
                                    if(dataSnapshot.child("Gender").getValue().equals(Gender))
                                    {
                                        String Name = dataSnapshot.child("Name").getValue().toString();
                                        String Email = dataSnapshot.child("Email").getValue().toString();
                                        String image = dataSnapshot.child("image").getValue().toString();

                                        UserModal userModal= new UserModal();

                                        userModal.setName(Name);
                                        userModal.setEmail(Email);
                                        userModal.setImage(image);
                                        userModals.add(userModal);
                                    }
                                }
                                if(Gender.equals("Both") && !Availability.equals("Both"))
                                {
                                    if(dataSnapshot.child("available").getValue().equals(Availability))
                                    {
                                        String Name = dataSnapshot.child("Name").getValue().toString();
                                        String Email = dataSnapshot.child("Email").getValue().toString();
                                        String image = dataSnapshot.child("image").getValue().toString();

                                        UserModal userModal= new UserModal();

                                        userModal.setName(Name);
                                        userModal.setEmail(Email);
                                        userModal.setImage(image);
                                        userModals.add(userModal);
                                    }
                                }
                                if(!Gender.equals("Both") && !Availability.equals("Both"))
                                {
                                    if(dataSnapshot.child("Gender").getValue().equals(Gender) && dataSnapshot.child("available").getValue().equals(Availability))
                                    {
                                        String Name = dataSnapshot.child("Name").getValue().toString();
                                        String Email = dataSnapshot.child("Email").getValue().toString();
                                        String image = dataSnapshot.child("image").getValue().toString();

                                        UserModal userModal= new UserModal();

                                        userModal.setName(Name);
                                        userModal.setEmail(Email);
                                        userModal.setImage(image);
                                        userModals.add(userModal);
                                    }
                                }




                            }
                            myAdapter.notifyDataSetChanged();
                            hideKeyboard(MainActivity.this);
                            layoyutFilter.setVisibility(View.GONE);


                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });



//        map

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(MainActivity.this);
        findViewById(R.id.reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Reset", Toast.LENGTH_SHORT).show();
                getDAta();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        initMap();
    }

    public void initMap() {
        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION},101);
            return;
        }//getting location permission
        Task<Location> task = fusedLocationClient.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location !=null){
                    currentLocation = location;
                    CurrentLati = currentLocation.getLatitude();
                    CurrentLongi = currentLocation.getLongitude();
                }else {
                    Toast.makeText(MainActivity.this, "Failed to get your location", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {



        mMap = googleMap;
        LatLng latLng = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());

        Log.d("Locations",""+latLng.latitude);
        Log.d("Locations",""+latLng.longitude);




    }


    public void getDAta()
    {
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                userModals.clear();
                for(DataSnapshot dataSnapshot:snapshot.getChildren())
                {
                    String Name = dataSnapshot.child("Name").getValue().toString();
                    String Email = dataSnapshot.child("Email").getValue().toString();
                    String image = dataSnapshot.child("image").getValue().toString();

                    UserModal userModal= new UserModal();

                    userModal.setName(Name);
                    userModal.setEmail(Email);
                    userModal.setImage(image);
                    userModals.add(userModal);
                }
                myAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }




    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
        ArrayList<UserModal> data;
        Context context;
        Activity activity;
        String TAG;
        public class MyViewHolder extends RecyclerView.ViewHolder  {

            private ImageView image;
            private TextView name,email;
            public MyViewHolder(View view) {
                super(view);

                image = view.findViewById(R.id.userImage);
                name = view.findViewById(R.id.name);
                email = view.findViewById(R.id.email);
            }
        }
        public MyAdapter(Context c, Activity a , ArrayList<UserModal> cartModelss){
            this.data =cartModelss;
            context=c;
            activity=a;
            TAG="***Adapter";
        }
        @Override
        public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.user_detal_adapter, parent, false);
            return new MyAdapter.MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(final MyAdapter.MyViewHolder viewHolder, final int position) {
            UserModal userModal = data.get(position);

            Glide
                    .with(context)
                    .load(userModal.getImage())
                    .centerCrop()
                    .into(viewHolder.image);

            viewHolder.name.setText(userModal.getName());
            viewHolder.email.setText(userModal.getEmail());
        }
        @Override
        public int getItemCount() {
//        return  5;
            return data.size();
        }

        public void setFilter(ArrayList<UserModal> newList){
            data=new ArrayList<>();
            data.addAll(newList);
            notifyDataSetChanged();
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
    }


    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }


    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }



}