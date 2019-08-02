package com.zx.kotlinstart

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.zx.kotlinstart.http.ApiService
import com.zx.kotlinstart.http.bean.BaseBean
import com.zx.kotlinstart.http.bean.HomeBean
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val TAG: String = "MainActivity";

    var clickCount: Int = 0;

    lateinit var mEtUserName: EditText;
    lateinit var mEtPassWord: EditText;
    lateinit var mIvCode: CodeView;
    lateinit var mBtnLogin: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mEtUserName = findViewById(R.id.et_username)
        mEtPassWord = findViewById(R.id.et_password)
        mIvCode = findViewById(R.id.iv_code)
        mBtnLogin = findViewById(R.id.btn_login)

        mBtnLogin.setOnClickListener(this)


        var logging = HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        var client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.wanandroid.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()


        val apiService = retrofit.create(ApiService::class.java)

        apiService.getHomeData("0").enqueue(object : Callback<BaseBean<HomeBean>> {
            override fun onFailure(call: Call<BaseBean<HomeBean>>, t: Throwable) {
                Log.d(TAG, t.message)
            }

            override fun onResponse(
                call: Call<BaseBean<HomeBean>>,
                response: Response<BaseBean<HomeBean>>
            ) {
                Log.d(TAG, response.toString())
            }

        })
    }

    override fun onClick(v: View?) {
        clickCount++
        if (v is Button) {
            login();
        }
    }

    fun login(): Boolean {
        val userName = mEtUserName.text.toString()
        val password = mEtPassWord.text.toString()

        var user: User = User(userName, password, null)
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
