package com.example.kosta.beautymateandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.kosta.beautymateandroid.domain.Cosmetic;
import com.example.kosta.beautymateandroid.service.CosmeticService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CosmeticActivity extends AppCompatActivity {

    private CosmeticAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cosmetic);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:8888/rest/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final Spinner cosmeticCategorySpinner = (Spinner) findViewById(R.id.cosmeticCategory);
        ArrayAdapter categoryAdapter = ArrayAdapter.createFromResource(this, R.array.cosmetic_category, android.R.layout.simple_spinner_item);
        cosmeticCategorySpinner.setAdapter(categoryAdapter);

        final CosmeticService service = retrofit.create(CosmeticService.class);

        cosmeticCategorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (parent.getItemAtPosition(position).toString().equals("All")) {

                    try {
                        final Call<List<Cosmetic>> all = (Call<List<Cosmetic>>) service.listcosmetic();

                        Log.d("test", "start");

                        all.enqueue(new Callback<List<Cosmetic>>() {
                            @Override
                            public void onResponse(Call<List<Cosmetic>> call, Response<List<Cosmetic>> response) {
                                int statusCode = response.code();
                                List<Cosmetic> all = response.body();

                                Log.d("r", all.size() + "개");

                                for (Cosmetic r : all) {
                                    Log.d("id", String.valueOf(r.getCosmeticNo()));
                                    Log.d("2", r.getCosmeticName());
                                    Log.d("3", String.valueOf(r.getCost()));
                                    if (r.getImg() == null)
                                        Log.d("4", "");
                                    else {
                                        Log.d("4", r.getImg());
                                    }
                                }
                                setCategory(all);
                            }

                            @Override
                            public void onFailure(Call<List<Cosmetic>> call, Throwable t) {
                                Log.d("test", "실패");
                            }
                        });
                    } catch (Exception e) {
                        Log.d("test", e.getMessage());

                    }
                } else {
                    try {
                        final Call<List<Cosmetic>> category = (Call<List<Cosmetic>>) service.category(parent.getItemAtPosition(position).toString());

                        Log.d("test", "start");

                        category.enqueue(new Callback<List<Cosmetic>>() {
                            @Override
                            public void onResponse(Call<List<Cosmetic>> call, Response<List<Cosmetic>> response) {
                                int statusCode = response.code();
                                List<Cosmetic> category = response.body();
                                Log.d("test", String.valueOf(category.size()));
                                setCategory(category);
                            }

                            @Override
                            public void onFailure(Call<List<Cosmetic>> call, Throwable t) {
                                Log.d("test", "실패");
                            }
                        });
                    } catch (Exception e) {
                        Log.d("test", e.getMessage());

                    }

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void setCategory(final List<Cosmetic> list) {
        final ListView listView = (ListView) findViewById(R.id.list);
        adapter = new CosmeticAdapter(getApplicationContext(), list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CosmeticActivity.this, CosmeticDetailActivity.class);
                intent.putExtra("cosmeticNo",list.get(position).getCosmeticNo());
                startActivity(intent);

            }
        });

    }
}
