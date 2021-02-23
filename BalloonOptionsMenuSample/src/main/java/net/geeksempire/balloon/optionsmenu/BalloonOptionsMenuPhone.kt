package net.geeksempire.balloon.optionsmenu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import net.geeksempire.balloon.optionsmenu.databinding.BalloonOptionsMenuLayoutBinding

class BalloonOptionsMenuPhone : AppCompatActivity() {

    lateinit var balloonOptionsMenuLayoutBinding: BalloonOptionsMenuLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        balloonOptionsMenuLayoutBinding = BalloonOptionsMenuLayoutBinding.inflate(layoutInflater)
        setContentView(balloonOptionsMenuLayoutBinding.root)

        balloonOptionsMenuLayoutBinding.balloonOptionsMenuTest.setOnClickListener {



        }

    }
}