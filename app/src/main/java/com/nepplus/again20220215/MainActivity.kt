package com.nepplus.again20220215

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

//    모든 함수에서 공유할 수 있는 변수. (멤버변수)

    val REQ_CODE_NICKNAME = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMoveToOtherActivity.setOnClickListener {
            val myIntent = Intent(this,OtherActivity::class.java)
            startActivity(myIntent)
        }
        btnSendMessage.setOnClickListener {
            val inputMessage = edtMessage.text.toString()

            val myIntent = Intent(this, ViewMessage::class.java)
            myIntent.putExtra("message", inputMessage)
            startActivity(myIntent)
        }

        btnEditNickname.setOnClickListener {
            val myIntent = Intent(this, EditNicknameActivity::class.java)

//            새로운 닉네임을 받아내러 (결과를 얻으로) 가는 동작
            startActivityForResult(myIntent, REQ_CODE_NICKNAME) // 숫자값으로, 닉네임을 받으러 간다고 구별하는데 사용.
        }
    }
}