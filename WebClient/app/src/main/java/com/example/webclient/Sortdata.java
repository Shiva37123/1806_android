package com.example.webclient;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;

public class Sortdata extends AsyncTask <Void, Void, Void> {
    String data="";
    String formattedData="";
    String lineParsed="";
    String lastName="";
    Double salary= Double.NaN;
    public static Double totalsalary=0.0;

    @Override
    protected Void doInBackground(Void... voids) {
        try {

            URL url = new URL("https://api.jsonbin.io/b/5f98044c30aaa01ce619982d");
            HttpURLConnection httpURLConnection =(HttpURLConnection) url.openConnection();

            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String line="";
            while(line!=null){
                line = bufferedReader.readLine();
                data= data + line;
            }
            JSONArray jsonArray  = new JSONArray(data);
            ArrayList arrayList = new ArrayList();
            for(int i= 0; i<jsonArray.length();i++){
                JSONObject jsonObject = (JSONObject) jsonArray.get(i);
                arrayList.add( "Name: " + jsonObject.get("lastName") + " "+ jsonObject.get("firstName") + "\n"+
                        "Emp Code: " + jsonObject.get("empCode") + "\n" + "Salary :" + jsonObject.get("salary")+"\n");

                salary = jsonObject.getDouble("salary");
                totalsalary= totalsalary+salary;

            }
            Collections.sort(arrayList);
            for(int i=0; i<arrayList.size(); i++){
                formattedData = formattedData + arrayList.get(i) + "\n";
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        MainActivity.Dataview.setText(this.formattedData );

    }
}
