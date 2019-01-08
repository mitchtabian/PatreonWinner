package com.codingwithmitch.patreonwinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Patreon Winner";


    /**
     * HOW IT WORKS:
     * 1) totals up the number of entries. (For every $5 a person gets 1 entry)
     * 2) Chooses a random number between 0  and the total number of entries
     * 3) Loops through the people. And within that loop it loops through each entry.
     *      - While it loops, a counter is incremented (@count)
     *      - If @count equals the random number then that's the winner
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Entry[] entries = {
                new Entry("Patreon #1", 5),
                new Entry("Patreon #2", 5),
                new Entry("Patreon #3", 50),
                new Entry("Patreon #4", 5),
                new Entry("Patreon #5", 5),
                new Entry("Patreon #6", 100),
                new Entry("Patreon #7", 5),
                new Entry("Patreon #8", 25),
                new Entry("Patreon #9", 60),
                new Entry("Patreon #10", 5),

        };


        // determine the total
        int total = 0;
        for(Entry entry: entries){
            total += entry.getNumEntries();
        }
        Log.d(TAG, "total entries: " + total);

        // get the randomly chosen number
        int randomNum = getRandomIntegerBetweenRange(0, total);
        Log.d(TAG, "random number: " + randomNum);

        // determine the winner
        Entry winner = null;
        int count = 0;
        for(Entry entry: entries){
            if(winner != null){
                break;
            }
            Log.d(TAG, "---------------------------------");
            Log.d(TAG, "rolling for " + entry.getName());
            for(int i = 0; i < entry.getNumEntries(); i++){
                Log.d(TAG, "name: " + entry.getName() + ", roll #: " + i + ", count: " + count);
                if(i == entry.getNumEntries() - 1){
                    Log.d(TAG, entry.getName() + " is DONE. Entries completed: " + entry.getNumEntries());
                }
                if(count == randomNum){
                    winner = entry;
                    Log.d(TAG, "WINNER: " + winner.getName() + ", number chosen: " + count);
                    break;
                }
                count++;

            }
        }

        Log.d(TAG, "winner:" + winner.name);
    }

    public static int getRandomIntegerBetweenRange(double min, double max){
        double x = (int)(Math.random()*((max-min)+1))+min;
        return (int)x;
    }

}
