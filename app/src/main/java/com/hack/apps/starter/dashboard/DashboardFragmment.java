package com.hack.apps.starter.dashboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hack.apps.starter.R;
import com.hack.apps.starter.adapter.ProjectAdapter;
import com.hack.apps.starter.model.ProjectModel;
import com.hack.apps.starter.util.BundleUtil;
import com.hack.apps.starter.util.FragmentUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class DashboardFragmment extends Fragment {
    public static String TAG="DashboardFragmment";

    @BindView(R.id.projects_list_view)
    ListView projectListView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        ButterKnife.bind(this, view);
        //Todo delete
        initProjectList();
        //
        makeProjectsRequest();

        return view;
    }

    void initProjectList(){
        List<ProjectModel> model=new ArrayList<>();

        for(int i=0;i<10;i++){
            ProjectModel m=new ProjectModel(i,getString(R.string.project_name),getString(R.string.project_description),null);
            model.add(m);
            Log.i(TAG,m.toString());
        }
        try{
            projectListView.setAdapter(new ProjectAdapter(getActivity(),model));

        }catch (Exception e){
            Log.e(TAG,e.getMessage());
        }
    }

    @OnItemClick(R.id.projects_list_view)
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        ProjectModel model = (ProjectModel) adapterView.getItemAtPosition(i);
        int id = model.getId();
        String name = model.getName();
        String description = model.getDescription();
        String photo = model.getImageUri();
        FragmentUtil.replaceFragment(getActivity(), DashboardDetailFragmment.class, BundleUtil.getBundle(id, name, description, photo), true);
    }

    private void makeProjectsRequest(){

    }
}
