package sample.android.com.customlistviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private SearchView searchView;
    CustomAdapter adapter;

    private int[] pictures = {R.drawable.person_one, R.drawable.person_2,
            R.drawable.person_3, R.drawable.person_4, R.drawable.person_5};

    private String[] names = {"Salman Khan", "Seikh Hasina",
            "Khaleda Zia", "Sakib Khan", "Opu Biswas"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        listView = findViewById(R.id.lvId);
        searchView = findViewById(R.id.searchViewId);

        adapter = new CustomAdapter(this,
                names, pictures);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                String title = names[i];
                Toast.makeText(MainActivity.this, "" + title, Toast.LENGTH_SHORT).show();
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                filter(s);
                return false;
            }
        });
    }

    private void filter(String newText) {
        ArrayList<String> fillterActor= new ArrayList<>();
        ArrayList<Integer> fillterPicture= new ArrayList<>();

        for(int i=0;i<names.length;i++){
            if(names[i].toLowerCase().contains(newText.toLowerCase())){
                fillterActor.add(names[i]);
                fillterPicture.add(pictures[i]);
            }
        }
        String[] title = new String[fillterActor.size()];
        int[] img = new int[fillterPicture.size()];
        for(int i=0;i<fillterActor.size();i++){
            title[i]=fillterActor.get(i);
            img[i]=fillterPicture.get(i);
        }
        adapter.filter(title,img);



    }
}
