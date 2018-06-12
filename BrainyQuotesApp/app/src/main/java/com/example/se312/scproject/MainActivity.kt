package com.example.se312.scproject

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.JsonHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.json.JSONArray
import org.json.JSONObject
import android.graphics.Typeface
import android.support.v7.widget.CardView
import android.util.TypedValue
import android.widget.*
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_attendance)

        val client = AsyncHttpClient()
        client.get("https://se312-a3502.firebaseio.com/Quotes.json", object : JsonHttpResponseHandler() {

            override fun onStart() {
                // called before request is started
            }

            override fun onSuccess(statusCode: Int, headers: Array<Header>, response: JSONObject) {
                Toast.makeText(this@MainActivity,"Succesfully received object", Toast.LENGTH_SHORT).show()
            }

            override fun onSuccess(statusCode: Int, headers: Array<Header>, timeline: JSONArray) {

                val rootLinearLayout = findViewById<LinearLayout>(R.id.rootLayout)

                for (i in 0 until timeline.length()){

                    val cardView = CardView(this@MainActivity)
                    val cardViewParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                    cardViewParams.setMargins(16, 16, 16, 8)
                    cardView.layoutParams=cardViewParams

                    val LL = LinearLayout(this@MainActivity)
                    LL.orientation= LinearLayout.VERTICAL
                    LL.layoutParams = cardViewParams


                    val individualQuoteObject = timeline.getJSONObject(i)

                    val Topic = TextView(this@MainActivity)
                    val Author = TextView(this@MainActivity)
                    val Quote = TextView(this@MainActivity)
                    val params = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT)
                    params.setMargins(10, 10, 10, 10)

                    val imageView = findViewById(R.id.imageView) as ImageView
                    Glide.with(cardView).load("https://www.brainyquote.com//st/img/2813245/brainyquote_sl@2x.png").into(imageView);
                    Author.setText(individualQuoteObject.getString("Author"))
                    Author.setTextSize(TypedValue.COMPLEX_UNIT_SP,22F);
                    Author.setTypeface(Author.getTypeface(), Typeface.BOLD)
                    Author.setTextColor(resources.getColor(R.color.colorHEAD))
                    Author.setLayoutParams(params)


                    Topic.setText("Topics: " +individualQuoteObject.getString("Topic"))
                    Topic.setTextSize(TypedValue.COMPLEX_UNIT_SP,17F);
                    Topic.setTextColor(resources.getColor(R.color.colorPrimary))
                    Topic.setLayoutParams(params)


                    Quote.setText("Quote: " +individualQuoteObject.getString("Quote"))
                    Quote.setTextSize(TypedValue.COMPLEX_UNIT_SP,17F);
                    Quote.setTextColor(resources.getColor(R.color.colorHEAD))
                    Author.setTypeface(Quote.getTypeface(), Typeface.ITALIC)
                    Quote.setLayoutParams(params)

                    LL.addView(Topic)
                    LL.addView(Quote)

                    cardView.addView(LL)
                    rootLinearLayout.addView(Author)
                    rootLinearLayout.addView(cardView)

                }
            }

            override fun onFailure(statusCode: Int, headers: Array<out Header>?, throwable: Throwable?, errorResponse: JSONArray?) {
                super.onFailure(statusCode, headers, throwable, errorResponse)
            }
        })
    }

    override fun onBackPressed() {
        // do nothing0
    }
 }

