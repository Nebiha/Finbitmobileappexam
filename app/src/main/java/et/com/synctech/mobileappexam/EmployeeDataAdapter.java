package et.com.synctech.mobileappexam;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EmployeeDataAdapter extends RecyclerView.Adapter<EmployeeDataAdapter.ViewHolder> {
    private ArrayList<EmployeeModel> data;
    public EmployeeDataAdapter(ArrayList<EmployeeModel> data) {
       this.data = data;

    }
    @Override
    public EmployeeDataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EmployeeDataAdapter.ViewHolder viewHolder, int position) {

        viewHolder.emp_name_txt.setText(data.get(position).getEmployee_name());
        viewHolder.emp_age_txt.setText(data.get(position).getEmployee_age());
        viewHolder.emp_salary_txt.setText(data.get(position).getEmployee_salary());
        viewHolder.emp_img_view.setImageResource(R.drawable.user);
//        viewHolder.tv_version.setText(android.get(i).getVer());


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView emp_name_txt, emp_age_txt, emp_salary_txt;
        private ImageView emp_img_view ;
        public ViewHolder(View view) {
            super(view);
            emp_name_txt = view.findViewById(R.id.emp_name);
            emp_age_txt = view.findViewById(R.id.emp_age);
            emp_salary_txt = view.findViewById(R.id.emp_salary);
            emp_img_view = view.findViewById(R.id.emp_img);

        }
    }
   }
