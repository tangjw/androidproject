package zonsim.tangjunwei.android.nestedscroll;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import java.util.List;

import zonsim.tangjunwei.android.R;

/**
 * @author hiphonezhu@gmail.com
 * @version [NestedScrolling, 16/9/13 14:50]
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context mContext;
    List<String> mDatas;
    
    public MyAdapter(Context context, List<String> datas) {
        mContext = context;
        mDatas = datas;
    }
    
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item, parent, false));
    
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext.getApplicationContext(), "haha " + myViewHolder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            }
        });
    
        return myViewHolder;
    }
    
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv.setText(mDatas.get(position));
    }
    
    @Override
    public int getItemCount() {
        return mDatas != null ? mDatas.size() : 0;
    }
    
    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        
        public MyViewHolder(View view) {
            super(view);
            tv = view.findViewById(R.id.tv_item);
        }
    }
}
