package app.dimitris.tools.volumecontrol

import android.annotation.SuppressLint
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.media.AudioManager
import android.provider.MediaStore
import android.widget.RemoteViews
import android.widget.Toast

class AudioVolumeControlButtonWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }
    private fun updateAppWidget(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetId: Int
    ) {
        val views = RemoteViews(context.packageName, R.layout.audio_volume_control_button_widget)
        val intent = Intent(context, AudioVolumeControlButtonWidget::class.java).apply {
            action = AppWidgetManager.ACTION_APPWIDGET_UPDATE
        }
        val pendingIntent = PendingIntent.getService(context, 0, intent, 0)
        views.setOnClickPendingIntent(R.id.appwidget_button, pendingIntent)
        appWidgetManager.updateAppWidget(appWidgetId, views)
    }

    @SuppressLint("ShowToast")
    override fun onReceive(context: Context?, intent: Intent?) {
        super.onReceive(context, intent)
        context?.audioManager?.showControls()
    }
}
