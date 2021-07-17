package net.geeksempire.balloon.optionsmenu

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import net.geeksempire.balloon.optionsmenu.databinding.BalloonOptionsMenuSampleLayoutBinding
import net.geeksempire.balloon.optionsmenu.library.BalloonItemsAction
import net.geeksempire.balloon.optionsmenu.library.BalloonOptionsMenu
import net.geeksempire.balloon.optionsmenu.library.Circular.CircleMenuView
import net.geeksempire.balloon.optionsmenu.library.Utils.dpToPixel

class BalloonOptionsMenuPhone : AppCompatActivity() {

    lateinit var balloonOptionsMenuLayoutBinding: BalloonOptionsMenuSampleLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        balloonOptionsMenuLayoutBinding = BalloonOptionsMenuSampleLayoutBinding.inflate(layoutInflater)
        setContentView(balloonOptionsMenuLayoutBinding.root)

        val circularOptionMenu = CircleMenuView(this@BalloonOptionsMenuPhone,
            arrayListOf(getDrawable(R.drawable.message_icon), getDrawable(R.drawable.message_icon), getDrawable(R.drawable.message_icon), getDrawable(R.drawable.message_icon), getDrawable(R.drawable.message_icon), getDrawable(R.drawable.message_icon)),
            arrayListOf(Color.GREEN, Color.BLUE, Color.MAGENTA, Color.GREEN, Color.BLUE, Color.MAGENTA))

        circularOptionMenu.distance = dpToPixel(applicationContext, 51f)

        balloonOptionsMenuLayoutBinding.circularOptionContainer.addView(circularOptionMenu)

        circularOptionMenu.setEventListener(object : CircleMenuView.EventListener() {
            override fun onMenuOpenAnimationStart(view: CircleMenuView) {
                Log.d("D", "onMenuOpenAnimationStart")
            }

            override fun onMenuOpenAnimationEnd(view: CircleMenuView) {
                Log.d("D", "onMenuOpenAnimationEnd")
            }

            override fun onMenuCloseAnimationStart(view: CircleMenuView) {
                Log.d("D", "onMenuCloseAnimationStart")
            }

            override fun onMenuCloseAnimationEnd(view: CircleMenuView) {
                Log.d("D", "onMenuCloseAnimationEnd")
            }

            override fun onButtonClickAnimationStart(view: CircleMenuView, index: Int) {
                Log.d("D", "onButtonClickAnimationStart| index: $index")
            }

            override fun onButtonClickAnimationEnd(view: CircleMenuView, index: Int) {
                Log.d("D", "onButtonClickAnimationEnd| index: $index")
            }
        })


        balloonOptionsMenuLayoutBinding.balloonOptionsMenuTest.setOnClickListener { anchorView ->

            BalloonOptionsMenu(context = this@BalloonOptionsMenuPhone,
                rootView = balloonOptionsMenuLayoutBinding.rootView,
                balloonItemsAction = object : BalloonItemsAction {

                    override fun onBalloonItemClickListener(balloonOptionsMenu: BalloonOptionsMenu, balloonOptionsRootView: View, itemView: View) {
                        Log.d(this@BalloonOptionsMenuPhone.javaClass.simpleName, itemView.tag.toString())

                        balloonOptionsMenu.removeBalloonOption()

                    }

            }).initializeBalloonPosition(anchorView = anchorView)
                .setupOptionsItems(arrayListOf("One", "Two", "Three"))

        }

    }
}