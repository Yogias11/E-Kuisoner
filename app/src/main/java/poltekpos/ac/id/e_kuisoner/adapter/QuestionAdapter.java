package poltekpos.ac.id.e_kuisoner.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import poltekpos.ac.id.e_kuisoner.R;
import poltekpos.ac.id.e_kuisoner.model.Question;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.HolderData> {

    private List<Question> listQuestion;
    private Context context;


    public QuestionAdapter(Context context, List<Question> listQuestion) {
        this.context = context;
        this.listQuestion = listQuestion;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_pertanyaan,parent, false);
        HolderData holder = new HolderData(layout);
        return holder;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        Question question = listQuestion.get(position);
        holder.txtPertanyaan.setText(question.getPertanyaan());
        holder.question = question;
    }

    @Override
    public int getItemCount() {
        return listQuestion.size();
    }


    class HolderData extends  RecyclerView.ViewHolder{
        TextView txtPertanyaan;
        Question question;
        HolderData(View v) {
            super(v);

            txtPertanyaan  = v.findViewById(R.id.question);
        }
    }
}