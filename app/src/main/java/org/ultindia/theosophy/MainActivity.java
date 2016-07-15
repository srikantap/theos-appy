package org.ultindia.theosophy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createQuotesDb();
    }

    private void createQuotesDb() {
        DBHelper db = new DBHelper(this);

        Quote.AUTHORS names = null;

        Log.i("DB", "Starting operation");
        db.addQuote(new Quote(names.HPB.name(), "Dedicated to the Few."));
        db.addQuote(new Quote(names.WQJ.name(), "Monad is the vivifying agent."));
        db.addQuote(new Quote(names.RC.name(), "Theosophy is for those who want it."));

        Log.d("DB ", "Reading all quotes..");
        List<Quote> allQuotes = db.getAllQuotes();

        for (Quote q : allQuotes) {
            String log = "Id: "+q.getId()+" ,Author: " + q.getAuthor() + " ,Quote: " + q.getQuote();
            Log.i("DB", log);
        }

    }
}
