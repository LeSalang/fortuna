package com.lesa.fortuna

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.lesa.fortuna.ui.screens.FortunaViewModel
import com.lesa.fortuna.ui.screens.MainScreen
import com.lesa.fortuna.ui.theme.Blue
import com.lesa.fortuna.ui.theme.FortunaTheme
import dagger.hilt.android.AndroidEntryPoint


class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<FortunaViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.createSound(this)

        setContent {
            FortunaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Blue
                ) {
                    MainScreen(
                        viewModel = viewModel,
                        context = this
                    )
                }
            }
        }
    }
}
