package net.geeksempire.balloon.optionsmenu

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import net.geeksempire.balloon.optionsmenu.databinding.BalloonOptionsMenuLayoutBinding
import net.geeksempire.balloon.optionsmenu.library.BalloonItemsAction
import net.geeksempire.balloon.optionsmenu.library.BalloonOptionsMenu
import net.geeksempire.balloon.optionsmenu.library.Circular.CircularMenuDataStructure
import net.geeksempire.balloon.optionsmenu.library.Circular.CircularOptionMenu

class BalloonOptionsMenuPhone : AppCompatActivity() {

    lateinit var balloonOptionsMenuLayoutBinding: BalloonOptionsMenuLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        balloonOptionsMenuLayoutBinding = BalloonOptionsMenuLayoutBinding.inflate(layoutInflater)
        setContentView(balloonOptionsMenuLayoutBinding.root)

        CircularOptionMenu(context = this@BalloonOptionsMenuPhone,
            rootView = balloonOptionsMenuLayoutBinding.rootView,
            optionContainerView = balloonOptionsMenuLayoutBinding.circularOptionContainer,
            arrayListOf(CircularMenuDataStructure(getDrawable(android.R.drawable.sym_contact_card)))
        )

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