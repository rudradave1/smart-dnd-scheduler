package com.example.smartdndscheduler.alarm

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.provider.Settings
import android.widget.Toast
import androidx.core.app.NotificationManagerCompat

class AlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!notificationManager.isNotificationPolicyAccessGranted) {
                // If permission not granted, show a toast or open settings
                Toast.makeText(
                    context,
                    "DND access not granted. Please enable it in settings.",
                    Toast.LENGTH_LONG
                ).show()

                val settingsIntent = Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS)
                settingsIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(settingsIntent)
                return
            }

            // Toggle DND mode ON
            notificationManager.setInterruptionFilter(NotificationManager.INTERRUPTION_FILTER_NONE)

            // Optional: log or notify user
            Toast.makeText(
                context,
                "DND mode activated by Smart DND Scheduler",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
