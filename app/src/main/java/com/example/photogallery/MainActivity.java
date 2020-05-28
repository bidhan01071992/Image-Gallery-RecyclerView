package com.example.photogallery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.widget.SearchView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements GalleryAdapter.OnPhotoClickListener {

    List<Resource> imageList;
    GalleryAdapter galleryAdapter;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView)findViewById(R.id.galleryRecyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(),2);

        recyclerView.setLayoutManager(layoutManager);

        imageList = new ArrayList<>();
        Resource resource1 = new Resource(R.drawable.first, "First Image");
        Resource resource2 = new Resource(R.drawable.second, "Second Image");
        Resource resource3 = new Resource(R.drawable.third, "Third Image");
        Resource resource4 = new Resource(R.drawable.fourth, "Fourth Image");
        Resource resource5 = new Resource(R.drawable.fifth, "Fifth Image");
        Resource resource6 = new Resource(R.drawable.sixth, "Sixth Image");
        Resource resource7 = new Resource(R.drawable.seventh, "Seventh Image");
        Resource resource8 = new Resource(R.drawable.eigtth, "Eight Image");
        Resource resource9 = new Resource(R.drawable.ninth, "Nine Image");
        Resource resource10 = new Resource(R.drawable.tenth, "Ten Image");

        imageList.add(resource1);
        imageList.add(resource2);
        imageList.add(resource3);
        imageList.add(resource4);
        imageList.add(resource5);
        imageList.add(resource6);
        imageList.add(resource7);
        imageList.add(resource8);
        imageList.add(resource9);
        imageList.add(resource10);

        galleryAdapter = new GalleryAdapter(imageList,getApplicationContext(), this);
        recyclerView.setAdapter(galleryAdapter);

        SearchView searchView = findViewById(R.id.imageSearch);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.i("query",query);
                filterWithString(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Log.i("newText", newText);
                filterWithString(newText);
                return false;
            }
        });
    }

    private void filterWithString(String filterString) {
        List<Resource> filterList = new ArrayList<>();
        for (Resource resource : imageList) {
            if(resource.getTitle().toLowerCase().contains(filterString.toLowerCase())) {
                for (Resource item : filterList) {
                    if(item.getTitle() == resource.getTitle()) {
                        break;
                    }
                }
                filterList.add(resource);
            }
        }
        galleryAdapter.setDataToAdapter(filterList);
        recyclerView.setAdapter(galleryAdapter);
    }

    @Override
    public void onPhotoClick(int position) {
        Intent intent = new Intent(getApplicationContext(),DetailsActivity.class);
        intent.putExtra("Image",  imageList.get(position));
        startActivity(intent);
    }
}
