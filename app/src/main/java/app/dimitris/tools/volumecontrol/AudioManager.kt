package app.dimitris.tools.volumecontrol

import android.content.Context
import android.media.AudioManager

val Context.audioManager: AudioManager
    get() = getSystemService(Context.AUDIO_SERVICE) as AudioManager

fun AudioManager.showControls() = adjustVolume(AudioManager.ADJUST_SAME, AudioManager.FLAG_SHOW_UI)