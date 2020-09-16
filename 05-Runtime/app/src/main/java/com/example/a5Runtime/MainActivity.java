package com.example.a5Runtime;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    EditText codeView;
    Button runView;
    TextView showView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.codeView = this.findViewById(R.id.code);
        this.runView = this.findViewById(R.id.run);
        this.showView = this.findViewById(R.id.show);
        this.runView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    MainActivity.this.run();
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void run() throws IOException, InterruptedException {

        // 获取继承于当前运行环境的子进程，也可选择不继承直接exec（）运行shell
        Process process = Runtime.getRuntime().exec("sh"); //sh 无root su root

        // 获取输出流，同于输入
        DataOutputStream os;
        os = new DataOutputStream(process.getOutputStream());
        for (String command : new String[]{String.valueOf(this.codeView.getText())}) {
            if (command == null) {
                continue;
            }
            os.write(command.getBytes());
            os.writeBytes("\n");
            os.flush();
        }
        os.writeBytes("exit\n");
        os.flush();

        // 等待线程结束，返回结果码
        int result = process.waitFor();

        // 获取输入流同于结果输出
        BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String data = null;
        String line;
        while ((line = in.readLine()) != null
                && !line.equals("null")) {
            data += line + "\n";
        }
        Toast.makeText(this.getApplicationContext(), String.valueOf(result), Toast.LENGTH_SHORT).show();
        this.showView.setText(String.valueOf(data));
    }
}