package com.nyc.sqliteinclassquestion4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.nyc.sqliteinclassquestion4.database.LaptopSightingsDatabase;
import com.nyc.sqliteinclassquestion4.models.Sightings;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * FellowsDatabaseHelper fellowsDatabaseHelper = new FellowsDatabaseHelper(getApplicationContext());

         fellowsDatabaseHelper.addFellow(new Fellow("Lin", "Lily", "Spotify"));
         fellowsDatabaseHelper.addFellow(new Fellow("Lin", "Lily", "Spotify"));
         fellowsDatabaseHelper.addFellow(new Fellow("Smith", "Jordan", "LinkedIn"));
         fellowsDatabaseHelper.addFellow(new Fellow("Li", "Rusi", "Weight Watchers"));
         fellowsDatabaseHelper.addFellow(new Fellow("Santos", "Derek", "Uber"));
         fellowsDatabaseHelper.addFellow(new Fellow("Lui", "Danny", "Max2"));

         List<Fellow> fellows = fellowsDatabaseHelper.getFellowList();

         for(Fellow f : fellows) {
         Log.d("Fellows? ", f.getFirstName() + " " + f.getLastName() + " - " + f.getCompany());
         }
         */

        LaptopSightingsDatabase database = new LaptopSightingsDatabase(getApplicationContext());
        database.addSighting("Wayne");
        database.addSighting("Muhaimmen");
        database.addSighting("Taishawn");
        database.addSighting("Anna");
        database.addSighting("Yoki");
        database.addSighting("Shantel");

        List<Sightings> sightingsList = database.getSightings();

        for (Sightings s: sightingsList) {
            Log.d("Sightings? ", s.getName() + " " + s.getEntryDateTime());
        }
    }
}
