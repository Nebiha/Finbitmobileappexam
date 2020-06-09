package et.com.synctech.mobileappexam;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EmployeeGet {

    String BASE_URL = "http://dummy.restapiexample.com";
    @GET("/api/v1/employees")
    Call<EmployeeJSONResponce> getEmployeeJSON();
}
