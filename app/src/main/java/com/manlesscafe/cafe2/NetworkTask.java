package com.manlesscafe.cafe2;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class NetworkTask extends AsyncTask<Void, Void, String> {

    private final String url;
    private final ContentValues valuse;
    private final Handler receiveHandler;

    public NetworkTask(String url, ContentValues valuse, Handler receiveHandler){
        this.url = url;
        this.valuse = valuse;
        this.receiveHandler = receiveHandler;
    }

        @Override
        protected String doInBackground(Void... params) {

        //Log.d("URL : " + url);

        String result;
        RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
        result = requestHttpURLConnection.request(url, valuse);

        return result;
        }


        @Override
        protected void onPostExecute(String s)  {
        super.onPostExecute(s);

        try{
            Log.d("onPostExecute :" , s);
            //Message msg = receiveHandler.obtainMessage(SEND_WEB_RETURN);
            Bundle data = new Bundle();
            data.putString("WEB_RETURN", s);
            //msg.setData(data);
            //receiveHandler.sendMessage(msg);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        }
    }


