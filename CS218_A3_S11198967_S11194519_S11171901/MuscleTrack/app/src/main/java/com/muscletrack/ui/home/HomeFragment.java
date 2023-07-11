package com.muscletrack.ui.home;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.muscletrack.ExerciseEntity;
import com.muscletrack.R;
import com.muscletrack.databinding.FragmentHomeBinding;

import java.util.List;

public class HomeFragment extends Fragment implements HomeAdapter.ItemClicked{

    private FragmentHomeBinding binding;
    HomeViewModel homeViewModel;
    HomeAdapter homeAdapter;
    RecyclerView recyclerView;
    SearchView searchView;
    Context context;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        homeAdapter = new HomeAdapter(this);
        recyclerView = view.findViewById(R.id.Workout);
        recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        homeViewModel.getAllExercise().observe(getViewLifecycleOwner(), new Observer<List<ExerciseEntity>>() {
            @Override
            public void onChanged(List<ExerciseEntity> exerciseEntities) {
                if(exerciseEntities.size() > 0)
                {
                    homeAdapter.setData(exerciseEntities);
                    recyclerView.setAdapter(homeAdapter);
                }
            }
        });
    }

    public void updateExercise(final ExerciseEntity exerciseEntity){
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        View view1 = getLayoutInflater().inflate(R.layout.activity_update, null);
        Button update_button = view1.findViewById(R.id.update_button);
        EditText reps_update = view1.findViewById(R.id.repsUpdate);
        EditText weight_update = view1.findViewById(R.id.weightUpdate);
        EditText exercise_update = view1.findViewById(R.id.exerciseUpdate);
        EditText sets_update = view1.findViewById(R.id.setsUpdate);

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exerciseEntity.setSets(Integer.parseInt(sets_update.getText().toString().trim()));
                exerciseEntity.setExercise(exercise_update.getText().toString().trim());
                exerciseEntity.setWeight(weight_update.getText().toString().trim());
                exerciseEntity.setReps(Integer.parseInt(reps_update.getText().toString().trim()));
                homeViewModel.updateTx(exerciseEntity);
            }
        });

        builder.setView(view1);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();


    }
    @Override
    public void updateClicked(ExerciseEntity exerciseEntity) {
        updateExercise(exerciseEntity);
    }

    @Override
    public void deleteClicked(ExerciseEntity exerciseEntity) {
        homeViewModel.deleteTx(exerciseEntity);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }



}