package com.muscletrack.ui.suggestions;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.muscletrack.R;

import java.util.ArrayList;

public class MusicAdapter extends BaseAdapter {
    private  Context context;
    private  int layout;
    private  ArrayList<Music> myArrayList;
    private MediaPlayer mediaPlayer;
    private boolean flag=true;

    public MusicAdapter(Context context, int layout, ArrayList<Music> myArrayList) {
        this.context = context;
        this.layout = layout;
        this.myArrayList = myArrayList;

    }

    @Override
    public int getCount() {
        return myArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return myArrayList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public class ViewHolder{
        TextView textView_songName;
        ImageView imageView_play,imageView_stop;
        private final View convertview;
        LayoutInflater layoutInflater= (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        public ViewHolder(){
            convertview=layoutInflater.inflate(layout,null);
            textView_songName=convertview.findViewById(R.id.textview_songs);
            imageView_play=convertview.findViewById(R.id.imageview_play);
            imageView_stop=convertview.findViewById(R.id.imageview_stop);

        }
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewHolder viewHolder=new ViewHolder();
        View convertView = null;
        if (convertView==null){
            convertView=viewHolder.convertview;

        }else{

        }

        int position = 0;
        final Music music=myArrayList.get(position);
        viewHolder.textView_songName.setText(music.getSongName());
        viewHolder.imageView_play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag){
                    mediaPlayer=MediaPlayer.create(context,music.getSongs());
                    flag=false;
                }
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    viewHolder.imageView_play.setImageResource(R.drawable.ic_baseline_play_circle_outline_24);
                }else{
                    mediaPlayer.start();
                    viewHolder.imageView_play.setImageResource(R.drawable.ic_baseline_pause_circle_filled_24);
                }
                mediaPlayer.start();


            }
        });
        viewHolder.imageView_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!flag){
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    flag=true;
                }
                viewHolder.imageView_stop.setImageResource(R.drawable.ic_baseline_stop_circle_24);
            }
        });
        return convertView;
    }
}
