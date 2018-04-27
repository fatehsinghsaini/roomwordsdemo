package com.example.android.roomwordsdemo;

/*
 * Copyright (C) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Activity for entering a word.
 */

public class NewWordActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";
    public static final String EXTRA_REPLY_LOC = "com.example.android.wordlistsql.REPLY.LOC";
    public static final String EXTRA_REPLY_ID = "com.example.android.wordlistsql.REPLY.LOC";

    private  EditText mEditWordView;
    private EditText location;
    private EditText idView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);
        idView = findViewById(R.id.id);
        mEditWordView = findViewById(R.id.edit_word);
        location = findViewById(R.id.location);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if (TextUtils.isEmpty(mEditWordView.getText())) {
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String id = idView.getText().toString();
                    String word = mEditWordView.getText().toString();
                    String locValue = location.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY_ID, id);
                    replyIntent.putExtra(EXTRA_REPLY, word);
                    replyIntent.putExtra(EXTRA_REPLY_LOC, locValue);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}

