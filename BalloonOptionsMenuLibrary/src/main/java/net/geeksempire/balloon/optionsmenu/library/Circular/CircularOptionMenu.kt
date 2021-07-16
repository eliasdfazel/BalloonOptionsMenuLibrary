package net.geeksempire.balloon.optionsmenu.library.Circular

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import net.geeksempire.balloon.optionsmenu.library.Utils.dpToInteger
import net.geeksempire.balloon.optionsmenu.library.databinding.CircularOptionItemBinding
import net.geeksempire.balloon.optionsmenu.library.databinding.CircularOptionsMenuLayoutBinding

class CircularOptionMenu (private val context: AppCompatActivity,
                          private val rootView: ConstraintLayout,
                          private val optionContainerView: ConstraintLayout,
                          private val circularMenuDataList: ArrayList<CircularMenuDataStructure>
) {

    private val circularOptionsMenuLayoutBinding: CircularOptionsMenuLayoutBinding = CircularOptionsMenuLayoutBinding.inflate(context.layoutInflater)

    init {

        optionContainerView.background = null
        optionContainerView.setBackgroundColor(Color.TRANSPARENT)

        optionContainerView.addView(circularOptionsMenuLayoutBinding.root)

        circularOptionsMenuLayoutBinding.rootView.setOnClickListener {

            addMenuItems()

        }

    }

    fun addMenuItems() {

        (1..3).forEach { index ->

            val circularOptionItemBinding: CircularOptionItemBinding = CircularOptionItemBinding.inflate(context.layoutInflater)

            val itemPosition = calculateItemsPosition(index)

            circularOptionItemBinding.root.x = itemPosition.first
            circularOptionItemBinding.root.y = itemPosition.second

            rootView.addView(circularOptionItemBinding.root)

        }

    }

    private fun calculateItemsPosition(itemIndex: Int) : Pair<Float, Float> {

        val positionX = optionContainerView.x - dpToInteger(context, 5 * itemIndex)
        val positionY = optionContainerView.y - dpToInteger(context, 5 * itemIndex)

        return Pair(positionX, positionY)
    }

}