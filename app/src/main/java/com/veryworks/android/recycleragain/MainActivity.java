package com.veryworks.android.recycleragain;

import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1. 런타임 권한체크
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkPermission();
        }else{
            init();
        }
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void checkPermission(){
        if(checkSelfPermission(android.Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED){
            init();
        }else{
            String perms[] = {android.Manifest.permission.READ_CONTACTS};
            requestPermissions(perms, 100);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == 100){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                init();
            }else{
                Toast.makeText(getBaseContext(), "권한을 승인하셔야 앱을 사용할 수 있습니다.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void init(){
        // 1. 데이터
        List<A_Data> datas = B_Loader.getData(getBaseContext());
        // 2. 아답터
        C_Adapter adapter = new C_Adapter(datas);
        // 3. 리스트뷰와 아답터 연결
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        // 4. 레이아웃 매니저
        //recyclerView.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        //recyclerView.setLayoutManager(new GridLayoutManager(getBaseContext(),2));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));

    }
}
