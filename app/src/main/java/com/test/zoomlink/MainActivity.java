package com.test.zoomlink;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void GoLink(View view) {
        createJoinMeetingDialog();
    }

    public void GoLinkNew(View view) {
        createLoginDialog();
    }

    private void createJoinMeetingDialog() {
        new AlertDialog.Builder(this).setView(R.layout.dialog_join_meeting).setPositiveButton("Join", new DialogInterface.OnClickListener() {@Override
        public void onClick(DialogInterface dialogInterface, int i) {
            AlertDialog dialog = (AlertDialog) dialogInterface;
            EditText numberInput = dialog.findViewById(R.id.meeting_no_input);
            EditText passwordInput = dialog.findViewById(R.id.password_input);
            if (numberInput != null && numberInput.getText() != null && passwordInput != null && passwordInput.getText() != null) {
                String meetingNumber = numberInput.getText().toString();
                String password = passwordInput.getText().toString();
                if (meetingNumber.trim().length() > 0 && password.trim().length() > 0) {

                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("zoomus://zoom.us/join?confno="+meetingNumber+"&pwd="+password+""));
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }

                }
            }
            dialog.dismiss();
        }
        }).show();
    }

    private void createLoginDialog() {
        new AlertDialog.Builder(this).setView(R.layout.dialog_link).setPositiveButton("Join", new DialogInterface.OnClickListener() {@Override
        public void onClick(DialogInterface dialogInterface, int i) {
            AlertDialog dialog = (AlertDialog) dialogInterface;
            EditText link = dialog.findViewById(R.id.link);
            if (link != null && link.getText() != null) {
                String getlink = link.getText().toString();
                if (getlink.trim().length() > 0 ) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getlink));
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                }
            }
            dialog.dismiss();
        }
        }).show();
    }
}