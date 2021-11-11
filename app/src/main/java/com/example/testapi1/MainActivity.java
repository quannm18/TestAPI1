package com.example.testapi1;

import static com.android.volley.VolleyLog.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.testapi1.Adapter.MusicAdapter;
import com.example.testapi1.Model.Artist.Singer;
import com.example.testapi1.Model.Music.Item;
import com.example.testapi1.Model.Music.MusicRelation;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Singer singer;
    private Item item;
    private MusicRelation musicRelation;
    private List<Item> itemList;
    private RecyclerView rcvItems;
    private MediaPlayer mediaPlayer;
    private int i;
    private MusicAdapter musicAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i = -1;
        itemList = new ArrayList<>();
        rcvItems =  findViewById(R.id.rcvItems);
        getData();

        musicAdapter = new MusicAdapter(itemList);
        rcvItems.setAdapter(musicAdapter);
        rcvItems.setLayoutManager(new LinearLayoutManager(MainActivity.this));
    }
    void getData(){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String url ="https://mp3.zing.vn/xhr/recommend?type=audio&id=ZWA7ODCU";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject data = response.getJSONObject("data");
                            JSONArray items = data.getJSONArray("items");
                            for (int i = 0; i < items.length(); i++) {
                                JSONObject obOfItems = (JSONObject) items.get(i);
                                String id = obOfItems.getString("id");
                                String name = obOfItems.getString("name");
                                String code = obOfItems.getString("code");
//                                String playlist_id = obOfItems.getString("playlist_id");
                                singer = new Singer();
                                JSONArray artists = obOfItems.getJSONArray("artists");
                                if (artists.length()>0){
                                    for (int j = 0; j < artists.length(); j++) {
                                        JSONObject obSinger = artists.getJSONObject(j);

                                        String nameSinger = obSinger.getString("name");
                                        String linkSing = obSinger.getString("link");
                                        singer.setName(nameSinger);
                                        singer.setLink(linkSing);
                                    }

                                }
                                String link = obOfItems.getString("link");
                                String artists_names = obOfItems.getString("artists_names");
                                String performer = obOfItems.getString("performer");
                                String thumbnail = obOfItems.getString("thumbnail");
                                int duration = Integer.parseInt(obOfItems.getString("duration"));
                                Item item = new Item(id,name,code,"playlist_id",singer,artists_names,performer,link,thumbnail,duration);
                                itemList.add(item);
                                musicAdapter.notifyDataSetChanged();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this, "Loi"+error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        requestQueue.add(jsonObjectRequest);
    }

}