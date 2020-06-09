package et.com.synctech.mobileappexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static et.com.synctech.mobileappexam.EmployeeGet.BASE_URL;

public class MainActivity extends AppCompatActivity {

//    private TextView emp_name;
    private RecyclerView recyclerView;
    private ArrayList<EmployeeModel> emp_list;
    private EmployeeDataAdapter emp_data_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        emp_name = findViewById(R.id.emp_name);
        empView();

    }
    private void empView(){
        recyclerView = findViewById(R.id.card_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        getEmployeeJson();
    }
    private void getEmployeeJson(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        EmployeeGet employeeGet = retrofit.create(EmployeeGet.class);
        Call<EmployeeJSONResponce> call = employeeGet.getEmployeeJSON() ;
        call.enqueue(new Callback<EmployeeJSONResponce>() {
            @Override
            public void onResponse(Call<EmployeeJSONResponce> call, Response<EmployeeJSONResponce> emp_response) {
                EmployeeJSONResponce employeeJSONResponce = emp_response.body();
                emp_list = new ArrayList<>(Arrays.asList(employeeJSONResponce.getEmployee()));
                emp_data_adapter = new EmployeeDataAdapter(emp_list);
                recyclerView.setAdapter(emp_data_adapter);
            }

            @Override
            public void onFailure(Call<EmployeeJSONResponce> call, Throwable t) {
                Log.d("Error",t.getMessage());
            }
        });

    }
}
