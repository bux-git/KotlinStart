package com.zx.kotlinstart

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var clickCount: Int = 0;

    lateinit var mEtUserName: EditText;
    lateinit var mEtPassWord: EditText;
    lateinit var mIvCode: ImageView;
    lateinit var mBtnLogin: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mEtUserName = findViewById(R.id.et_username)
        mEtPassWord = findViewById(R.id.et_password)
        mIvCode = findViewById(R.id.iv_code)
        mBtnLogin = findViewById(R.id.btn_login)

        mIvCode.setOnClickListener(this)
        mBtnLogin.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        clickCount++
        if (v is ImageView) {
            var resId: Int = R.drawable.ic_down;
            if (clickCount % 2 == 0) {
                resId = R.drawable.ic_up;
            }
            mIvCode.setImageResource(resId)
        } else if (v is Button) {
            login();
        }
    }

    fun login(): Boolean {
        val userName = mEtUserName.text.toString()
        val password = mEtPassWord.text.toString()

        var user: User = User(userName,password ,null)
        if (user.userName?.length!! > 4
            && user.passWord?.length!! > 4
        ) {
            startActivity(Intent(this, SecondActivity::class.java))
            return true;
        }
        Toast.makeText(this, "不符合规格", Toast.LENGTH_SHORT).show()

        return false;
    }


}
