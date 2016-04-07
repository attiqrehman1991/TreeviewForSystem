package com.attiqrao.systems.tree.holder;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.attiqrao.systems.tree.model.TreeNode;
import com.example.attiqurrehmanrao.myapplication.R;
import com.github.johnkil.print.PrintView;

import java.lang.ref.WeakReference;

/**
 * Created by Attiq ur Rehman on 06/06/16
 */
public class IconTreeItemHolder extends TreeNode.BaseNodeViewHolder<IconTreeItemHolder.IconTreeItem> {
    private TextView tvValue;
    private PrintView arrowView;

    public IconTreeItemHolder(Context context) {
        super(context);
    }

    public void showRemoveConfirmationBox(final Context ctx, final TreeNode node) {
        WeakReference<Context> weakReference = new WeakReference<Context>(ctx);
        new AlertDialog.Builder(weakReference.get())
                .setTitle("Alert!")
                .setIcon(R.mipmap.ic_launcher)
                .setMessage("You will lose all child " + node.getChildren().size())
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        removeNode(node);
                        dialog.dismiss();
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        dialog.dismiss();
                    }
                })
//                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public void showAddConfirmationBox(final Context ctx, final TreeNode node) {
        final EditText input = new EditText(context);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);

        WeakReference<Context> weakReference = new WeakReference<Context>(ctx);
        new AlertDialog.Builder(weakReference.get())
                .setTitle("Enter element name")
                .setIcon(R.mipmap.ic_launcher)
                .setView(input)
                .setCancelable(false)
                .setMessage("Enter element name")
                .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        if (input.getText().toString().isEmpty()) {
                            input.setError("Enter element name");
                        } else {
                            addNode(node, input.getText().toString());
                            dialog.dismiss();
                        }
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                        dialog.dismiss();
                    }
                })
//                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    @Override
    public View createNodeView(final TreeNode node, IconTreeItem value) {
        final LayoutInflater inflater = LayoutInflater.from(context);
        final View view = inflater.inflate(R.layout.layout_icon_node, null, false);
        tvValue = (TextView) view.findViewById(R.id.node_value);
        tvValue.setText(value.text);

        final PrintView iconView = (PrintView) view.findViewById(R.id.icon);
        iconView.setIconText(context.getResources().getString(value.icon));

        arrowView = (PrintView) view.findViewById(R.id.arrow_icon);

        view.findViewById(R.id.btn_addFolder).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddConfirmationBox(context, node);
            }
        });

        view.findViewById(R.id.btn_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRemoveConfirmationBox(context, node);
            }
        });

        //if My computer
        if (node.getLevel() == 1) {
            view.findViewById(R.id.btn_delete).setVisibility(View.GONE);
        }

        return view;
    }

    private void addNode(TreeNode node, String name) {
        TreeNode newFolder = new TreeNode(new IconTreeItemHolder.IconTreeItem(R.string.ic_zone, name));
        getTreeView().addNode(node, newFolder);
    }

    private void removeNode(TreeNode node) {
        getTreeView().removeNode(node);
    }

    @Override
    public void toggle(boolean active) {
        arrowView.setIconText(context.getResources().getString(active ? R.string.ic_keyboard_arrow_down : R.string.ic_keyboard_arrow_right));
    }

    public static class IconTreeItem {
        public int icon;
        public String text;

        public IconTreeItem(int icon, String text) {
            this.icon = icon;
            this.text = text;
        }
    }
}
