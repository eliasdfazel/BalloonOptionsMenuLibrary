package net.geeksempire.balloon.optionsmenu.library.Circular

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import net.geeksempire.balloon.optionsmenu.library.Utils.calculateCircumference
import net.geeksempire.balloon.optionsmenu.library.Utils.dpToFloat
import net.geeksempire.balloon.optionsmenu.library.databinding.CircularOptionItemBinding
import net.geeksempire.balloon.optionsmenu.library.databinding.CircularOptionsMenuLayoutBinding
import kotlin.math.cos
import kotlin.math.roundToInt
import kotlin.math.sin

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

        circularOptionsMenuLayoutBinding.circularOptionMenu.setOnClickListener {

            addMenuItems()

        }

    }

    fun addMenuItems() {

        (1..6).forEach { itemIndex ->

            val circularOptionItemBinding: CircularOptionItemBinding = CircularOptionItemBinding.inflate(context.layoutInflater)

            val itemPosition = calculateItemsPosition(itemIndex, circularOptionItemBinding)

            circularOptionItemBinding.root.x = itemPosition.first
            circularOptionItemBinding.root.y = itemPosition.second

            rootView.addView(circularOptionItemBinding.root)

        }

    }

    private fun calculateItemsPosition(itemIndex: Int, circularOptionItemBinding: CircularOptionItemBinding) : Pair<Float, Float> {

        val centerPointX = optionContainerView.x + (circularOptionItemBinding.rootViewItem.width)
        val centerPointY = optionContainerView.y + (circularOptionItemBinding.rootViewItem.height)

        val positionX = (centerPointX + dpToFloat(context, 53) //Radius
                * cos((itemIndex).toDouble())).toFloat() //Angle

        val positionY = (centerPointY + dpToFloat(context, 53) //Radius
                * sin((itemIndex).toDouble())).toFloat()//Angle

        return Pair(positionX, positionY)
    }

    private fun calculateMaximumNumberOfItem(circleRadius: Float, itemWidth: Int) : Int {

        return (calculateCircumference(circleRadius)/itemWidth).roundToInt()
    }

}