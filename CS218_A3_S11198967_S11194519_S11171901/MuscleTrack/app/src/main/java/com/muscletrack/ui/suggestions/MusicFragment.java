package com.muscletrack.ui.suggestions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.muscletrack.R;
import com.muscletrack.databinding.FragmentMusicBinding;

import java.util.ArrayList;


public class MusicFragment extends Fragment {

    private ArrayList<Music> my_main_arraylist;
    private MusicAdapter mymusicadapter;
    private ListView songs;

    private FragmentMusicBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentMusicBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        songs = view.findViewById(R.id.listview_songs);
        my_main_arraylist=new ArrayList();
        my_main_arraylist.add(new Music("song1",R.raw.song1));
        my_main_arraylist.add(new Music("song2",R.raw.song2));
        my_main_arraylist.add(new Music("song3",R.raw.song3));
        MusicAdapter adapter=new MusicAdapter(getContext(), R.layout.songs_item_listview,my_main_arraylist);
        songs.setAdapter(adapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}