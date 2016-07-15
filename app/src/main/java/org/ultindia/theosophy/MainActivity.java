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

        readQuotes();
        //readQuotesCsv();
    }

    private void readQuotes() {
        QuotesDBHelper db = new QuotesDBHelper(this);

        //Quote.AUTHORS names = null;

        //Log.i("DB", "Starting operation");
        //db.addQuote(new Quote(names.HPB.name(), "Dedicated to the Few."));
        //db.addQuote(new Quote(names.WQJ.name(), "Monad is the vivifying agent."));
        //db.addQuote(new Quote(names.RC.name(), "Theosophy is for those who want it."));

        Log.d("DB ", "Reading all quotes..");
        List<Quote> allQuotes = db.getAllQuotes();

        for (Quote q : allQuotes) {
            String log = "Id: " + q.getId() + " ,Author: " + q.getAuthor() + " ,Quote: " + q.getQuote();
            Log.i("DB", log);
        }
    }

    private void readQuotesCsv() {
/*

        CSVReader reader = new CSVReader(new FileReader(getResources().openRawResource(R.raw.quotes)));
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            // nextLine[] is an array of values from the line
            System.out.println(nextLine[0] + nextLine[1] + "etc...");
        }
*/
/*
        InputStream inputStream = getResources().openRawResource(R.raw.quotes);

        CSVFile csvFile = new CSVFile(inputStream);
        List<String[]> quotesList = csvFile.read();

        for (String[] q : quotesList) {
            for (String qq : q) {
                System.out.println("QUOTE: " + qq);
            }
            System.out.println("---------------");
        }
    */
    }
}
