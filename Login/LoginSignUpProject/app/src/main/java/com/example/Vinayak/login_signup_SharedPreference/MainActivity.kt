package com.example.rebelbob11.login_signup

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    lateinit var email:String
    lateinit var password:String

    private lateinit var mAuth:FirebaseAuth

    lateinit var sharedPreferences:SharedPreferences




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        mAuth = FirebaseAuth.getInstance()
        sharedPreferences = getSharedPreferences("User Info",Context.MODE_PRIVATE)


        get_user()


        btn_login.setOnClickListener {


            if (!sharedPreferences.contains("EMAIL")){

                email = text_email.text.toString()
                password = text_password.text.toString()

                if (chck_remember.isChecked){
                    remember_user(email,password)

                }

                login_user(email,password)

            }
            else{

                get_user()
            }







        }


        btn_signup.setOnClickListener {

            email = text_email.text.toString()
            password = text_password.text.toString()

            signup_user(email,password)


        }
    }

    private fun get_user() {


        sharedPreferences = getSharedPreferences("User Info",Context.MODE_PRIVATE)
        val eml = sharedPreferences.getString("EMAIL"," ")
        val pwd = sharedPreferences.getString("PASSWORD"," ")

        login_user(eml,pwd);




    }

    private fun remember_user(email: String, password: String) {

        sharedPreferences = getSharedPreferences("User Info",Context.MODE_PRIVATE)

        val editor = sharedPreferences.edit()
        editor.putString("EMAIL",email)
        editor.putString("PASSWORD",password)
        editor.apply()

    }

    private fun signup_user(email: String, password: String) {

        progressBar.visibility = View.VISIBLE
        btn_login.visibility = View.INVISIBLE

        mAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, OnCompleteListener<AuthResult>{ task ->

                    if (task.isSuccessful){

                        progressBar.visibility = View.INVISIBLE

                        var userintent = Intent(applicationContext,LoggedInActivity::class.java)
                        userintent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                        startActivity(userintent)


                    }
                    else {

                        progressBar.visibility = View.INVISIBLE
                        btn_login.visibility = View.VISIBLE

                        Toast.makeText(applicationContext,""+task.exception,Toast.LENGTH_SHORT).show()

                    }
                })

        Toast.makeText(applicationContext,"Email: " + email + "\nPassword: "+ password,Toast.LENGTH_SHORT).show()

    }

    private fun login_user(email: String, password: String) {


        Toast.makeText(applicationContext,"Email: " + email + "\nPassword: "+ password,Toast.LENGTH_SHORT).show()

    }

    var  myrv: RecyclerView = findViewById<RecyclerView>(R.id.recyclerView)
    myrv.layoutManager = LinearLayoutManager(this,RecyclerView.VERTICAL,false)

    var myDataList =  ArrayList<UserData>()
    myDataList.add(UserData("Jai","jaiDubai@mango.com","7777777777"))
    myDataList.add(UserData("Vishal","jaiDubaifdfd@mango.com","777743777777"))
    myDataList.add(UserData("Jai","jaiDubadsfi@mango.com","777777777dfd7"))
    myDataList.add(UserData("Bataiye","jaiDubfdai@mdfdango.com","77777777dsf77"))
    myDataList.add(UserData("Jai","jaiDubai@mango.com","7777777777"))
    myDataList.add(UserData("Vishal","jaiDubaifdfd@mango.com","777743777777"))
    myDataList.add(UserData("JaiLol","jaiDubadsfi@mango.com","777777777dfd7"))
    myDataList.add(UserData("Bataiye","jaiDubfdai@mdfdango.com","77777777dsf77"))



    myrv.adapter = MyAdapter(myDataList)

}
