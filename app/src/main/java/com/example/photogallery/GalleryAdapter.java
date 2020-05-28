package com.example.photogallery;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {

    List<Resource> resourceList;
    Context context;
    OnPhotoClickListener onPhotoClickListener;

    public GalleryAdapter(List<Resource> resourceList, Context context, OnPhotoClickListener onPhotoClickListener) {
        this.resourceList = resourceList;
        this.context = context;
        this.onPhotoClickListener = onPhotoClickListener;
    }

    @NonNull
    @Override
    public GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View photoView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);

        return new GalleryViewHolder(photoView, onPhotoClickListener);
    }

    @Override
    public int getItemCount() {
        return this.resourceList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryViewHolder holder, int position) {
        holder.galleryImageView.setImageResource(resourceList.get(position).getGalleryImageId());
        holder.galleryImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        holder.galleryImageTitle.setText(resourceList.get(position).getTitle());
    }

    class GalleryViewHolder extends RecyclerView.ViewHolder {


        ImageView galleryImageView;
        TextView galleryImageTitle;
        OnPhotoClickListener onPhotoClickListener;
        public GalleryViewHolder(@NonNull View itemView, final OnPhotoClickListener onPhotoClickListener) {
            super(itemView);
            galleryImageTitle = (TextView) itemView.findViewById(R.id.imageText);
            galleryImageView = (ImageView) itemView.findViewById(R.id.photoImage);
            this.onPhotoClickListener = onPhotoClickListener;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onPhotoClickListener.onPhotoClick(getAdapterPosition());
                }
            });
        }



    }

    public interface OnPhotoClickListener {
        void onPhotoClick(int position);
    }
}
