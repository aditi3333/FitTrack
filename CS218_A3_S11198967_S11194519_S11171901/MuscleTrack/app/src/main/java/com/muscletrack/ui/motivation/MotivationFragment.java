package com.muscletrack.ui.motivation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.muscletrack.R;
import com.muscletrack.databinding.FragmentMotivationBinding;

public class MotivationFragment extends Fragment {

    private FragmentMotivationBinding binding;

    RecyclerView.Adapter programAdapter;
    RecyclerView.LayoutManager layoutmanager;
    private RecyclerView recyclerView;



    int[] images = {R.drawable.arnold1, R.drawable.cbum1, R.drawable.jeff_seid1, R.drawable.zyzz1};


    public View onCreateView( LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentMotivationBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.gymPics);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        ProgramAdapter programAdapter = new ProgramAdapter(getContext(), images);
        recyclerView.setAdapter(programAdapter);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}