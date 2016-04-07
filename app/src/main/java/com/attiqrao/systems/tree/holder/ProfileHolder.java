package com.attiqrao.systems.tree.holder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.attiqrao.systems.tree.model.TreeNode;
import com.example.attiqurrehmanrao.myapplication.R;
import com.github.johnkil.print.PrintView;

/**
 * Created by Attiq ur Rehman on 06/06/16
 */
public class ProfileHolder extends TreeNode.BaseNodeViewHolder<IconTreeItemHolder.IconTreeItem> {


    public ProfileHolder(Context context) {
        super(context);
    }

    @Override
    public View createNodeView(TreeNode node, IconTreeItemHolder.IconTreeItem value) {
        final LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(R.layout.layout_profile_node, null, false);
        TextView tvValue = (TextView) view.findViewById(R.id.node_value);
        tvValue.setText(value.text);

        final PrintView iconView = (PrintView) view.findViewById(R.id.icon);
        iconView.setIconText(context.getResources().getString(value.icon));

        return view;
    }

    @Override
    public void toggle(boolean active) {
    }

    @Override
    public int getContainerStyle() {
        return R.style.TreeNodeStyleCustom;
    }
}