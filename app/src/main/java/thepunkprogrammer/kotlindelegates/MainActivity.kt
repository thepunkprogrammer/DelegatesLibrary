package thepunkprogrammer.kotlindelegates

import android.content.Context
import android.database.sqlite.SQLiteClosable
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import thepunkprogrammer.kotlindelegateasync.BackgroundWork
import thepunkprogrammer.kotlindelegateasync.Completion
import thepunkprogrammer.kotlindelegateasync.async
import java.net.ServerSocket
import java.util.concurrent.Executor

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        this toast "hello"
        this TOAST "Long toast"

        this debug ("Tag" to "message")
        this info ("Tag" to "message")
        this error ("tag" to "message")
        this verbose ("tag" to "message")


        fab onclick {

        }

        fab onlongClick {

            true
        }

        fab ontouch {
            _, _ -> true
        }

        async<String> {
            executeInBackground(this@MainActivity, object: BackgroundWork<String>{
                override fun doinBackGround() = "hello world"

            }, object: Completion<String> {
                override fun onerror(context: Context?, e: Exception?) {
                }

                override fun onsuccess(context: Context?, result: String?) {
                }

            })
        }

        Handler() now { this info ("Handler" to "Handled") }

        fireActivity(this, MainActivity::class.java){finish()}

        Quadruple("hello", 1, "true", 3)

        val hello = "Hello" and "world" combine  ("Steve" and "Jobs")
        hello.toList() lastIndexOf "Jobs"

        hello.toList() forEachIndexed { index, s ->
            println(" $index and  $s")
        }

        hello.toList() indexOf "world"

        1 until 1000 forEach {
            println(it)
        }


        val socket = ServerSocket()
        socket using {

        }

        hello.toString()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

}
