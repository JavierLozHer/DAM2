package edu.iesam.dam2.app.presentation.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import edu.iesam.dam2.app.presentation.hide
import edu.iesam.dam2.app.presentation.visible
import edu.iesam.dam2.databinding.ViewErrorBinding

class ErrorAppView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null
) : FrameLayout(context, attrs) {

    private val binding = ViewErrorBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        hide()
    }

    fun render(errorAppUI: ErrorAppUI) {
        binding.apply {
            imgError.setImageResource(errorAppUI.getImageError())
            titleError.text = errorAppUI.getTitleError()
            titleDescription.text = errorAppUI.getDescriptionError()
            visible()
        }
    }
}