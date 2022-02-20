package app.dimitris.tools.volumecontrol

import android.media.AudioManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import app.dimitris.tools.volumecontrol.ui.theme.VolumeControlTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VolumeControlTheme(darkTheme = true) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   ShowAudioUiButton(audioManager)
                }
            }
        }
    }
}

@Composable
fun ShowAudioUiButton(
    audioManager: AudioManager
) {
    Box(contentAlignment = Alignment.Center) {
        Button(onClick = audioManager::showControls) {
            Text(text = "Show Audio Controls")
        }
    }
}