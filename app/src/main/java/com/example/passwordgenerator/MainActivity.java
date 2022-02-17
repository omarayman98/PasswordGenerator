package com.example.passwordgenerator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.passwordgenerator.databinding.ActivityMainBinding;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityMainBinding.inflate(getLayoutInflater());
       AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

    }
    public void generate(View view ){
        boolean first=true;
        if(view==binding.generatePass){

                StringBuilder pass= new StringBuilder();
                Random random=new Random();
                String[] chars={"a","A","b","B","c","C","d","D","e","E"
                        ,"f","F","g","G","h","H","i","I","j","J","k","K"
                        ,"l","L","m","M","n","N","o","O","p","P","q","Q"
                        ,"r","R","s","S","t","T","u","U","v","V","x","X"
                        ,"y","Y","z","Z","!","@","$","%","&","*","_","?"
                ,"1","2","3","4","5","6","7","8","9"};
                for(int i=0;i<12;i++){
                    int nextChar=random.nextInt(chars.length - 1 + 1);
                    pass.append(chars[nextChar]);
                }
                binding.password.setText(pass);

          }else if(view==binding.copy){
            ClipboardManager clipboardManager=(ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clipData =ClipData.newPlainText("Edittext",binding.password.getText().toString());
            clipboardManager.setPrimaryClip(clipData);
            clipData.getDescription();
            Toast.makeText(this, "Copied", Toast.LENGTH_SHORT).show();
        }

         }
    }